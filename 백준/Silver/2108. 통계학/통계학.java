import java.util.*;

public class Main {
    static class QuickSort {
        static void swap(int[] a, int idx1, int idx2) {
            int t = a[idx1];
            a[idx1] = a[idx2];
            a[idx2] = t;
        }

        static void quickSort(int[] a, int left, int right) {
            int pl = left;
            int pr = right;
            int x = a[(pl + pr) / 2];
            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) quickSort(a, left, pr);
            if (pl < right) quickSort(a, pl, right);
        }
    }

    static class Mode {
        static int findMode(int[] arr) {
            // 키: 배열 요소, 값: 빈도수
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            int maxFreq = 0;
            ArrayList<Integer> modeList = new ArrayList<>();

            for (int num : arr) { // 배열 전체 순회
                // num의 빈도수 +1
                int freq = freqMap.getOrDefault(num, 0) + 1;
                freqMap.put(num, freq); // 빈도수 업데이트
                if (freq > maxFreq) { // 빈도수가 max 빈도수보다 크면
                    maxFreq = freq; // max 빈도수 업데이트
                    modeList.clear(); // mode 후보 리스트 비우고
                    modeList.add(num); // 해당 숫자만 다시 mode 후보 리스트에 넣어둠
                } else if (freq == maxFreq) { // 빈도수가 max 빈도수와 같으면
                    modeList.add(num); // mode 후보 리스트에 넣어둠
                }
            }
            // modeList에 수가 하나라면 그 수를, 여러개라면 두 번째로 작은 값을 반환
            return modeList.size() > 1 ? modeList.get(1) : modeList.get(0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        sc.close();

        double mean = (double) sum / n;
        int roundedMean = (int) Math.round(mean);

        QuickSort.quickSort(arr, 0, n - 1);

        int median = arr[n / 2];
        int range = arr[n - 1] - arr[0];
        int mode = Mode.findMode(arr);

        System.out.println(roundedMean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
