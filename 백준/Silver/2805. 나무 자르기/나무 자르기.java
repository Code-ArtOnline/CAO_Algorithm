import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 나무의 수 N
        int M = Integer.parseInt(st.nextToken()); // 상근이가 집으로 가져가려는 나무의 길이 M
        st = new StringTokenizer(br.readLine());
        int [] tree = new int [N]; // 나무의 높이 배열
        int max = 0;
        int min = 0;

        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int height : tree) {
                if (height - mid > 0) {
                    sum += (height - mid);
                }
            }
            if (sum < M) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);

    }
}
