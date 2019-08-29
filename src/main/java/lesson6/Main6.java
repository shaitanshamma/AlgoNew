package lesson6;

import java.util.Random;

public class Main6 {
    static int range = 20;

    public static void main(String[] args) {
        testTree();
    }

    private static void testTree() {
        boolean[] test = new boolean[range];
        for (int i = 0; i < range; i++) {
            Tree<Integer> tree_i = new TreeImpl<>();
            for (int j = 0; j < 15; j++) {
                tree_i.add(rnd());
            }
            Node node = ((TreeImpl<Integer>) tree_i).root;

            System.out.println("Глубина " +((TreeImpl<Integer>) tree_i).height(node) );
            System.out.println("Дерево " + i);
            System.out.println("Корень = " + ((TreeImpl<Integer>) tree_i).root.getValue());
            test[i] = tree_i.isBalanced(node);
           // tree_i.display();
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

    private static void checkBalance(boolean[] mass) {
        int balance = 0;
        int disBalance = 0;
        for (int i = 0; i < mass.length; i++) {
            if (mass[i] == true) {
                balance++;
            } else disBalance++;
        }
        double persent = balance * 100 / range;

        System.out.println("Число сбалансированых деревьев = " + balance);
        System.out.println("Число несбалансированых деревьев = " + disBalance);
        System.out.println("Процент сбалансированных деревьев " + persent + " %");
    }
}
