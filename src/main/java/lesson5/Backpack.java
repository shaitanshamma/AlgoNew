package lesson5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backpack {
    int maxWeight;

    public Backpack(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    static List<Stuff> bestList = new ArrayList<>();
    static List<Stuff> stuffList = new ArrayList<>();
    static List<Stuff> tempSet = new ArrayList<>();
    private double bestPrice;

    public static void main(String[] args) {

        Stuff book = new Stuff("книга", 2, 2000);
        Stuff macbook = new Stuff("ноутбук", 3, 100000);
        Stuff phone = new Stuff("телефон", 1, 35000);
        Stuff powerbank = new Stuff("повербанк", 1, 10000);

        stuffList.add(book);
        stuffList.add(macbook);
        stuffList.add(phone);
        stuffList.add(powerbank);

        Backpack backpack = new Backpack(4);
        backpack.makeAllSets(stuffList);
        System.out.println("Исходный набор :");
        display(stuffList);
        System.out.println("Лучший набор : ");
        System.out.println(backpack.getBestStuffs());
    }

    public void makeAllSets(List<Stuff> stuff) {
        if (stuff.size() > 0) {
            this.checkSet(stuff);
        }
        for (int i = 0; i < stuff.size(); i++) {
            List<Stuff> newSet = new ArrayList<>(stuff);
            newSet.remove(i);
            makeAllSets(newSet);
        }
    }

    private double calcWeigth(List<Stuff> stuffs) {
        double result = 0;
        for (Stuff stuff : stuffs) {
            result += stuff.weight;
        }
        return result;
    }

    private double calcPrice(List<Stuff> stuffs) {
        double result = 0;
        for (Stuff stuff : stuffs) {
            result += stuff.price;
        }
        return result;
    }
    private void checkSet(List<Stuff> stuff) {
        if (this.bestList == null) {
            if (this.calcWeigth(stuff) <= this.maxWeight) {
                this.bestList = stuff;
                this.bestPrice = this.calcPrice(stuff);
            }
        } else {
            if (this.calcWeigth(stuff) <= this.maxWeight && this.calcPrice(stuff) > this.bestPrice) {
                this.bestList = stuff;
                this.bestPrice = this.calcPrice(stuff);
            }
        }
    }

    private static void display(List<Stuff> stuff) {
        for (Stuff stuf : stuff) {
            System.out.println(stuf);
        }
    }

    private static int priceForAll(List<Stuff> stuffList) {
        int summ = 0;
        for (Stuff good : stuffList) {
            summ += good.price;
        }
        return summ;
    }

    public List<Stuff> getBestStuffs() {
        return this.bestList;
    }
}
