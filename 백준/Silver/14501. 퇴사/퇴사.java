import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            T[i] = scanner.nextInt();
            P[i] = scanner.nextInt();
        }

        for (int i = N - 1; i >= 0; i--) {
            int next = i + T[i];
            if (next <= N) {
                dp[i] = Math.max(P[i] + dp[next], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[0]);
    }
}
