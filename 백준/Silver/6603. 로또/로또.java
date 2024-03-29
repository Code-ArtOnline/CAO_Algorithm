import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int k = scanner.nextInt();
            if (k == 0)
                break;

            int[] set = new int[k];
            for (int i = 0; i < k; i++) {
                set[i] = scanner.nextInt();
            }

            ArrayList<Integer> combination = new ArrayList<>();
            printCombinations(set, combination, 0, 6);
            System.out.println();
        }
    }

    public static void printCombinations(int[] set, ArrayList<Integer> combination, int start, int remaining) {
        if (remaining == 0) {
            for (int num : combination) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < set.length; i++) {
            combination.add(set[i]);
            printCombinations(set, combination, i + 1, remaining - 1);
            combination.remove(combination.size() - 1);
        }
    }
}
