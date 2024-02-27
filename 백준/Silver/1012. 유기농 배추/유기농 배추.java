import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, K;
    static int [][] cabbage;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static void bfs (int x, int y) {
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[] {x, y});

        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.peek()[1];
            visited[x][y] = true;
            q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = x + dx[i];
                int cy = y + dy[i];

                if (cx >= 0 && cy >= 0 && cx < M && cy <N) {
                    if (!visited[cx][cy] && cabbage[cx][cy] == 1) {
                        q.add(new int[] {cx, cy});
                        visited[cx][cy] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            cabbage = new int[M][N];
            visited = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                cabbage[X][Y] = 1;
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (cabbage[i][j] == 1 && !visited[i][j]) {
                        bfs (i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}
