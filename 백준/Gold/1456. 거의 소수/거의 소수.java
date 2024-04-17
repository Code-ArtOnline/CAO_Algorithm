import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        
        int size = (int)Math.sqrt(max) + 1;
        boolean[] prime = new boolean[size + 1];
        for (int i = 2; i <= size; i++) {
            prime[i] = true;
        }
        
        for (int i = 2; i * i <= size; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    prime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= size; i++) {
            if (prime[i]) {
                long power = (long)i * i; 
                while (power <= max) {
                    if (power >= min) {
                        count++;
                    }
                    if (max / i < power) break; 
                    power *= i;
                }
            }
        }

        System.out.println(count);
        sc.close();
    }
}
