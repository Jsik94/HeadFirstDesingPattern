package codingTestWithJava;


/*
Solved.ac class project

class 3

latency
 */

/*
 https://www.acmicpc.net/problem/14500
테트로미노
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	46534	17282	11132	35.088%
문제
폴리오미노란 크기가 1×1인 정사각형을 여러 개 이어서 붙인 도형이며, 다음과 같은 조건을 만족해야 한다.

정사각형은 서로 겹치면 안 된다.
도형은 모두 연결되어 있어야 한다.
정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
정사각형 4개를 이어 붙인 폴리오미노는 테트로미노라고 하며, 다음과 같은 5가지가 있다.



아름이는 크기가 N×M인 종이 위에 테트로미노 하나를 놓으려고 한다. 종이는 1×1 크기의 칸으로 나누어져 있으며, 각각의 칸에는 정수가 하나 쓰여 있다.

테트로미노 하나를 적절히 놓아서 테트로미노가 놓인 칸에 쓰여 있는 수들의 합을 최대로 하는 프로그램을 작성하시오.

테트로미노는 반드시 한 정사각형이 정확히 하나의 칸을 포함하도록 놓아야 하며, 회전이나 대칭을 시켜도 된다.

입력
첫째 줄에 종이의 세로 크기 N과 가로 크기 M이 주어진다. (4 ≤ N, M ≤ 500)

둘째 줄부터 N개의 줄에 종이에 쓰여 있는 수가 주어진다. i번째 줄의 j번째 수는 위에서부터 i번째 칸, 왼쪽에서부터 j번째 칸에 쓰여 있는 수이다. 입력으로 주어지는 수는 1,000을 넘지 않는 자연수이다.

출력
첫째 줄에 테트로미노가 놓인 칸에 쓰인 수들의 합의 최댓값을 출력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500 {

    int[][] ways = {{1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}};

    //중앙을 중심으로
    int[][][] special_case = {{{-1,0},{1,0},{0,1}}, /* ├  */
            {{0,-1},{0,1},{1,0}},/* ┬ */
            {{0,-1},{-1,0},{1,0}},/* ┤ */
            {{0,-1},{-1,0},{0,1}}}; /* ┴ */
    boolean[][] visited ;

    public static void main(String[] args) throws IOException {
        BJ_14500 test = new BJ_14500();
    }

    public BJ_14500() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int row = Integer.parseInt(stk.nextToken());
        int col = Integer.parseInt(stk.nextToken());

        int[][] arr = new int[row][col];
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }


        int result = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                result = Math.max(result, solution(arr, i, j));
            }
        }

        System.out.println(result);
    }

    private int solution(int[][] arr, int x, int y) {

//        System.out.println(x + " , " + y + " 로 DFS");

        visited[x][y] = true;
        int result = dfs(arr, x, y, 0, visited);
        visited[x][y] = false;

        for (int[][] ways : special_case){
            int val = arr[x][y] ;
            boolean toggle = false;
            for (int[] way : ways){
                int next_x = x + way[0];
                int next_y = y + way[1];
                if (next_x >= 0 && next_x < arr.length && next_y >= 0 && next_y < arr[0].length){
                    val +=arr[next_x][next_y];
                }else{
                    toggle = true;
                    break;
                }
            }
            //하나라도 안되면 다음 모양으로 전환
            if(toggle)
                continue;

//            System.out.println("특수 케이스 값 : " + val);
            result = Math.max(result,val);
        }





//        System.out.println(result);

        return result;
    }

    private int dfs(int[][] arr, int x, int y, int depths, boolean[][] visited) {

        int res = 0;
        if (depths == 3) {
            return arr[x][y];
        }

        for (int i = 0; i < ways.length; i++) {
            int next_x = x + ways[i][0];
            int next_y = y + ways[i][1];

            if (next_x >= 0 && next_x < arr.length && next_y >= 0 && next_y < arr[0].length) {

                if (!visited[next_x][next_y]) {

                    visited[next_x][next_y] = true;
                    res = Math.max(res, dfs(arr, next_x, next_y, depths + 1, visited));
                    visited[next_x][next_y] = false;
                }

            }

        }

        return arr[x][y] + res;
    }
}
