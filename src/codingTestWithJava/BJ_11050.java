package codingTestWithJava;

/*
Solved.ac class project

class 2


latency
 */
/*
https://www.acmicpc.net/problem/11050
이항 계수 1 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	23932	15431	13302	64.768%
문제
자연수 \(N\)과 정수 \(K\)가 주어졌을 때 이항 계수
\(\binom{N}{K}\)를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 \(N\)과 \(K\)가 주어진다. (1 ≤ \(N\) ≤ 10, 0 ≤ \(K\) ≤ \(N\))

출력

\(\binom{N}{K}\)를 출력한다.
 */

import java.util.Scanner;

public class BJ_11050 {

    public static void main(String[] args) {
        BJ_11050 test = new BJ_11050();
    }

    public BJ_11050(){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        System.out.println(solution2(N,M));
    }

    public int solution(int N,int K){
        int top=1;
        int down =1;
        for (int i = 1 ; i <= K ; i++){
            top *=(N+1-i);
        }

        for (int i = 1 ; i <= K ; i++){
            down *=i;
        }

        return  top/down;
    }

    public int solution2(int N , int K){
        if(K ==0 || N==K){
            return 1;
        }

        return solution2(N-1,K) + solution2(N-1,K-1);

    }


}
