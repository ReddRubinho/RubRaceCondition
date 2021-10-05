package listTask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> lista = Collections.synchronizedList(new ArrayList<>());
        List<Thread> threads = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new AddToListTask(lista, 100000));
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
        System.out.println(lista.size());
    }
}
