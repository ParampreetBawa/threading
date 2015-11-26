import java.util.concurrent.TimeUnit;

/**
 * Created by parampreet on 11/25/15.
 */
public class Barrier {
    static boolean done = false;
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!done) {
                    i++;
                    synchronized (this) {
                        int j = 0;
                    }
                }
                System.out.println("Done !!");
            }
        }).start();

        Thread.sleep(2000);
        done = true;
        System.out.println("exiting after setting done");
    }
}
