import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.select.Elements

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.ForkJoinTask
import java.util.concurrent.RecursiveTask

/**
 * Created by parampreet on 11/24/15.
 */
@Grab('org.jsoup:jsoup:1.7.1')
ForkJoinPool forkJoinPool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
SiteMapTask siteMapTask = new SiteMapTask("http://www.tothenew.com");

forkJoinPool.invoke(siteMapTask);
class SiteMapTask extends RecursiveTask<List<String>> {

    String url

    public SiteMapTask(String url) {
        this.url = url
    }

    @Override
    protected List<String> compute() {
        List<String> linksOnPage = collectLinks()

        if (linksOnPage.size() == 0) {
            return linksOnPage
        } else {
            List<SiteMapTask> subTasks = divide(linksOnPage)
            List<ForkJoinTask> forkJoinTaskList = new ArrayList<>();
            for(SiteMapTask subTask : subTasks){
                forkJoinTaskList.add(subTask.fork());
            }

            List<String> links = new ArrayList<>();
            for(ForkJoinTask subTask : forkJoinTaskList) {
                links.addAll(subTask.join());
            }
        }
    }

    protected List<SiteMapTask> divide(List<String> links) {
        List<SiteMapTask> subTasks = new ArrayList<>();
        for(String link: links)
            subTasks.add(new SiteMapTask<>(link))

        subTasks
    }

    protected List<String> collectLinks() {
        List<String> pageLinks = new ArrayList<>();
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            for (Element link : links) {
                println(link)
                pageLinks.add(link.attr("href"))
            }
        }catch (Exception e) {
            //ok for now
        }
        return pageLinks
    }
}