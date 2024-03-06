import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < t; i++) { // 테스트 케이스 수만큼 반복

            // note1 입력
            int n = Integer.parseInt(br.readLine());
            int[] note1 = new int[n];
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < n; j++) {
                note1[j] = Integer.parseInt(st.nextToken());
            }

            // note2 입력
            int m = Integer.parseInt(br.readLine());
            int[] note2 = new int[m];
            st = new StringTokenizer(br.readLine()); 
            for (int j = 0; j < m; j++) {
                note2[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(note1); // 이진 탐색할 note1 정렬
            StringBuilder sb = new StringBuilder(); 
            for (int num : note2) { // note2의 각 원소에 대해 note1에서 이진 탐색
                int idx = Arrays.binarySearch(note1, num); // note1에 num이 있다면 해당 인덱스 반환
                if (idx >= 0) {
                    sb.append(1).append('\n');
                } else {
                    sb.append(0).append('\n');
                }
            }
            System.out.print(sb.toString()); // 한 번에 결과 출력
        }
    }
}
