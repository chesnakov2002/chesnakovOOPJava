package Parallelism;

import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Object lock = new Object();
        List<Integer> list = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    synchronized (lock) {
                        list.add(j);
                    }
                }
            });

            threads.add(thread);
        }

        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(list);
        System.out.println("Длина списка = " + list.size());
    }
}
