package ru.netology.pyas;

public class Manufacturer {

    private final static int MANUFACTURE_TIME = 2000;
    private final static int MAX_CARS = 10;

    private final Seller seller;

    public Manufacturer(Seller seller) {
        this.seller = seller;
    }

    public void makeCars() {
        for (int i = 0; i < MAX_CARS; ++i) {
            try {
                Thread.sleep(MANUFACTURE_TIME);
            } catch (InterruptedException e) {
            }
            System.out.printf("Производитель произвёл машину №%d%n", i + 1);
            synchronized (seller) {
                seller.getCar();
                seller.notify();
            }
        }
    }
}
