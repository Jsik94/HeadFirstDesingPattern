package codingTestWithJava;

/*
https://www.acmicpc.net/problem/1330

두 수 비교하기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	153923	74730	64415	51.065%
문제
두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.

출력
첫째 줄에 다음 세 가지 중 하나를 출력한다.

A가 B보다 큰 경우에는 '>'를 출력한다.
A가 B보다 작은 경우에는 '<'를 출력한다.
A와 B가 같은 경우에는 '=='를 출력한다.
제한
-10,000 ≤ A, B ≤ 10,000



 */


import java.util.Scanner;

public class BJ_1330 {

    public static void main(String[] args) {
        BJ_1330 test =new BJ_1330();
    }

    public BJ_1330(){
        Scanner sc = new Scanner(System.in);
        int a,b;

        a = sc.nextInt();
        b = sc.nextInt();

        String answer = solution(a,b);
        System.out.println(answer);
    }

    public String solution(int a, int b){
        String answer ;

        if(a< b){

            answer = new String("<");
        }else if(a > b){

            answer = new String(">");
        }else{

            answer = new String("==");
        }

        return answer;
    }

}
