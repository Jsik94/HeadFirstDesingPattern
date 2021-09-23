package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/10818
최소, 최대
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	139477	59878	47158	43.323%
문제
N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수 N (1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄에는 N개의 정수를 공백으로 구분해서 주어진다. 모든 정수는 -1,000,000보다 크거나 같고, 1,000,000보다 작거나 같은 정수이다.

출력
첫째 줄에 주어진 정수 N개의 최솟값과 최댓값을 공백으로 구분해 출력한다.

 */


import java.util.Scanner;

public class BJ_10818 {

    public static void main(String[] args) {
        BJ_10818 test = new BJ_10818();
    }

    public BJ_10818() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] data = new int[cnt];
        for(int i = 0 ; i < cnt ; i++){
            data[i] = sc.nextInt();
        }
        int[] answers = solution(data);
        System.out.println(answers[1] + " " + answers[0]);
    }

    public int[] solution(int[] data) {
        int[] result = new int[2];
        result[0] = -1000000;
        result[1] = 1000000;

        for (int num : data){
            if( num > result[0]){
                result[0] = num;
            }

            if(num < result[1]){
                result[1] = num;
            }
        }

        return result;
    }


}
