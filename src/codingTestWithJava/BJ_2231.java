package codingTestWithJava;
/*
https://www.acmicpc.net/problem/2231

분해합 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	192 MB	54928	25532	20317	47.266%
문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.

자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

예제 입력 1
216
예제 출력 1
198

sol 1.
N 부터 시작하여 분해 합을 구한다.

N의 자릿수를 먼저 계산한다.
N + 자릿수들의 합 = 분해합

자릿수들의 합 -> while 을 통해 동적으로 갯수를 맞춰 구함

ex)
1 -> 1 + 자리(1)
    +1

27 -> 27 + 자리(2)
    +2+7


 */


import java.util.Scanner;

public class BJ_2231 {

    public static void main(String[] args) {
        BJ_2231 test = new BJ_2231();
    }

    public BJ_2231(){
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int answer = solution(num);
        System.out.println(answer);
    }

    public int solution(int num){
        int answer = 0;

        for (int i = 1 ; i < num ; i++){

            if (num == cal_func(i)){
                answer = i;
                break;
            }
        }

        return answer;
    }

    private int cal_func(int num){

        int origin = num;
        int sum = cal_digit(origin);

        return origin+sum;

    }


    private int cal_digit(int num){
        //int digit = 1;
        int sum = 0 ;
        while(num>0){
            //end point
            if(num/10==0){
                break;
            }else{
                //자릿수가 남아있다면 digit 추가
                sum += num%10 ;
                num = (int)num/10;
                //digit++;
            }
        }
        sum += num %10;
        return sum;

    }

}
