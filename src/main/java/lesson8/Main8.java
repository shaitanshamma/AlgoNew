package lesson8;

public class Main8 {

    public static void main(String[] args) {
//        HashTable<Item, Integer> hashTable = new HashTableImpl<>(5);
 //       HashTable<Item, Integer> hashTable = new DoubleHashTableImpl<>(5);
       // HashTable<Item, Integer> myTable = new MyHashTable<>(5);
        MyHashTable<Item, Integer> myTable = new MyHashTable<>(5);

        Item orange = new Item(1, "Orange", 150);
        Item banana = new Item(71, "Banana", 100);
        Item lemon = new Item(60, "Lemon", 250);
        Item milk = new Item(52, "Milk", 120);
        Item potato = new Item(21, "Potato", 67);

        myTable.create();
        myTable.putNode(orange, orange.cost);
        myTable.putNode(banana, banana.cost);
        myTable.putNode(lemon, lemon.cost);
        myTable.putNode(milk, milk.cost);
        myTable.putNode(potato, potato.cost);

        System.out.println("Size is " + myTable.size());
        myTable.display();
        myTable.remove(potato);
        System.out.println("Size is " + myTable.size());
        myTable.display();
        myTable.putNode(potato, potato.cost);
        myTable.remove(banana);
        myTable.display();
        System.out.println(myTable.get(milk));
    }
}
