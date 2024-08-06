package org.example.Concurrency;

public class Consumer implements Runnable{
    private final SharedBuffer buffer;

    public Consumer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        int sum = 0;
        try {
            while (true) {
                int value = buffer.remove();
                sum += value;
                System.out.println("Consumed: " + value + ", Sum: " + sum);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
