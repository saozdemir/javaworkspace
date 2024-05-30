package com.sao.course.synchronization;

/**
 * @author saozdemir
 * @project javaworkspace
 * @date 29 May 2024
 * <p>
 * @description: Critical Section & Synchronization
 */
public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        InventoryCounter inventoryCounter = new InventoryCounter();
        IncrementingThread incrementingThread = new IncrementingThread(inventoryCounter);
        DecrementingThread decrementingThread = new DecrementingThread(inventoryCounter);

        incrementingThread.start();
        decrementingThread.start();

        incrementingThread.join();
        decrementingThread.join();

        System.out.println("We currently have " + inventoryCounter.getItems() + " items");
    }

    public static class DecrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public DecrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.decrement();
            }
        }
    }

    public static class IncrementingThread extends Thread {

        private InventoryCounter inventoryCounter;

        public IncrementingThread(InventoryCounter inventoryCounter) {
            this.inventoryCounter = inventoryCounter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                inventoryCounter.increment();
            }
        }
    }

    private static class InventoryCounter {
        private int items = 0;

        Object lock = new Object();

        /**
         * Burada eğer
         * public synchronized void increment()
         * public synchronized void decrement()
         * public synchronized int getItems() şeklinde tanımlama yapılmış olsaydı, bir thread bu metotardan herhangi birine
         * girdiinde diğer threadlerin tüm synchronized metotlara erişimi locklanmış olurdu.
         * Bir bağlamda sigle thread gibi çalışırdı.
         *
         * Ancak
         * Object lock = new Object();
         * ...
         * synchronized (this.lock) {
         *                 items--;
         * } şeklinde kullanım ile sadece ilgili kod satırı için locklama yapılır. Bu durumda diğer metotları farklı threadler kullanabilir.
         */
        public void increment() {
            synchronized (this.lock) { //Bir thread bu kod satırını kullanırken diğer threadlerin bu alana erişimini engeller.
                items++;
            }
        }

        public void decrement() {
            synchronized (this.lock) {
                items--;
            }
        }

        public int getItems() {
            synchronized (this.lock) {
                return items;
            }
        }
    }
}
