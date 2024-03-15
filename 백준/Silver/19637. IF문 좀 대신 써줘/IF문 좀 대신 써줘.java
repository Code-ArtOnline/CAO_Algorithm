import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String title[] = new String[n];
        int power[] = new int[n];

        // n개의 칭호와 파워를 입력 받아 배열에 저장
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            title[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트 케이스 수만큼 반복
        for (int i = 0; i < m; i++) {
            int characterPower = Integer.parseInt(br.readLine()); //캐릭터의 파워 입력

            // 입력받은 캐릭터의 파워에 대응하는 캐릭터 칭호를 출력
            bw.write(getName(characterPower, n, power, title) + "\n");
        }
        // 출력 버퍼 비우고, 버퍼 닫기
        bw.flush();
        br.close();
    }

    // 이진 탐색을 이용하여 주어진 파워에 대응하는 캐릭터의 이름을 찾는 메서드
    private static String getName(int characterPower, int length, int[] power, String[] title) {
        // 시작 인덱스와 끝 인덱스 초기화
        int start = 0;
        int end = length - 1; //인덱스는 0부터 시작하므로
        int answer = end;

        // 시작 인덱스가 끝 인덱스보다 작거나 같은 동안 반복
        while (start <= end) {
            // 중간 인덱스 계산
            int mid = (start + end) / 2;

            // 현재 찾으려는 캐릭터의 값이 칭호의 파워 보다 작거나 같으면 
            if (characterPower <= power[mid]) {
                // 현재 중간 답보다 작으면 업데이트
                answer = Math.min(mid, answer);
                // 끝 인덱스를 중간 인덱스의 왼쪽으로 이동하여 범위 축소
                end = mid - 1;
            } else {
                //높으면 오른쪽으로 이동하여 중간값 이동 
                start = mid + 1;
            }
        }
        // 찾은 캐릭터의 이름 반환
        return title[answer];
    }
}
