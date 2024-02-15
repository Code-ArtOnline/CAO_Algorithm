import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] ground = new int[N * M];
        int maxHeight = 0, minHeight = 256;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int height = Integer.parseInt(st.nextToken());
                ground[i * M + j] = height;
                maxHeight = Math.max(maxHeight, height);
                minHeight = Math.min(minHeight, height);
            }
        }

        int resultTime = Integer.MAX_VALUE;
        int resultHeight = -1;

        for (int h = minHeight; h <= maxHeight; h++) {
            int time = 0;
            int inventory = B; // 각 높이마다 인벤토리 초기화
            for (int i = 0; i < N * M; i++) {
                int diff = ground[i] - h;
                if (diff > 0) { // 블록 제거
                    time += diff * 2;
                    inventory += diff; // 인벤토리에서 블록 추가
                } else if (diff < 0) { // 블록 추가
                    time -= diff; // diff가 음수이므로 -를 붙여줌
                    inventory += diff; // 인벤토리에서 블록을 사용
                }
            }
            if (inventory >= 0 && time <= resultTime) {
                if (time < resultTime || h > resultHeight) { // 같은 시간일 때 더 큰 높이 선택
                    resultTime = time;
                    resultHeight = h;
                }
            }
        }
        System.out.println(resultTime + " " + resultHeight);
    }
}
