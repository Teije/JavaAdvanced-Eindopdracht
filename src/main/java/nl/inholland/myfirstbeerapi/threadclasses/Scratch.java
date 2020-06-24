package nl.inholland.myfirstbeerapi.threadclasses;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Scratch {
    private int counter = 0;
    private final Object lock = new Object();

    private void incrementAndPrint() {
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + ", " + (counter++));
        }
    }
    public static void main(String[] args) {
        ExecutorService service = null;
        try {
            service = Executors.newSingleThreadExecutor();
            Scratch scratch = new Scratch();
            for (int i = 0; i < 10; i++) {
                service.submit(scratch::incrementAndPrint);
            }
        } finally {
            if (service != null) {
                service.shutdown();
            }
        }
    }
}

