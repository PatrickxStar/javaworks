package org.example.Concurrency;
import java.util.Random;

public class Producer implements Runnable {
    private final SharedBuffer buffer;

    public Producer(SharedBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            while (true) {
                int value = random.nextInt(100); // Generate random number
                buffer.add(value);
                System.out.println("Produced: " + value);
                Thread.sleep(500); // Simulate time taken to produce
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
