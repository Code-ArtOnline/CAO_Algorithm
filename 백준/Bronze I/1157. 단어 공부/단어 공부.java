import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[26];
        String str = sc.nextLine();
        str = str.toUpperCase();

        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'A']++;
        }

        sc.close();

        int max = -1;
        char qu = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                qu = (char) (i + 'A');
            } else if (arr[i] == max) {
                qu = '?';
            }
        }
        System.out.println(qu);
    }
}
