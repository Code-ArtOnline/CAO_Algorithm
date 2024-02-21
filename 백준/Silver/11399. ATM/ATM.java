import java.io.*;
import java.util.*;

public class Main {
    public static int waiting (int [] a, int k){
        int time = 0;
        for (int i = 0; i <= k; i++) {
            time += a[i];
        }
        return time;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[n];

        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        for (int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int total = 0;
        for (int i = 0; i < n; i++){
            total += waiting(arr,i);
        }
        System.out.println(total);
    }
}
