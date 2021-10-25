package codingTestWithJava;
/*
Solved.ac class project

class 3

latency
 */
/*
https://www.acmicpc.net/problem/5525

IOIOI 실패서브태스크출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	11045	3292	2645	31.821%
문제
N+1개의 I와 N개의 O로 이루어져 있으면, I와 O이 교대로 나오는 문자열을 PN이라고 한다.

P1 IOI
P2 IOIOI
P3 IOIOIOI
PN IOIOI...OI (O가 N개)
I와 O로만 이루어진 문자열 S와 정수 N이 주어졌을 때, S안에 PN이 몇 군데 포함되어 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. 둘째 줄에는 S의 길이 M이 주어지며, 셋째 줄에 S가 주어진다.

출력
S에 PN이 몇 군데 포함되어 있는지 출력한다.

제한
1 ≤ N ≤ 1,000,000
2N+1 ≤ M ≤ 1,000,000
S는 I와 O로만 이루어져 있다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_5525 {

    public static void main(String[] args) throws IOException {
        BJ_5525 test = new BJ_5525();
    }

    public BJ_5525() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int len = Integer.parseInt(br.readLine());
        String str = br.readLine();
        List<Integer> start = new ArrayList<>();

        for (int i = 0 ; i < str.length()-1;i++){
            if( str.charAt(i) =='I'){
                start.add(i);
            }
        }

        int cnt=0,result=0 ;
        for (int i = 1 ; i < start.size() ; i++){
            if(start.get(i) - start.get(i-1) == 2){
                cnt++;
            }else{
                cnt =0;
            }

            if( cnt>= N){
                result++;
            }


        }

        System.out.println(result);


    }
}
