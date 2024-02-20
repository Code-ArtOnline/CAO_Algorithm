import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //빠른 속도를 위한 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) { // 입력 받은 갯수 N 만큼 단어들 입력 받아 배열에 넣기
            arr[i] = br.readLine();
        }

        // 삽입 정렬 알고리즘 적용
        for (int i = 1; i < N; i++) {
            String key = arr[i]; //삽입을 하기 위한 키, 기준
            int j = i - 1; //배열 이전 것과 비교하기

            //1. 단어 길이순으로 정렬하기
            while (j >= 0 && arr[j].length() > key.length()) { // 기준으로 잡은 길이 보다 긴 길이 찾기
                arr[j + 1] = arr[j]; //길이가 긴 것을 오른쪽 한 칸으로 이동하기
                j--; //그리고 왼쪽으로 이동하면서 계속 길이 비교하기
            }
            //2. 길이가 같은 경우 사전 순으로 정렬하기
            // 길이가 같은 경우 and  사전 순으로 더 뒤에 있는 것
            while (j >= 0 && arr[j].length() == key.length() && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j]; //사전 순으로 뒤에 있는 것을 한 칸 뒤로 이동하기
                j--; //
            }
            //적절한 위치를 찾으면 삽입하기
            arr[j + 1] = key;
        }

        StringBuilder sb = new StringBuilder();
        //첫번째 단어를 sb에 저장 
        sb.append(arr[0]).append('\n');
        
        //두 번째 부터 마지막까지 반복
        for (int i = 1; i < N; i++) {
            // 중복되지 않는 단어만 저장
            if (!arr[i].equals(arr[i - 1])) { //현재 단어가 이전 단어와 같지 않은지 체크
                sb.append(arr[i]).append('\n'); //다르면 차례차례 저장
            }
        }
        System.out.println(sb);
    }
}
