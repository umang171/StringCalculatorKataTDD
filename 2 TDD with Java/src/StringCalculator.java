package src;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.strip().length() == 0) {
            return 0;
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        }
        return 1;

    }
}