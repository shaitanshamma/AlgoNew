package lesson5;


public class PowerOfNumber {

    public static void main(String[] args) {

        System.out.println(powerOfNumb(5, -3));
    }

    private static double powerOfNumb(int number, int rank) {
        double result = 0;

        if (rank < 0) {
            result = 1 / (powerOfNumb(number, -1 * rank));
        }
        if (rank == 0) {
            result = 1;
        }
        if (rank > 0) {
            for (int i = 0; i <= rank; i++) {
                result = number * powerOfNumb(number, rank - 1);

            }
        }
        return result;
    }
}
