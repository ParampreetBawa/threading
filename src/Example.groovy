import java.util.concurrent.locks.ReentrantLock

/**
 * Created by parampreet on 11/24/15.
 */
class Example {
    final Object lockA = new Object()
    final Object lockB = new Object()
    final ReentrantLock lockC = new ReentrantLock()
    final ReentrantLock lockD = new ReentrantLock()
    void methodA() {
        synchronized (lockA) {
            //Do something with 1 lock
            synchronized (lockB) {
                //do with 2 locks
            }
        }
    }

    void methodB() {
        try {
            lockC.lock()

            lockD.lock()

            lockC.unlock()

            lockD.unlock()
        }finally {
            //un lock if locked
        }
    }

}