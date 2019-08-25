package lesson6;

import java.util.Random;

public class Main6 {

    public static void main(String[] args) {
        testTree();
//        Tree<Integer> tree = new TreeImpl<>();
//        tree.add(60);
//        tree.add(25);
//        tree.add(66);
//        tree.add(15);
//        tree.add(5);
//        tree.add(20);
//        tree.add(45);
//        tree.add(30);
//        tree.add(55);
//        tree.add(32);
//
//        tree.display();
//
//        tree.remove(60);
//
//        tree.display();

    }

    private static void testTree() {
        int range = 200;
        boolean [] test  = new boolean[range];
        for (int i = 0; i < range; i++) {
            Tree<Integer> tree_i = new TreeImpl<>();
            for (int j = 0; j < 15; j++) {
                tree_i.add(rnd());
            }
            Node<Integer> node = ((TreeImpl<Integer>) tree_i).root;
            System.out.println("Корень = " + ((TreeImpl<Integer>) tree_i).root.getValue());
            System.out.println("Дерево " + i);
     //       tree_i.display();
//            System.out.println(tree_i.isBalanced(node));
            test[i] = tree_i.isBalanced(node);
        }
            checkBalance(test);
    }

    protected static int rnd() {
        int min = -15;
        int max = 15;
        int diff = max - min;
        Random random = new Random();
        int i = random.nextInt(diff + 1);
        return i += min;
    }

    private static void checkBalance(boolean [] mass){
        int balance = 0;
        int disBalance = 0;
        for (int i = 0; i <mass.length ; i++) {
            if(mass[i]==true){
                balance++;
            }else disBalance++;
        }
        System.out.println("Число сбалансированых деревьев = " + balance);
        System.out.println("Число несбалансированых деревьев = " + disBalance);
    }
}
