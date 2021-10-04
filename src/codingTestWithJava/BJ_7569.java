package codingTestWithJava;

/*
Solved.ac class project

class 3

latency
 */

/*
https://www.acmicpc.net/problem/7569
토마토 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	38362	15037	11009	40.610%
문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.



창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다. 각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_7569 {

    public static void main(String[] args) throws IOException {
        BJ_7569 test = new BJ_7569();
    }

    public BJ_7569() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        Queue<Demension> lst = new LinkedList<>();
        int col = Integer.parseInt(stk.nextToken());
        int row = Integer.parseInt(stk.nextToken());
        int height = Integer.parseInt(stk.nextToken());

        int[][][] arr = new int[height][row][col];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < row; j++) {
                stk = new StringTokenizer(br.readLine()," ");
                for (int k = 0; k < col; k++) {
                    arr[i][j][k] = Integer.parseInt(stk.nextToken());
                    if(arr[i][j][k] ==1){
                        lst.add(new Demension(i,j,k));
                    }
                }
            }
        }

        int result = solution(arr,lst);
        System.out.println(result);

    }

    private int solution(int[][][] arr,Queue<Demension> lst ) {

        int day = 0;
        while (!lst.isEmpty()){

            lst = new LinkedList<>(infection(lst,arr));
            day++;

        }

        if (isClear(arr)){
            return day-1;
        }
        return -1;


    }


    //전채가 다 감염되었는지 확인
    private boolean isClear(int[][][] arr){

        for (int[][] square : arr){
            for(int[] line : square){
                for (int atom : line){
                    if(atom == 0){
                        return false;
                    }

                }
            }
        }

        return true;
    }

    //하루가 지날때마다 주변 점염
    private Queue<Demension> infection(Queue<Demension> lst,int[][][] arr){

        Queue<Demension> copied = new LinkedList<>();
        while (!lst.isEmpty()){
            Demension cur = lst.poll();


            int[][] ways = {{1,0,0},
                    {-1,0,0},
                    {0,1,0},
                    {0,-1,0},
                    {0,0,1},
                    {0,0,-1}};

            for (int i = 0 ; i < ways.length ; i++){

                int next_x = cur.x + ways[i][0];
                int next_y = cur.y + ways[i][1];
                int next_z = cur.z + ways[i][2];

                //범위 안에있을 때만
                if (next_x>= 0 && next_x < arr.length && next_y>= 0 && next_y < arr[0].length && next_z >=0 && next_z< arr[0][0].length){
                    if( arr[next_x][next_y][next_z] == 0){
                        copied.add(new Demension(next_x,next_y,next_z));
                        arr[next_x][next_y][next_z] = 1;

                    }
                }
            }



        }
        return copied;
    }


    class Demension{
        Integer x;
        Integer y;
        Integer z;

        public Demension(Integer x, Integer y, Integer z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

}
