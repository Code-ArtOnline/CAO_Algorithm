import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = parseInt(st.nextToken());
        int c = parseInt(st.nextToken());

        int start = 1;
        int end = 1000000000;
        long sum = 0;

        int[] arr = new int[s];

        for (int i = 0; i < s; i++) {
            arr[i] = parseInt(br.readLine());
            sum += arr[i];
        }

        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 0; i < s; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= c)
                start = mid + 1;
            else
                end = mid - 1;
        }

        System.out.println(sum - (long) end * c);

    }
}