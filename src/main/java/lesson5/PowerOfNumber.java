package lesson5;

import java.io.IOException;

public class PowerOfNumber {

    public static void main(String[] args) throws IOException {

        System.out.println(powerOfNumb(5, 3));
    }

    private static int powerOfNumb(int number, int rank) throws IOException {
        int result = 0;

        if (rank < 0) {
            throw new IOException("Не сильная математика (: ");
        }
        if (rank == 0) {
            return 1;
        }
        if (rank > 0) {
            for (int i = 0; i <= rank; i++) {
                result = number * powerOfNumb(number, rank - 1);

            }
        }
        return result;
    }
}
