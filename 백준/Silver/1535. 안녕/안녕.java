import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] L = new int[n + 1];
        int[] J = new int[n + 1];
        int[][] dp = new int[n + 1][100]; 

        for (int i = 1; i <= n; i++) {
            L[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            J[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 100; j++) { 
                if (j - L[i] >= 0) { 
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - L[i]] + J[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int maxJoy = 0;
        for (int j = 1; j < 100; j++) { 
            maxJoy = Math.max(maxJoy, dp[n][j]);
        }

        System.out.println(maxJoy);
        sc.close();
    }
}
