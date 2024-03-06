import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // 테스트 개수
        while (t-- > 0) {
            int n = sc.nextInt(); // 참가자 수
            int x = sc.nextInt(); // 트랙의 길이
            int y = sc.nextInt(); // 부스터 속도

            double min = x;
            for (int i = 0; i < n - 1; i++) { //참가자들의 속도
                int v = sc.nextInt();
                min = Math.min(min, 1.0 * x / v); //경쟁자들 중 낮은 기록
            }

            int v = sc.nextInt(); //나의 속도

            // 기본 속도로 이기는 경우
            if (min > 1.0 * x / v) {
                System.out.println(0);
                continue;
            }

            int left = 0;
            int right = y; //부스터 최대값을 오른쪽으로

            //부스터를 써야 이기는 경우 (이진 탐색)
            while (left <= right) {  //부스터가 적정값을 찾을 때까지
                int mid = (left + right) / 2;
                double booster = 1 + 1.0 * (x - mid) / v; //현재 부스터값으로 나온 기록
                if (booster >= min) { //현재 기록이 느리거나 공동 우승일 경우
                    left = mid + 1; //부스터를 1 높이기
                } else { //현재 기록이 너무 빠르면 부스터를 1 낮추기
                    right = mid - 1;
                }
            }

            // 부스터를 써도 이기지 못하는 경우
            if (left > y) {
                System.out.println(-1);
            } else {
                System.out.println(left);
            }
        }
    }
}