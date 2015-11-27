/**
 * Created by parampreet on 11/24/15.
 */
class Example {

    final Object lockA = new Object();
    final Object lockB = new Object();


    public static void main(String[] args) {
        final Example example = new Example()
        Thread.start("Thread A") { example.methodA() }
        Thread.start("Thread B") { example.methodB() }
    }
    void methodA() {
        synchronized (lockA) {
            println("Method A -  " + Thread.currentThread().name)
            Thread.sleep(5000)
        }
    }

    void methodB() {
        synchronized (lockB) {
            println("Method B -  " + Thread.currentThread().name)
            Thread.sleep(5000)
        }

    }

}