package printTask;

import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Semaphore semaphore = new Semaphore(2);

        Thread hola = new Thread(new PrintMessageTask(semaphore,  "hola", 1000));
        Thread adios = new Thread(new PrintMessageTask(semaphore,"adios", 1000));

        try {
            hola.start();
            adios.start();
            semaphore.acquire(2);

            semaphore.release(2);

            System.out.println("finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
