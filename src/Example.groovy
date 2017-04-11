import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

        Callable r1 = new Callable() {
            public Object call() {
                new URL("https://facebook.com").text
            }
        }

        long t1 = System.currentTimeMillis();
        Future future = service.submit(r1);
        try {
            def text = future.get(1, TimeUnit.MINUTES)
            saveToFile(text)
        }catch (TimeoutException e) {
            System.out.println("Exception")
        }
        System.out.println(System.currentTimeMillis() - t1)

        service.shutdown()
    }

    static void saveToFile(text) {
        def file = File.createTempFile("fab", ".html")
        file.text = text
        System.out.println(file.getAbsolutePath())
    }
}