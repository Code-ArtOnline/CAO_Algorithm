import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/*
gold 5.
2024.03.27
적록색약
 */
public class Main {

    static int N;
    static char[][] image;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y, char color) {
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (!visited[nx][ny] && image[nx][ny] == color) {
                    dfs(nx, ny, color);
                }
            }
        }
    }

    public static int count() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, image[i][j]);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void reset() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited[i], false);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        image = new char[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            image[i] = br.readLine().toCharArray();
        }

        System.out.print(count() + " ");

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (image[i][j] == 'G') image[i][j] = 'R';
            }
        }

        reset();
        System.out.println(count());
    }
}
