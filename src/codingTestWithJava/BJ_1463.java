package codingTestWithJava;

/*
Solved.ac class project

class 3

 */


/*
https://www.acmicpc.net/problem/1463
1로 만들기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.15 초 (하단 참고)	128 MB	163496	51993	32993	31.813%
문제
정수 X에 사용할 수 있는 연산은 다음과 같이 세 가지 이다.

X가 3으로 나누어 떨어지면, 3으로 나눈다.
X가 2로 나누어 떨어지면, 2로 나눈다.
1을 뺀다.
정수 N이 주어졌을 때, 위와 같은 연산 세 개를 적절히 사용해서 1을 만들려고 한다. 연산을 사용하는 횟수의 최솟값을 출력하시오.

입력
첫째 줄에 1보다 크거나 같고, 106보다 작거나 같은 정수 N이 주어진다.

출력
첫째 줄에 연산을 하는 횟수의 최솟값을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1463 {
    public static void main(String[] args) throws IOException {
        BJ_1463 test = new BJ_1463();
    }

    public BJ_1463() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int a = Integer.parseInt(br.readLine());
        System.out.println(solution(a));

    }

    int solution(int a) {


        int[] dp = new int[a + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            if (i % 3 == 0) {

                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

        }

        return dp[a];
    }


}
