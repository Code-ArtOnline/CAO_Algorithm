import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        Integer[] items = new Integer[N];

        for(int i=0;i<N;i++) items[i] = scan.nextInt();
        Arrays.sort(items, Comparator.reverseOrder()); //내림차순 정렬

        int sum = 0; //최소한의 비용 계산하기 
        for(int i=0;i<N;i++){
            if(i%3==2) continue; //3의 배수를 제외하고 계산하기
            sum += items[i];
        }
        System.out.println(sum);
    }
}