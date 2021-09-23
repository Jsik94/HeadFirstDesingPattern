package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/2741
N 찍기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	171652	89411	76458	53.679%
문제
자연수 N이 주어졌을 때, 1부터 N까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 100,000보다 작거나 같은 자연수 N이 주어진다.

출력
첫째 줄부터 N번째 줄 까지 차례대로 출력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2741 {
    public static void main(String[] args) throws IOException {
        BJ_2741 test =new BJ_2741();
    }

    public BJ_2741() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num =Integer.parseInt(br.readLine().toString());

        System.out.println(solution(num));
    }

    public StringBuilder solution (int num){

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < num ; i++){
            sb.append(i+1);
            if(i != num-1){
                sb.append("\n");
            }
        }

        return sb;
    }

}
