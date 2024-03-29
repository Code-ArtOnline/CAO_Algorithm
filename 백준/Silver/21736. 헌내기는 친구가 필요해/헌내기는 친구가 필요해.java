import java.util.*;

class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static char[][] campus;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        campus = new char[N][M];
        visited = new boolean[N][M];
        scanner.nextLine();

        Position doyeon = null;
        for (int i = 0; i < N; i++) {
            String row = scanner.nextLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = row.charAt(j);
                if (campus[i][j] == 'I') {
                    doyeon = new Position(i, j);
                }
            }
        }

        int result = bfs(doyeon);
        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    public static int bfs(Position start) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(start);
        visited[start.x][start.y] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            int x = current.x;
            int y = current.y;

            if (campus[x][y] == 'P') {
                count++;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && campus[nx][ny] != 'X' && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Position(nx, ny));
                }
            }
        }

        return count;
    }
}
