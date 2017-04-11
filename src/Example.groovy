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

        Runnable r1 = new Runnable() {
            public void run() {
                sleep(100);
            }
        }

        long t1 = System.currentTimeMillis();
        Future future = service.submit(r1);
        try {
            future.get(10, TimeUnit.MILLISECONDS)
        }catch (TimeoutException e) {
            System.out.println("Exception")
        }
        System.out.println(System.currentTimeMillis() - t1)

        service.shutdown()
    }
}