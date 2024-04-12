import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int x = scanner.nextInt(); 

            if (x == 0) {
                if (!minHeap.isEmpty()) {
                    System.out.println(minHeap.poll());
                } else {
                    System.out.println(0);
                }
            } else {
                minHeap.offer(x);
            }
        }

        scanner.close();
    }
}
