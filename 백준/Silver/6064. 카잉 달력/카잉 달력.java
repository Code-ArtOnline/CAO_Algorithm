import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 

        for (int i = 0; i < T; i++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            int result = findYear(M, N, x, y);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int findYear(int M, int N, int x, int y) {
        int lcm = getLCM(M, N); 
        int k = x;
        while (k <= lcm) {
            if (k % N == y % N) { 
                return k;
            }
            k += M;
        }
        return -1; 
    }

    private static int getLCM(int a, int b) {
        return a * b / getGCD(a, b); 
    }

    private static int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
