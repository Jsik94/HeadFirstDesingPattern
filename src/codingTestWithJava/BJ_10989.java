package codingTestWithJava;
/*
Solved.ac class project

class 2


latency
 */
/*
https://www.acmicpc.net/problem/10989
수 정렬하기 3
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초 (하단 참고)	8 MB (하단 참고)	121073	25478	19611	23.003%
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10989 {

    public static void main(String[] args) throws IOException {
        BJ_10989 test =new BJ_10989();
    }

    public BJ_10989() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] datas = new int[tc];
        for (int i = 0 ; i < tc ; i++){
            datas[i] = Integer.parseInt(br.readLine());
        }

        //Arrays.sort(datas);

        //insertsort(datas);
        selectionSort(datas);

        for (int data : datas){
            sb.append(data+"\n");
        }

        System.out.println(sb);
    }

    public void selectionSort(int[] datas){

        for(int i=0; i < datas.length-1; i++){
            int min  = i ;
            for(int j=i+1 ; j < datas.length; j++){
                if(datas[min] > datas[j]){
                    min = j;
                }
            }
            int tmp = datas[i];
            datas[i] = datas[min];
            datas[min] = tmp;

        }
    }

    public void insertsort(int[] datas){

        for(int i=1; i < datas.length; i++) {
            for (int j = i; j > 0; j--) {

                if (datas[j] < datas[j - 1]) {
                    int tmp = datas[j];
                    datas[j] = datas[j - 1];
                    datas[j - 1] = tmp;
                } else {
                    break;
                }

            }
        }
    }
}
