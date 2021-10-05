import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class RaceCondition {

    private static Logger log = LoggerFactory.getLogger(RaceCondition.class);

    public static void main(String[] args) throws InterruptedException {
        AcumuladorTask task = new AcumuladorTask(1000000);
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(task);
            t.start();
            threads.add(t);

        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


        log.info("El contador ha acumulado el numero " + task.getCount());
    }
}
