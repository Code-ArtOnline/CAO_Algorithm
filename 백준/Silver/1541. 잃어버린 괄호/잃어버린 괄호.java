import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        scanner.close();

        int answer = calculateMinValue(expression);
        System.out.println(answer);
    }

    private static int calculateMinValue(String expression) {
        int minValue = 0;
        int temp = 0;
        boolean subtract = false;

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isDigit(c)) {
                temp = temp * 10 + (c - '0');
            } else {
                if (subtract) {
                    minValue -= temp;
                } else {
                    minValue += temp;
                }

                temp = 0;

                if (c == '-') {
                    subtract = true;
                }
            }
        }

        if (subtract) {
            minValue -= temp;
        } else {
            minValue += temp;
        }

        return minValue;
    }
}
