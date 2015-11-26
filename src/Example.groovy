/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    final Object lockA = new Object();
    final Object lockB = new Object();
    void methodA() {
        synchronized (lockA) {

        }
    }

    void methodB() {
        synchronized (lockB) {

        }

    }

}