package codingTestWithJava;
/*
Solved.ac class project

class 3

 */
/*
https://www.acmicpc.net/problem/1697

숨바꼭질 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	122150	34400	21450	24.974%
문제
수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

입력
첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

출력
수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1697 {

    public static void main(String[] args) throws IOException {
         BJ_1697 test =new BJ_1697();
    }


    public BJ_1697() throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in ));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int start = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        System.out.println(solution(start,target));
    }

    private int solution(int start, int target) {
        int[] dp = new int[100001];

//        if(target%2==0){
//            //짝수 일 때
//            target/2,target-1
//        }else{
//            //홀수 일 때
//            (target-1)/2
//            (target+1)/2
//
//
//        }

        return 0;
    }
//
//
//    private boolean isPossibleDown(int cord){
//
//    }


}
