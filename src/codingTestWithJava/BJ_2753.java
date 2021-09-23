package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/2753
윤년
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	126414	68079	59295	54.273%
문제
연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.

윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.

예를 들어, 2012년은 4의 배수이면서 100의 배수가 아니라서 윤년이다. 1900년은 100의 배수이고 400의 배수는 아니기 때문에 윤년이 아니다. 하지만, 2000년은 400의 배수이기 때문에 윤년이다.

입력
첫째 줄에 연도가 주어진다. 연도는 1보다 크거나 같고, 4000보다 작거나 같은 자연수이다.

출력
첫째 줄에 윤년이면 1, 아니면 0을 출력한다.
 */

import java.util.Scanner;

public class BJ_2753 {

    public static void main(String[] args) {
        BJ_2753 test = new BJ_2753();
    }

    public BJ_2753(){
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();

        int answer = solution(year);
        System.out.println(answer);
    }

    public int solution (int year){
        if( (year % 4 ==0 && year % 100 != 0) || (year % 4 ==0 && year % 400 ==0) ){
            return 1;
        }
        return 0;
    }


}
