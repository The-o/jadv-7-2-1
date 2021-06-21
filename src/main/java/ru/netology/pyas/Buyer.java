package ru.netology.pyas;

import java.util.Random;

public class Buyer {

    private final int BYU_PERIOD = 1500 + new Random().nextInt(3500);

    private final Seller seller;
    private final String name;

    public Buyer(String name, Seller seller) {
        this.name = name;
        this.seller = seller;
    }

    public void buyCars() {
        try {
            while(!Thread.currentThread().isInterrupted()) {
                System.out.printf("%s пришёл к продавцу%n", name);
                synchronized(seller) {
                    if(!seller.hasCar()) {
                        seller.wait();
                    }
                    seller.sellCar();
                }
                System.out.printf("%s получил машину%n", name);
                Thread.sleep(BYU_PERIOD);
            }
        } catch (InterruptedException e) {
        }
    }
}
