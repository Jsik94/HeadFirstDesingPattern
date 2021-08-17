package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/2438
별 찍기 - 1
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	149833	91889	78278	62.440%
문제
첫째 줄에는 별 1개, 둘째 줄에는 별 2개, N번째 줄에는 별 N개를 찍는 문제

입력
첫째 줄에 N(1 ≤ N ≤ 100)이 주어진다.

출력
첫째 줄부터 N번째 줄까지 차례대로 별을 출력한다.



 */

import java.util.Scanner;

public class BJ_2438 {

    public static void main(String[] args) {
        BJ_2438 test = new BJ_2438();
    }

    public BJ_2438(){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int cnt = sc.nextInt();

        String[] answer = solution(cnt);

        for (int i = 0 ; i < answer.length ; i++){
            sb.append(answer[i]);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public String[] solution(int cnt){
        String[] answer = new String[cnt];

        for (int i = 0 ; i < answer.length ; i++){
            answer[i] = "*";
            for (int j = 0 ; j < i ;j++){
                answer[i] +="*";
            }
        }


        return answer;
    }

}
