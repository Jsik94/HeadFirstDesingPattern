package codingTestWithJava;
/*
Solved.ac class project

class 1

 */
/*
https://www.acmicpc.net/problem/10952
A+B - 5
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	116409	60297	52354	52.323%
문제
두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있다.

각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)

입력의 마지막에는 0 두 개가 들어온다.

출력
각 테스트 케이스마다 A+B를 출력한다.


 */


import java.util.NoSuchElementException;
import java.util.Scanner;

public class BJ_10952 {
    public static void main(String[] args) {
        BJ_10952 test = new BJ_10952();
    }

    public BJ_10952() throws NoSuchElementException {

        Scanner sc =new Scanner(System.in);
        while(true){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if(num1 ==0 && num2 ==0){
                break;
            }
            int answer= solution(num1,num2);
            System.out.println(answer);
        }

    }

    public int solution (int num1, int num2){

        return num1+num2;
    }

}
