import java.util.concurrent.locks.ReentrantLock

/**
 * Created by parampreet on 11/24/15.
 */
class Example {
    final Object lockA = new Object()
    final ReentrantLock lockB = new ReentrantLock()
    void methodA() {
        synchronized (lockA) {
            //Do something
        }
    }

    void methodB() {
        try {
            lockB.lock()
            //Do something
        }finally {
            lockB.unlock()
        }
    }

    void methodD() {
        try {
            if(lockB.tryLock()) {
                //Do something
            }
        }finally {
            if(lockB.isHeldByCurrentThread()) {
                lockB.unlock()
            }
        }

    }

}