package ru.netology.pyas;

public class Seller {

    private int carNum = 0;

    public void getCar() {
        ++carNum;
        System.out.printf("Продавец получил машину. У продавца %d машин%n", carNum);
    }

    public boolean hasCar() {
        return carNum > 0;
    }

    public void sellCar() {
        --carNum;
        System.out.printf("Продавец продал машину. У продавца %d машин%n", carNum);
    }
}
