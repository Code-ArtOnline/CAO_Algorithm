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
            HashMap<Integer, Integer> freqMap = new HashMap<>();
            int maxFreq = 0;
            ArrayList<Integer> modeList = new ArrayList<>();

            for (int num : arr) {
                int freq = freqMap.getOrDefault(num, 0) + 1;
                freqMap.put(num, freq);
                if (freq > maxFreq) {
                    maxFreq = freq;
                    modeList.clear();
                    modeList.add(num);
                } else if (freq == maxFreq) {
                    modeList.add(num);
                }
            }

            Collections.sort(modeList);
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
        double mean = (double) sum / n;
        int roundedMean = (int) Math.round(mean);

        QuickSort.quickSort(arr, 0, n - 1);

        int median;
        if (n % 2 == 0) {
            median = (arr[n / 2 - 1] + arr[n / 2]) / 2;
        } else {
            median = arr[n / 2];
        }

        int range = arr[n - 1] - arr[0];
        int mode = Mode.findMode(arr);

        System.out.println(roundedMean);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);
    }
}
