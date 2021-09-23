package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 6min 45s
 */

/*
https://www.acmicpc.net/problem/1929

소수 구하기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	115574	32350	22900	27.176%
문제
M이상 N이하의 소수를 모두 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 M과 N이 빈 칸을 사이에 두고 주어진다. (1 ≤ M ≤ N ≤ 1,000,000) M이상 N이하의 소수가 하나 이상 있는 입력만 주어진다.

출력
한 줄에 하나씩, 증가하는 순서대로 소수를 출력한다.

 */

import java.util.Scanner;

public class BJ_1929 {

    public static void main(String[] args) {
        BJ_1929 test = new BJ_1929();
    }

    public BJ_1929(){
        Scanner sc =new Scanner(System.in);
        StringBuilder sb =new StringBuilder();
        int start = sc.nextInt();
        int end = sc.nextInt();

        //걸러내는 방식
        boolean[] arr = new boolean[end+1];

        arr[0] = true;
        arr[1] = true;
        for (int i = 2 ; i*i < end+1 ; i++){
            int j = 2;

            while (i*j <= end){
                arr[i*j] =true;
                j++;
            }

        }


        for (int i = start ; i < end+1 ; i++){
            int cnt = 0 ;
            int divider = 1;

            if(arr[i]){
                continue;
            }else{

                sb.append(i+"\n");
            }
        }

        System.out.println(sb);
    }
}