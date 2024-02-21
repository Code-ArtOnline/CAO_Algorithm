import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        // 존재하는 숫자들을 해시맵에 저장
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int num : array) {
            hashMap.put(num, true);
        }

        // 검사할 숫자 개수와 숫자들 입력 받기
        int m = Integer.parseInt(br.readLine());
        int[] numbersToCheck = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            numbersToCheck[i] = Integer.parseInt(st.nextToken());
        }

        // 숫자가 존재하는지 확인하고 출력
        StringBuilder sb = new StringBuilder();
        for (int num : numbersToCheck) {
            if (hashMap.containsKey(num)) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
