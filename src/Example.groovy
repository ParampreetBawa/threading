import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    final ReentrantLock lock = new ReentrantLock()

    void methodA() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                //read only
            }
        } finally {
            if (lock.heldByCurrentThread) {
                lock.unlock()
            }
        }
    }

    void methodB() {
        try {
            if (lock.tryLock(5, TimeUnit.SECONDS)) {
                //write only
            }
        } finally {
            if (lock.heldByCurrentThread) {
                lock.unlock()
            }
        }
    }

}