package codingTestWithJava;

/*
Solved.ac class project

class 3

 */

/*
https://www.acmicpc.net/problem/1074
Z 실패
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초 (추가 시간 없음)	512 MB	36047	12127	9027	36.588%
문제
한수는 크기가 2N × 2N인 2차원 배열을 Z모양으로 탐색하려고 한다. 예를 들어, 2×2배열을 왼쪽 위칸, 오른쪽 위칸, 왼쪽 아래칸, 오른쪽 아래칸 순서대로 방문하면 Z모양이다.



N > 1인 경우, 배열을 크기가 2N-1 × 2N-1로 4등분 한 후에 재귀적으로 순서대로 방문한다.

다음 예는 22 × 22 크기의 배열을 방문한 순서이다.



N이 주어졌을 때, r행 c열을 몇 번째로 방문하는지 출력하는 프로그램을 작성하시오.

다음은 N=3일 때의 예이다.



입력
첫째 줄에 정수 N, r, c가 주어진다.

출력
r행 c열을 몇 번째로 방문했는지 출력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1074 {
    public static void main(String[] args) throws IOException {
        BJ_1074 test = new BJ_1074();
    }

    public BJ_1074() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(stk.nextToken());
        int r = Integer.parseInt(stk.nextToken());
        int c = Integer.parseInt(stk.nextToken());

        System.out.println(solution(N,r,c,0,0,0));
    }

    private int solution(int n, int r, int c,int start_x,int start_y,int start_val) {


        int cur_n = n-1;
        //분할할 길이
        int len = (int) Math.pow(2,cur_n);
        int row=0,col=0;
        int val_wieght = 0;
        int[][] loc = {{0,0},
                {0,1},
                {1,0},
                {1,1}} ;

       //영역 분할
        for (int i = 0 ; i < 4 ; i++){
            row = start_x + loc[i][0]*len;
            col = start_y + loc[i][1]*len;
            //해당 row, col 이 가지고 있는 순번을 구하기 위한 가중치
            val_wieght = i*len*len;
            // 해당 영역에 좌표가 있다면 out
            if(r>= row && r<row+len && c>=col && c < col+len ){
                break;
            }
        }

        //row col 이 해당 좌표라면 return
        if(r==row && c == col ){
            return start_val +val_wieght;
        }

        //아니라면 다시 해당영역 분할
        return solution(cur_n,r,c,row,col,start_val+val_wieght);

    }


}
