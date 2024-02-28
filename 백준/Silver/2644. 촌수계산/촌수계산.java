import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전체 사람의 수 입력
        int n = Integer.parseInt(br.readLine()); // 전체 사람의 수

        // 촌수를 계산해야 하는 두 사람의 번호 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int person1 = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 첫 번째 사람
        int person2 = Integer.parseInt(st.nextToken()); // 촌수를 계산해야 하는 두 번째 사람

        // 부모 자식간의 관계의 개수 입력
        int m = Integer.parseInt(br.readLine()); // 부모 자식간의 관계의 개수

        parent = new int[n + 1]; //각 사람들의 부모 나타내는 배열
        visited = new boolean[n + 1]; //방문 처리
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        //n 만큼 각 사람에 대한 인접 리스트 생성
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        //m 번 만큼 각 관계를 입력 받고, x와 y의 관계를 표현하기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            //그래프 상에서 간선을 표기, 양방향성의 관계
            graph.get(x).add(y); //정점 x에 연결된 리스트에 y 추가
            graph.get(y).add(x); //정점 y에 연결된 리스트에 x 추가
        }

        int result = bfs(person1, person2, graph);
        System.out.println(result);
    }

    public static int bfs(int start, int end, ArrayList<ArrayList<Integer>> graph) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start); //
        visited[start] = true; //시작 지점 방문 처리
        int count = 0; // a와 b의 노드 거리(차수)를 측정

        //큐가 채워져 있는 동안 실행
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Integer current = queue.poll(); //큐에서 노드를 꺼내어 현재 값에 저장, Integer는 null일 수 있기 때문에

                if (current != null && current.equals(end)) // null 체크 한 후에 도착 지점 인지 확인
                    return count; //도착 지점이면 차수 값을 결과에 반환

                if (current == null) continue; // current가 null인 경우 return -1로 건너뜀

                //다음 노드 탐색
                for (int next : graph.get(current)) {
                    if (!visited[next]) { // 만약 다음 노드에 방문하지 않았다면
                        queue.offer(next); //다음 노드로 가기
                        visited[next] = true; //방문 처리
                    }
                }
            }
            count++;
        }

        return -1; // 관계가 없을 때
    }
}
