package lesson5;

public class Stuff {

    String name;
    int weight;
    int price;

    public Stuff(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

//    public int getWeight() {
//        return weight;
//    }
//
//    public void setWeight(int weight) {
//        this.weight = weight;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }

    @Override
    public String toString() {
        return
                name +
                ", вес= " + weight +
                ", цена= " + price;
    }
}
