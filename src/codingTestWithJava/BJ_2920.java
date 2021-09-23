package codingTestWithJava;

/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/2920

음계 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	55609	29350	25350	54.247%
문제
다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다. 이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.

1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.

연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.

입력
첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.

출력
첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.

 */


import java.util.Arrays;
import java.util.Scanner;

public class BJ_2920 {

    int[]  ascending = new int[8];
    int[]  descending = new int[8];

    public static void main(String[] args) {
        BJ_2920 test =new BJ_2920();
    }

    public BJ_2920(){
        Scanner sc =new Scanner(System.in);
        int[] arr = new int[8];

        for (int i = 0 ; i < arr.length ; i++){
            ascending[i] = i+1;
            descending[i] = arr.length -i;
            arr[i] = sc.nextInt();
        }

        System.out.println(solution(arr));

    }

    public String solution(int[] arr){
        String answer ;

        //equals가 보는건 같은 객체 인지의 여부임 내용물이 아님
        if( Arrays.equals(arr,ascending)){
            answer = "ascending";
        }else if ( Arrays.equals(arr,descending)){
            answer = "descending";
        }else{
            answer = "mixed";
        }

        return answer;
    }

}
