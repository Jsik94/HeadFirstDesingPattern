package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/9498
시험 성적
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	161806	90275	78863	56.855%
문제
시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.

출력
시험 성적을 출력한다.
 */

import java.util.Scanner;

public class BJ_9498 {

    public static void main(String[] args) {
        BJ_9498 test = new BJ_9498();
    }

    public BJ_9498(){
        Scanner sc = new Scanner(System.in);
        int score = sc.nextInt();

        char answer = solution(score);

        System.out.println(answer);
    }

    public char solution(int score){
        char result ;

        if(score<=100 && score >= 90){
            result = 'A';
        }else if(score>=80){
            result = 'B';
        }else if(score>=70){
            result = 'C';
        }else if(score>=60){
            result = 'D';
        }else{
            result = 'F';
        }
        return result;
    }


}
