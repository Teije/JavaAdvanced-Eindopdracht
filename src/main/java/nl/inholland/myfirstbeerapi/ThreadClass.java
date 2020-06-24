package nl.inholland.myfirstbeerapi;

public class ThreadClass implements Runnable
{
    @FunctionalInterface
    public interface Runnable {
        public abstract void run();
    }

    public static void main(String[] args) {
        System.out.println("This is the main thread: " + Thread.currentThread().getName());
        ThreadClass tc = new ThreadClass();
        new Thread(tc).start(); // wrap it in a thread
    }
    @Override
    public void run() {
        System.out.println("This thread has name: " + Thread.currentThread().getName());
    }
}
