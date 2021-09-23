package codingTestWithJava;


/*
Solved.ac class project

class 3

 */

/*
https://www.acmicpc.net/problem/11726
2×n 타일링
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	89602	33579	24476	35.231%
문제
2×n 크기의 직사각형을 1×2, 2×1 타일로 채우는 방법의 수를 구하는 프로그램을 작성하시오.

아래 그림은 2×5 크기의 직사각형을 채운 한 가지 방법의 예이다.



입력
첫째 줄에 n이 주어진다. (1 ≤ n ≤ 1,000)

출력
첫째 줄에 2×n 크기의 직사각형을 채우는 방법의 수를 10,007로 나눈 나머지를 출력한다.



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11726 {




    public static void main(String[] args) throws IOException {
        BJ_11726 tset =new BJ_11726();
    }


    int[] dp = new int[1001];
    public BJ_11726() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        System.out.println(solution(num));

    }

    int solution(int num){

        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3 ; i <dp.length;i++){
            dp[i] = (dp[i-1]+dp[i-2])%10007;


        }
        return dp[num];
    }
}
