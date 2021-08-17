package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/10951
A+B - 4
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	156321	54678	46570	35.711%
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
각 테스트 케이스마다 A+B를 출력한다.

틀린 원인
우리가 테스트 할때는 엔터든 스페이스는 EOF로 생각하지 않으나
백준에서는 SC 값을 던져주고 끝내기 때문에 종결 조건을 만들어줘야함
Scanner

 */



import java.util.NoSuchElementException;
import java.util.Scanner;

public class BJ_10951 {

    public static void main(String[] args) {
        BJ_10951 test = new BJ_10951();
    }

    public BJ_10951() throws NoSuchElementException {

        Scanner sc =new Scanner(System.in);
        while(sc.hasNext()){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int answer= solution(num1,num2);
            System.out.println(answer);
        }

    }

    public int solution (int num1, int num2){

        return num1+num2;
    }


}
