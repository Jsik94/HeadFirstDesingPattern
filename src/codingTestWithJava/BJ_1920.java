package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 6min 45s
 */

/*
https://www.acmicpc.net/problem/1920
수 찾기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	98318	31282	20404	30.704%
문제
N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때, 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다. 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.

출력
M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.


 */


import java.util.Arrays;
import java.util.Scanner;

public class BJ_1920 {

    public static void main(String[] args) {
            BJ_1920 test = new BJ_1920();
    }

    public BJ_1920(){
        Scanner sc =new Scanner(System.in);
        StringBuilder sb = new StringBuilder();


        //N, A 입력
        int N = sc.nextInt();
        int[] A =new int[N];
        for (int i = 0 ; i < N ; i++){
            A[i]= sc.nextInt();
        }


        // 이진 탐색을 실행하기 위한 변수
        Arrays.sort(A);
        int start = 0;
        int end = N-1;


        //M 갯수 입력
        int M = sc.nextInt();
        for (int i = 0 ; i < M ; i++){

            int target = sc.nextInt();
            int answer =  binary_search(start,end,A,target);
            sb.append(answer);
            sb.append("\n");
        }

        System.out.println(sb);
    }


    //이진 탐색
    public int binary_search(int start,int end, int[] datas , int target){

        int mid = (start + end) / 2;


        //target과 같은 값을 찾을때는 1, 탐색을 해도 없으면 0
        if(datas[mid] == target){
            return 1;
        } else if (start > end) {
            return 0;
        }


        //중앙값과 비교를 통해 양쪽 끝 조절
        if(datas[mid] < target){
            start = mid +1;
        }else{
            end = mid -1;
        }

        return binary_search(start, end, datas, target);

    }
}
