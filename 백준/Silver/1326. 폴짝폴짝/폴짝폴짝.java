import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 징검다리의 개수
        int[] stones = new int[N]; // 징검다리에 쓰여 있는 수를 저장할 배열

        // 징검다리에 쓰여 있는 수 입력
        input = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            stones[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]); // 시작지점
        int b = Integer.parseInt(input[1]); // 목표지점

        int result = bfs(stones, a - 1, b - 1); // 징검다리 인덱스는 0부터 시작하므로 a, b에서 1을 빼줌
        System.out.println(result);
    }

    // BFS를 통해 최소 점프 횟수를 찾는 메소드
    public static int bfs(int[] stones, int start, int end) {
        // BFS 구현을 위한 Queue를 생성하기
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[stones.length]; // 방문한 노드 추적 배열
        int[] distance = new int[stones.length]; // 각 노드까지의 거리 배열

        queue.offer(start); // 시작 지점을 큐에 추가
        visited[start] = true; // 시작 지점을 방문 처리

        while (!queue.isEmpty()) { // 큐가 채워져 있는 동안 반복
            int current = queue.poll(); // 큐에서 현재 노드 꺼내기

            if (current == end) { // 현재 노드가 도착 지점인 경우 해당 노드까지의 거리를 반환하고 종료
                return distance[current];
            }

            // 현재 위치에서 점프할 수 있는 거리
            int jumpSize = stones[current];

            // 현재 위치에서 징검다리에 쓰여 있는 수의 배수만큼 떨어진 곳으로 점프하여 갈 수 있는 다음 위치를 계산하여 큐에 추가
            for (int i = 1; i <= stones.length; i++) {
                if (current + i * jumpSize < stones.length && !visited[current + i * jumpSize]) {
                    queue.offer(current + i * jumpSize);
                    visited[current + i * jumpSize] = true;
                    distance[current + i * jumpSize] = distance[current] + 1;
                }
                if (current - i * jumpSize >= 0 && !visited[current - i * jumpSize]) {
                    queue.offer(current - i * jumpSize);
                    visited[current - i * jumpSize] = true;
                    distance[current - i * jumpSize] = distance[current] + 1;
                }
            }
        }

        return -1; // 도달할 수 없는 경우
    }
}
