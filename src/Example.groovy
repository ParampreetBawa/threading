/**
 * Created by parampreet on 11/24/15.
 */
class Example {
    public static void main(String[] args) {
        final Example example = new Example()
        new Thread(new Runnable() {
            @Override
            void run() {
                while(true)
                    example.method()
            }
        },"A").start();

        new Thread(new Runnable() {
            @Override
            void run() {
                while(true) {
                    example.method();
                }
            }
        },"B").start()

    }

    synchronized void method() {
        println(Thread.currentThread().name)
        Thread.sleep(5000)
    }

}