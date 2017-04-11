import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.locks.ReentrantReadWriteLock

/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    final ReentrantReadWriteLock lock = new ReentrantReadWriteLock()

    void methodA() {
        try {
            if (lock.readLock().tryLock(5, TimeUnit.SECONDS)) {
                //read only
            }
        } finally {
            lock.readLock().unlock();
        }
    }

    void methodB() {
        try {
            if (lock.writeLock().tryLock(5, TimeUnit.SECONDS)) {
                //write only
            }
        } finally {
            lock.writeLock().unlock()
        }
    }

}