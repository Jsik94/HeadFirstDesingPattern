package codingTestWithJava;

/*
Solved.ac class project

class 3


 */

/*
https://www.acmicpc.net/problem/1003
피보나치 함수 실패
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.25 초 (추가 시간 없음)	128 MB	130720	35362	27665	30.523%
문제
다음 소스는 N번째 피보나치 수를 구하는 C++ 함수이다.


int fibonacci(int n) {
    if (n == 0) {
        printf("0");
        return 0;
    } else if (n == 1) {
        printf("1");
        return 1;
    } else {
        return fibonacci(n‐1) + fibonacci(n‐2);
    }
}
fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.

fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
fibonacci(0)은 0을 출력하고, 0을 리턴한다.
fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다.

각 테스트 케이스는 한 줄로 이루어져 있고, N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

출력
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다. */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_1003 {


    public static void main(String[] args) throws IOException {
        BJ_1003 test = new BJ_1003();
    }

    public BJ_1003() throws IOException {

        runNavigator(3);
        runNavigator(2);
    }

    private void runNavigator(int way) throws IOException {

        switch (way) {

            case 1:
                //Pair를 이용한 DP
                runPairDP();
                break;

            case 2:
                //DP만을 이용하여 품
                runOnlyDP();

            case 3:
                //DP도 이용안하고 품
                runNoArray();

        }


    }

    private void runNoArray() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        int one = 0;
        int zero = 1;

        for (int i = 0; i < tc; i++) {
            int target = Integer.parseInt(br.readLine());

            int[] result = solution3(one, zero, target);
            sb.append(result[0] + " " + result[1] + "\n");
        }
        System.out.println(sb);

    }

    private int[] solution3(int one, int zero, int target) {


        int plus_data = one + zero;
        for (int i = 0; i < target; i++) {
            zero = one;
            one = plus_data;
            plus_data = one + zero;
        }

        return new int[]{zero, one};
    }

    private void runOnlyDP() {


        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[1][1] = 1;
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int target = sc.nextInt();

            int[] result = solution2(dp, target);
            sb.append(result[0] + " " + result[1] + "\n");
        }

        System.out.println(sb);

    }

    private int[] solution2(int[][] dp, int target) {

        for (int i = 2; i <= target; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
        }

        return dp[target];
    }

    public void runPairDP() {
        //left : 0 right : 1
        Pair<Integer, Integer>[] dp = new Pair[41];
        dp[0] = new Pair<>(1, 0);
        dp[1] = new Pair<>(0, 1);

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int target = sc.nextInt();

            Pair<Integer, Integer> result = solution(dp, target);
            sb.append(result.left + " " + result.right + "\n");
        }

        System.out.println(sb);
    }


    public Pair<Integer, Integer> solution(Pair<Integer, Integer>[] dp, int target) {
        for (int i = 2; i <= target; i++) {
            if (dp[i] != null) {
                continue;
            }
            int zero = dp[i - 1].left + dp[i - 2].left;
            int right = dp[i - 1].right + dp[i - 2].right;
            dp[i] = new Pair<>(zero, right);
        }


        return dp[target];
    }


    class Pair<L, R> {
        L left;
        R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }
    }

}
