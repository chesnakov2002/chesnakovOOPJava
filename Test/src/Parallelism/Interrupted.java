package Parallelism;

public class Interrupted {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            int count = 0;

            while (count < 10000) {
                if (Thread.interrupted()) {
                    System.out.println("Поймал interrupt, но продолжаю работу");
                }

                System.out.println("Шаг " + count);
                count++;
            }

            System.out.println("Поток завершился сам");
        });

        t.start();

        Thread.sleep(10000);
        t.interrupt(); // ставим флаг true
    }
}