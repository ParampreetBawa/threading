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
                sleep(1000)
            }
        }

        Callable r2 = new Callable() {
            public Object call() {
                sleep(1000)
            }
        }

        long t1 = System.currentTimeMillis();

        Future f1 = service.submit(r1);
        try {
            f1.get(100, TimeUnit.MILLISECONDS)
        }catch (TimeoutException e) {
            //ok
        }

        Future f2 = service.submit(r2)
        try {
            f2.get(100, TimeUnit.MILLISECONDS)
        }catch (TimeoutException e) {
            //ok
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