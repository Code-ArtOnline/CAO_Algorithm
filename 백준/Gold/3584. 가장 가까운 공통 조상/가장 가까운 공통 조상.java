import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
gold 4.
2024.03.29
가장 가까운 공통 조상
dfs
 */

public class Main {

    static int[] parent;
    
    static int find(int x, int y) {
        boolean[] visited = new boolean[parent.length];

        while (x != parent[x]) {
            visited[x] = true;
            x = parent[x];
        }
        visited[x] = true;

        while (!visited[y]) {
            y = parent[y];
        }
        return y;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            parent = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }

            for (int i = 1; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                parent[y] = x;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            System.out.println(find(node1, node2));

        }

    }
}
