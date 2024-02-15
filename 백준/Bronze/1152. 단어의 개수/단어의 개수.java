import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str;
        str = sc.nextLine();
        sc.close();

        StringTokenizer str1 = new StringTokenizer(str, " ");
        System.out.println((str1.countTokens()));

    }
}