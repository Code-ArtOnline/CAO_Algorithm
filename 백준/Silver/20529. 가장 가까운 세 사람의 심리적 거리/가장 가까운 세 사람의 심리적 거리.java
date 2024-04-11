import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");

            if(N > 32) {
                System.out.println(0);
                continue;
            }

            String[] mbti = new String[N];

            for(int j = 0; j < N; j++) {
                mbti[j] = st.nextToken();
            }

            int min = Integer.MAX_VALUE;

            for(int a = 0; a < N; a++) {
                for(int b = a + 1; b < N; b++) {
                    for(int c = b + 1; c < N; c++) {
                        int cnt = 0;
                        for(int j = 0; j < 4; j++) {
                            cnt += mbti[a].charAt(j) != mbti[b].charAt(j) ? 1 : 0;
                            cnt += mbti[b].charAt(j) != mbti[c].charAt(j) ? 1 : 0;
                            cnt += mbti[c].charAt(j) != mbti[a].charAt(j) ? 1 : 0;
                        }
                        min = Math.min(cnt, min);
                        if(min == 0) break;
                    }
                }
            }
            System.out.println(min);
        }
    }
}