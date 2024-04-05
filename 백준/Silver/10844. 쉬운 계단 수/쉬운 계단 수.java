import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[][] stairs = new long[n+1][10];

        for (int i = 1; i <= 9; i++) {
            stairs[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            stairs[i][0] = stairs[i-1][1];
            for (int j = 1; j < 9; j++) {
                stairs[i][j] = (stairs[i-1][j-1] + stairs[i-1][j+1]) % 1000000000;
            }
            stairs[i][9] = stairs[i-1][8];
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + stairs[n][i]) % 1000000000;
        }

        System.out.println(sum);
    }
}
