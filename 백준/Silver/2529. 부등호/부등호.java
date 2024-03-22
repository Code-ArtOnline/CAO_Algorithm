import java.util.*;

public class Main {
    static int k;
    static char[] signs;
    static boolean[] used;
    static ArrayList<String> results;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        k = scanner.nextInt();
        signs = new char[k];
        for (int i = 0; i < k; i++) {
            signs[i] = scanner.next().charAt(0);
        }
        scanner.close();

        used = new boolean[10];
        results = new ArrayList<>();

        findNumbers(0, new StringBuilder());

        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    static void findNumbers(int depth, StringBuilder sb) {
        if (depth == k + 1) {
            results.add(sb.toString());
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (!used[i] && (depth == 0 || checkCondition(sb.charAt(sb.length() - 1) - '0', i, signs[depth - 1]))) {
                used[i] = true;
                findNumbers(depth + 1, new StringBuilder(sb).append(i));
                used[i] = false;
            }
        }
    }

    static boolean checkCondition(int a, int b, char sign) {
        return sign == '<' ? a < b : a > b;
    }
}
