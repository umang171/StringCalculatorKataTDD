package src;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.strip().length() == 0) {
            return 0;
        } else if (!numbers.contains(",")) {
            return Integer.parseInt(numbers);
        } else if (numbers.contains(",")) {
            String numberList[] = numbers.split(",");
            int sum = 0;
            for (String number : numberList) {
                sum += Integer.parseInt(number);
            }
            return sum;
        }
        return 1;

    }
}