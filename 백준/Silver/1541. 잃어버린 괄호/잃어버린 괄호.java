import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2024.3.11
silver 2
백준 1541: 잃어버린 괄호
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        // '-'를 기준으로 입력 문자열 분리
        String[] subPart = input.split("-");

        int result = 0; // 결과값

        for (int i = 0; i < subPart.length; i++) {
            int tempSum = 0;

            // '+' 연산 처리
            String[] addPart = subPart[i].split("\\+");
            for (String num : addPart) {
                tempSum += Integer.parseInt(num);
            }

            // 첫 번째 부분 문자열에 대해서는 결과값에 더하고, 그 외에는 결과값에서 뺌
            if (i == 0) {
                result += tempSum;
            } else {
                result -= tempSum;
            }
        }

        System.out.println(result); 
    }
}
