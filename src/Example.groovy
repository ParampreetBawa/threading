import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future

/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors())

    void methodA() {
        service.execute(new Runnable() {
            @Override
            void run() {
                //do some work like process files
            }
        })

        Future _future = service.submit(new Runnable() {
            @Override
            void run() {
                //do some work like process files
            }
        });



        Future future = service.submit(new Callable() {
            @Override
            Object call() throws Exception {
                return [:]// return some processed output
            }
        });

        future.get();
    }
}