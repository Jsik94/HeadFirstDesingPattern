package codingTestWithJava;

/*

Solved.ac class project

class 3


latency
 */


/*
https://www.acmicpc.net/problem/1676
팩토리얼 0의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	29109	13649	11347	47.795%
문제
N!에서 뒤에서부터 처음 0이 아닌 숫자가 나올 때까지 0의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N이 주어진다. (0 ≤ N ≤ 500)

출력
첫째 줄에 구한 0의 개수를 출력한다.
 */


import java.util.Scanner;

public class BJ_1676 {

    final static int MAX_VALUE =500;

    public static void main(String[] args) {
        BJ_1676 test = new BJ_1676();
    }

    public BJ_1676() {
        Scanner sc = new Scanner(System.in);

        int fac = sc.nextInt();

        System.out.println(solution(fac));
    }

    private int solution (int factorial){

        int cnt_2 =0;
        int cnt_5 = 0;

        for (int i = 1 ; i < 10 ; i++){

            cnt_2+= factorial/ Math.pow(2,i);
            cnt_5+= factorial/Math.pow(5,i);

        }


        int result = Math.min(cnt_2,cnt_5);



        return result;
    }

}
