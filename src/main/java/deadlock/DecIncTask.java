package deadlock;

public class DecIncTask implements Runnable{
    private Acumulator acumulator;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            try {
                acumulator.dec();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                acumulator.inc();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
