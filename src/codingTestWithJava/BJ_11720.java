package codingTestWithJava;
/*
Solved.ac class project

class 1

 */
/*
https://www.acmicpc.net/problem/11720
숫자의 합
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	109227	56566	48268	53.163%
문제
N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄에 숫자 N개가 공백없이 주어진다.
 */

import java.util.Scanner;

public class BJ_11720 {
    public static void main(String[] args) {
        BJ_11720 test = new BJ_11720();
    }

    public BJ_11720(){
        Scanner sc = new Scanner(System.in);
        sc.nextInt();
        sc.nextLine();
        String data =sc.nextLine();

        System.out.println(solution(data));
    }

    public int solution(String data){
        int reuslt = 0;
        for(int i =0 ; i < data.length() ; i++){
            reuslt += Character.getNumericValue(data.charAt(i));
        }
        return reuslt;
    }
}

