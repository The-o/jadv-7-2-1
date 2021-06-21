/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ru.netology.pyas;

public class Main {

    public static void main(String[] args) {
        Seller seller = new Seller();
        Manufacturer manufacturer = new Manufacturer(seller);

        Buyer buyer1 = new Buyer("Покупатель 1", seller);
        Buyer buyer2 = new Buyer("Покупатель 2", seller);
        Buyer buyer3 = new Buyer("Покупатель 3", seller);

        Thread buyer1Thread = new Thread(buyer1::buyCars);
        Thread buyer2Thread = new Thread(buyer2::buyCars);
        Thread buyer3Thread = new Thread(buyer3::buyCars);

        Thread manufacturerThread = new Thread(manufacturer::makeCars);

        manufacturerThread.start();
        buyer1Thread.start();
        buyer2Thread.start();
        buyer3Thread.start();

        try {
            manufacturerThread.join();
        } catch (InterruptedException e) {
        }

        buyer1Thread.interrupt();
        buyer2Thread.interrupt();
        buyer3Thread.interrupt();
    }
}
