package src;

public class StringCalculator {
    public static int add(String numbers) {
        if (numbers.strip().length() == 0) {
            return 0;
        } else if (!numbers.contains(",")) {
            if (Integer.parseInt(numbers) < 0) {
                throw new RuntimeException("Negative not allowed:" + numbers);
            }
            return Integer.parseInt(numbers);
        } else if (numbers.contains(",")) {
            String numberList[] = numbers.split(",");
            int sum = 0;
            for (String number : numberList) {
                if (!Character.isDigit(number.charAt(0))) {
                    int characer = number.charAt(0);
                    sum += characer - 96;
                } else {
                    sum += Integer.parseInt(number);
                }
            }
            return sum;
        }
        return 1;

    }
}