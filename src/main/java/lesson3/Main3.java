package lesson3;

import lesson3.Dec.Dec;
import lesson3.Dec.DecImpl;
import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class Main3 {

    public static void main(String[] args) {

        Dec<Integer> dec = new DecImpl<>(5);
        dec.insertRight(1);
        dec.insertRight(2);
        dec.insertRight(3);
        dec.insertRight(4);
        dec.insertRight(5);
//        dec.insertLeft(1);
//        dec.insertLeft(2);
//        dec.insertLeft(3);
//        dec.insertLeft(4);
//        dec.insertLeft(5);
        System.out.println("Левый элемент : " + dec.peekLeft());

        System.out.println("Правый элемент : " + dec.peekRight());

        System.out.println("-----------");

//        while (!dec.isEmpty()) {
//            System.out.println(dec.removeRight());
//        }

        while (!dec.isEmpty()) {
            System.out.println(dec.removeRight());
        }
    }
}
