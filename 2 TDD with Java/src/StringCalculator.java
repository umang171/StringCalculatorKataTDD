package src;

public class StringCalculator {
    public static int add(String numbers) {
        String negativeValues = "";
        if (numbers.startsWith("0//")) {
            numbers = numbers.substring(3);
            String[] numberList = numbers.split(",");
            int sum = 0;
            for (int i = 0; i < numberList.length; i += 2) {
                sum += Integer.parseInt(numberList[i]);
            }
            return sum;
        }
        if (numbers.startsWith("//")) {
            int beginIndexOfParameter = numbers.indexOf("//");
            int endIndexOfParameter = numbers.indexOf("\n");
            String delimiter = numbers.substring(beginIndexOfParameter + 2, endIndexOfParameter);
            numbers = numbers.substring(endIndexOfParameter + 1);
            numbers = numbers.replaceAll(delimiter, ",");
        }
        if (numbers.strip().length() == 0) {
            return 0;
        } else if (!numbers.contains(",")) {
            if (Integer.parseInt(numbers) < 0) {
                throw new RuntimeException("Negative not allowed:" + numbers);
            }
            return Integer.parseInt(numbers);
        } else if (numbers.contains(",")) {
            if (numbers.contains("\n")) {
                numbers = numbers.replace("\n", ",");
            }
            String numberList[] = numbers.split(",");
            int sum = 0;
            for (String number : numberList) {
                if ((number.length() == 1) && (!Character.isDigit(number.charAt(0)))) {
                    int character = number.charAt(0);
                    sum += (character - 96);
                } else {
                    if (Integer.parseInt(number) < 0) {
                        negativeValues += (number + ",");
                    } else {
                        if (!(Integer.parseInt(number) > 1000)) {
                            sum += Integer.parseInt(number);
                        }
                    }
                }
            }
            if (negativeValues.length() != 0) {
                throw new RuntimeException("Negative not allowed:" + negativeValues);
            }
            return sum;
        }
        return 1;

    }
}