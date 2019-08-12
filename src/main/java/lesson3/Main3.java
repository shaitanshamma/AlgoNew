package lesson3;


import lesson3.queue.PriorityQueue;
import lesson3.queue.Queue;
import lesson3.stack.Stack;
import lesson3.stack.StackImpl;

public class Main3 {

    public static void main(String[] args) {
//        testStack();
//        Queue<Integer> queue = new QueueImpl<>(5);
        Queue<Integer> queue = new PriorityQueue<>(5);
        queue.insert(3);
        queue.insert(1);
        queue.insert(4);
        queue.insert(6);
        queue.insert(2);
        queue.insert(5);

        System.out.println("Top of queue is: " + queue.peek());

        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
    }

    private static void testStack() {
        Stack<Integer> stack = new StackImpl<>(5);
        addToStack(stack, 1);
        addToStack(stack, 2);
        addToStack(stack, 3);
        addToStack(stack, 4);
        addToStack(stack, 5);
        addToStack(stack, 6);

        System.out.println("Top of stack is: " + stack.peek());

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    private static void addToStack(Stack<Integer> stack, int value) {
        if (!stack.isFull()) {
            stack.push(value);
        }
    }
}
