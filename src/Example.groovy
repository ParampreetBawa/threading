/**
 * Created by parampreet on 11/24/15.
 */
class Example {
    public static void main(String[] args) {
        Service s = new Service()


        Scanner scanner = new Scanner(System.in)
        5.times {
            final String task = scanner.nextLine()
            s.submit(new Runnable() {
                @Override
                void run() {
                    sleep(1000)
                    new URL("https://www.google.com").text
                }
            })
        }
    }

}

class Service {
    final Object lock = new Object()
    List<Runnable> runnables = []

    Service() {
        new Thread(new Runnable() {
            @Override
            void run() {
                while (true) {
                    if (runnables.size() > 0) {
                        Runnable runnable = runnables.remove(0)
                        runnable.run()
                    } else {
                        synchronized (lock) {
                            lock.wait()
                        }
                    }
                }
            }
        }, "worker").start()

    }

    void submit(Runnable r) {
        runnables.add(r)
        synchronized (lock) {
            lock.notifyAll()
        }
    }
}