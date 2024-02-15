import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        //3가지 자연수 값을 입력 받는 함수 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //0~9까지 사용된 횟수를 카운터 시켜줄 배열 생성
        int[] arr = new int[10];
        //3개의 자연수 입력 후 곱셈
        int number = Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine())
                * Integer.parseInt(br.readLine());

        //곱해진 값을 숫자형에서 => 문자형으로 변환
        String str = String.valueOf(number);

        //하나의 문자로 나눠진 값을 곱하여 해당 숫자에 배열에 카운터를 올려줌
        for (int j = 0; j <str.length(); j++){
            arr[str.charAt(j) - '0']++;
        }
        //0~9까지 사용된 횟수 출력
        for (int v: arr) {
                System.out.println(v);
        }
    }
}
