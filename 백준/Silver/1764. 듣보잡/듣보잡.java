import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정수 N과 M을 입력 받기
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //빠른 탐색을 위한 HashSet과 정렬을 사용하기 위한 ArrayList
        HashSet<String> set = new HashSet<>();
        ArrayList<String> array = new ArrayList<>();

        //듣도 못한 사람들 Set 저장하기
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        //보도 못한 사람들 입력 받기
        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            //근데 만약? 입력 받는 이름이 보도 못한 사람들 입력에 있다면? array에 추가
            if (set.contains(temp)) {
                array.add(temp);
            }
        }

        //array에 들어간 것들을 사전순으로 정렬
        Collections.sort(array);
        
        System.out.println(array.size());
        for (String str : array) {
            System.out.println(str);
        }

    }
}