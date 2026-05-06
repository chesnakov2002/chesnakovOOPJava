package Parallelism;

public class Interrupt {
    public static void main(String[] args) throws Exception {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Работаю...");
            }
            System.out.println("Поток корректно завершился");
        });

        t.start();

        Thread.sleep(1000); // main ждет 1 секунду
        t.interrupt();      // main просит t завершиться
    }
}
