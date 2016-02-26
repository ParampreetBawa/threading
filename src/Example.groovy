import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    static ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    static void methodA() {
        Future<Long> future1 = service.submit(new Callable() {
            @Override
            Long call() throws Exception {
                sleep(5000)
                return 50l;
            }
        });

        Future<Long> future2 = service.submit(new Callable() {
            @Override
            Long call() throws Exception {
                sleep(5000)
                return 500l;
            }
        });


        wrapAroundTickClock {future1.get() + future2.get()}

        service.shutdown()
    }

    static void wrapAroundTickClock(Closure closure) {
        long startTime = System.currentTimeMillis();
        closure()
        println("Total Time took - "+ ((System.currentTimeMillis() - startTime) * 1e-3) + " Secs")
    }

    public static void main(String... args) {
        methodA()
    }
}