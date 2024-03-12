import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static class Pair {
        long num;
        int count;

        public Pair(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(BFS(a,b));
    }

    private static int BFS(long a, int b) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a,1));

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            if (current.num == b) {
                return current.count;
            } else if (current.num > b){
                continue;
            }
            queue.add(new Pair(current.num * 2, current.count + 1));
            queue.add(new Pair(current.num * 10 + 1, current.count + 1));
        }
        return -1;
    }
}
