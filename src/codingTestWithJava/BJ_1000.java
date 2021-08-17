package codingTestWithJava;
/*
Solved.ac class project

class 1

 */



/*

https://www.acmicpc.net/problem/1000
A+B 다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	439964	187256	135040	43.453%
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A+B를 출력한다.


 */

import java.util.Scanner;

public class BJ_1000 {

    public static void main(String[] args) {
        BJ_1000 test = new BJ_1000();
    }

    public BJ_1000 (){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int answer = solution(a,b);

        System.out.println(answer);
    }

    public int solution(int A, int B){

        return A+B;
    }

}
