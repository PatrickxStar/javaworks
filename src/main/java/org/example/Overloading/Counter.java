package org.example.Overloading;

public class Counter {
    public static void main(String[] args) {
        Counter counter1 = new Counter(10);
        System.out.println("Initial value of counter1: " + counter1.value());
        counter1.increase();
        System.out.println("Value of counter1 after increase by 1: " + counter1.value());
        counter1.increase(5);
        System.out.println("Value of counter1 after increase by 5: " + counter1.value());
        counter1.decrease();
        System.out.println("Value of counter1 after decrease by 1: " + counter1.value());
        counter1.decrease(3);
        System.out.println("Value of counter1 after decrease by 3: " + counter1.value());


        Counter counter2 = new Counter();
        System.out.println("Initial value of counter2: " + counter2.value());
        counter2.increase();
        System.out.println("Value of counter2 after increase by 1: " + counter2.value());
        counter2.increase(4);
        System.out.println("Value of counter2 after increase by 4: " + counter2.value());
        counter2.decrease();
        System.out.println("Value of counter2 after decrease by 1: " + counter2.value());
        counter2.decrease(2);
        System.out.println("Value of counter2 after decrease by 2: " + counter2.value());
    }
    private int value;

    public Counter(int startValue) {
        this.value = startValue;
    }

    public Counter() {
        this(0);
    }

    public int value() {
        return this.value;
    }

    public void increase() {
        this.value++;
    }

    public void increase(int increaseBy) {
        if (increaseBy > 0) {
            this.value += increaseBy;
        }
    }

    public void decrease() {
        this.value--;
    }

    public void decrease(int decreaseBy) {
        if (decreaseBy > 0) {
            this.value -= decreaseBy;
        }
    }
}
