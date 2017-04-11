import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

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
        service.execute(r1);
        System.out.println(System.currentTimeMillis() - t1)

        service.shutdown()
    }
}