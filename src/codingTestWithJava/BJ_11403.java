package codingTestWithJava;
/*
Solved.ac class project

class 3

 */
/*
https://www.acmicpc.net/problem/11403
경로 찾기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	29201	16295	11578	55.154%
문제
가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N (1 ≤ N ≤ 100)이 주어진다. 둘째 줄부터 N개 줄에는 그래프의 인접 행렬이 주어진다. i번째 줄의 j번째 숫자가 1인 경우에는 i에서 j로 가는 간선이 존재한다는 뜻이고, 0인 경우는 없다는 뜻이다. i번째 줄의 i번째 숫자는 항상 0이다.

출력
총 N개의 줄에 걸쳐서 문제의 정답을 인접행렬 형식으로 출력한다. 정점 i에서 j로 가는 경로가 있으면 i번째 줄의 j번째 숫자를 1로, 없으면 0으로 출력해야 한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_11403 {

    public static void main(String[] args) throws IOException {
        BJ_11403 test =new BJ_11403();
    }

    public BJ_11403() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk ;
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];

        for (int i = 0 ; i < N ;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for (int j = 0 ; j < N ;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        solution(arr,N);

        StringBuilder sb = new StringBuilder();

        for (int[] row : arr){
            for (int atom : row){
                sb.append(atom+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    int[][] solution (int[][] arr,int N){

        for (int k = 0 ; k < N ; k++){
            for (int i = 0 ; i < N ; i++){
                for (int j = 0; j < N ; j++){
                   if(arr[i][j]==0){
                        if(arr[i][k] !=0 && arr[k][j] !=0){
                            arr[i][j] = 1;
                        }
                   }
                }
            }
        }

        return arr;
    }


}
