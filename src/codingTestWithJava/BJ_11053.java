package codingTestWithJava;

/*
Solved ac : silver 2


 */

/*
https://www.acmicpc.net/problem/11053

가장 긴 증가하는 부분 수열
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	84236	32772	21496	37.004%
문제
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성하시오.

예를 들어, 수열 A = {10, 20, 10, 30, 20, 50} 인 경우에 가장 긴 증가하는 부분 수열은 A = {10, 20, 10, 30, 20, 50} 이고, 길이는 4이다.

입력
첫째 줄에 수열 A의 크기 N (1 ≤ N ≤ 1,000)이 주어진다.

둘째 줄에는 수열 A를 이루고 있는 Ai가 주어진다. (1 ≤ Ai ≤ 1,000)

출력
첫째 줄에 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11053 {

    public static void main(String[] args) throws IOException {
        BJ_11053 test = new BJ_11053();
    }

    public BJ_11053() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk ;
        int len = Integer.parseInt(br.readLine());
        int[] arr =new int[len];
        stk = new StringTokenizer(br.readLine()," ");


        for(int i =0 ; i < arr.length ; i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }


        int result = solution(arr);



        System.out.println(result);

    }

    private int solution(int[] arr) {

        int[] DP = new int[arr.length];

        for (int i = 0 ; i < arr.length ;i++){
            //자기 자신만
            DP[i] = 1 ;

            for (int j = 0 ; j< i ; j++){

                //값이 크고 수열을 만들 수 있다면 길이 추가
                if(arr[j] < arr[i] && DP[j]+1 > DP[i]){
                    DP[i] = DP[j]+1;
                }

            }
        }

        //마지막이 최장길이를 보증하진 않음

        Arrays.sort(DP);

        return DP[arr.length-1];
    }
}
