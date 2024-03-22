import java.util.Scanner;

public class Main {
    static int N, S, count = 0;
    static int[] numbers;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        dfs(0,0,0);
        System.out.println(count);
    }

    static void dfs(int index, int currentSum, int selected) {
        if (index == N) {
            if (currentSum == S && selected > 0) {
                count++;
            }
            return;
        }
        dfs(index + 1, currentSum + numbers[index], selected + 1);
        dfs(index + 1, currentSum, selected);
    }
}
