import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String board = br.readLine();
        StringBuilder answer = new StringBuilder();

        int countX = 0; // 'X'의 연속 길이를 세는 변수
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == 'X') {
                countX++;
            } else {
                if (countX % 2 != 0) { // 'X'의 연속 길이가 홀수면 폴리오미노로 덮을 수 없음
                    System.out.println(-1);
                    return;
                }

                while (countX >= 4) { // 가능한 많은 'X'를 AAAA로 덮음
                    answer.append("AAAA");
                    countX -= 4;
                }

                while (countX >= 2) { // 남은 'X'를 BB로 덮음
                    answer.append("BB");
                    countX -= 2;
                }

                answer.append("."); // 현재 위치의 '.' 추가
            }
        }

        // 문자열의 끝에 도달했을 때 남은 'X' 처리
        if (countX % 2 != 0) {
            System.out.println(-1);
            return;
        }

        while (countX >= 4) {
            answer.append("AAAA");
            countX -= 4;
        }

        while (countX >= 2) {
            answer.append("BB");
            countX -= 2;
        }

        System.out.println(answer.toString());
    }
}
