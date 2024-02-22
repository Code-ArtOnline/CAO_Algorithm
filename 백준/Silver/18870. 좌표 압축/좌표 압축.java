import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line, " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);

        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(sortedArr[i])) {
                map.put(sortedArr[i], rank++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map.get(arr[i])).append(" ");
        }
        System.out.println(sb.toString());
    }
}
