public class AcumuladorTask implements Runnable {

    private int count;
    private int iterations;

    public AcumuladorTask(int iterations) {
        this.count = 0;
        this.iterations = iterations;
    }

    public int getCount() {
        return count;
    }

    public synchronized void inc() {
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < iterations; i++) {
            inc();
        }
    }
}
