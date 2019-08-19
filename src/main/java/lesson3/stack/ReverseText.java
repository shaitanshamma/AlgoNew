package lesson3.stack;

public class ReverseText {
    public static void main(String[] args) {
        String example= "Тестовая строка. Не очень длинная, но всё же )";
        new ReverseText(example).reverse();
    }

    private final String text;

    public ReverseText(String text) {
        this.text = text;
    }

    public void reverse(){
        Stack<Character> stack = new StackImpl<>(text.length());
        for (int index = 0; index < text.length(); index++) {
            char currentChar = text.charAt(index);
            stack.push(currentChar);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}