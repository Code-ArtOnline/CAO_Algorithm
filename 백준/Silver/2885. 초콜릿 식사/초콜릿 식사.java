import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int choco = 1;
        while (k > choco) {
            choco *= 2;
        }
        System.out.print(choco+" ");

        int n = 0;
        while (true) {
            if (k % choco == 0) {
                System.out.println(n);
                break;
            } else {
                choco /= 2;
                n += 1;
            }
        }
    }
}
