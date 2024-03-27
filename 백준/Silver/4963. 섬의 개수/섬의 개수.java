import java.util.Scanner;

public class Main {
    static int[][] map;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1}; // 좌상부터 시계방향으로 인접한 좌표를 탐색하기 위한 배열
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int w, h;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            if (w == 0 && h == 0)
                break;

            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = scanner.nextInt();
                }
            }

            int islandCount = countIslands();
            System.out.println(islandCount);
        }

        scanner.close();
    }

    static int countIslands() {
        int count = 0;

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        return count;
    }

    static void dfs(int x, int y) {
        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < h && ny >= 0 && ny < w && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
