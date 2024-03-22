import java.util.Scanner;

public class Main {
    public static int[] arr;
    public static boolean[] visit;
    public static int N;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); 
        arr = new int[N];
        visit = new boolean[N];
        
        dfs(0);
    }
    
    public static void dfs(int depth) {
        if (depth == N) { 
            for (int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }
        
        for (int i = 0; i < N; i++) {
            if (!visit[i]) { 
                visit[i] = true; 
                arr[depth] = i + 1; 
                dfs(depth + 1); 
                visit[i] = false; 
            }
        }
    }
}
