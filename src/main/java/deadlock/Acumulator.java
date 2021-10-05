package deadlock;

public class Acumulator {
    private int value;

    public synchronized void inc() throws InterruptedException {
        value++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void dec() throws InterruptedException {
        value++;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
