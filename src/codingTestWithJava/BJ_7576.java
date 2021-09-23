package codingTestWithJava;

/*
Solved.ac class project

class 3


latency
 */


/*
https://www.acmicpc.net/problem/7576
토마토 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	97165	34247	21453	33.809%
문제
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자 모양 상자의 칸에 하나씩 넣어서 창고에 보관한다.



창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 하나의 토마토의 인접한 곳은 왼쪽, 오른쪽, 앞, 뒤 네 방향에 있는 토마토를 의미한다. 대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다.

토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 단, 2 ≤ M,N ≤ 1,000 이다. 둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다. 하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다.

토마토가 하나 이상 있는 경우만 입력으로 주어진다.

출력
여러분은 토마토가 모두 익을 때까지의 최소 날짜를 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.


sol

bfs를 통해 뻗어나가되
갈 수 없는 조건 -1 혹은 이미 1
종결조건 배열에 0 이 없음 or bfs 가 끝낫는데 0이 남아있음


another
무한으로 돌려놓되, 안되는 경우만 제외할것


안되는 경우
-인접이 모두 -1



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_7576 {

    public static void main(String[] args) throws IOException {
        BJ_7576 test = new BJ_7576();
    }


    public BJ_7576() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        Queue<Integer[]> queue = new LinkedList<>();

        int col = Integer.parseInt(stk.nextToken());
        int row = Integer.parseInt(stk.nextToken());

        int[][] tomatos = new int[row][col];

        for (int i = 0; i < row; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < col; j++) {
                int data =  Integer.parseInt(stk.nextToken());
                tomatos[i][j] =data;
                if(data ==1){
                    queue.add(new Integer[]{i,j});
                }
            }
        }

        System.out.println(solution(tomatos ,queue));
    }


    private void printStatus(int[][] tomatos){
        for (int[] rows : tomatos) {
            for (int atoms : rows) {
                System.out.printf("%3d",atoms);
            }
            System.out.println();
        }
    }

    private int solution(int[][] tomatos, Queue<Integer[]> queue) {

        //이미 채워져있는 배열인지 확인
        if(isComplete(tomatos)){
            return 0;
        }


        //익은 토마토가 하나도 없다면
        if (queue.isEmpty()){
            return -1;
        }


        boolean toggle = false;
        //큐에있는 위치들 중 갈수있는게 하나라도 있다면
        for (Integer[] loc : queue){
            if(isPossible(tomatos,loc[0],loc[1])){
               toggle =true;
                break;
            }
        }

        //익은 토마토가 전이시킬 수 있는 구역이 없는 경우
        if(!toggle){
            return -1;
        }



        int day = 0;
        while (!queue.isEmpty()){
            Queue<Integer[]> temp = new LinkedList<>();
            day++;
            //전이 하면서, 다음 전이 대상들을 임시로 담음
            for (Integer[] loc : queue){
                doInfection(tomatos,loc[0],loc[1],temp);
            }
            // 전이 대상들을 큐로 이동
            queue = temp;

            //다채워졌는지 확인
            if (isComplete(tomatos)){
                break;
            }
        }

        //익은 토마토가 모두 전이시켜도 0이 남은경우
        if(!isComplete(tomatos)){
            return -1;
        }

        return day;

    }

    //전체 배열이 모두 전염되었는지 확인
    boolean isComplete(int[][] tomatos) {
        boolean toggle = true;
        Map<String,Integer> test =new HashMap<>();

        for (int[] rows : tomatos) {
            for (int atoms : rows) {
                if (atoms == 0) {
                    toggle = false;
                    break;
                }
            }
            if (!toggle) {
                break;
            }
        }
        return toggle;
    }


    //자기 주변 4방향 전이
    void doInfection(int[][] tomatos,int row,int col, Queue<Integer[]> queue){

        if (row - 1 >= 0) {
            if (tomatos[row - 1][col] == 0) {
                tomatos[row - 1][col] =1;
                queue.add(new Integer[]{row-1,col});
            }
        }
        if (col - 1 >= 0 ) {

            if (tomatos[row][col-1] ==0) {
                tomatos[row][col-1] =1;
                queue.add(new Integer[]{row,col-1});
            }
        }
        if (row + 1 < tomatos.length) {

            if (tomatos[row + 1][col] ==0) {
                tomatos[row + 1][col] =1;
                queue.add(new Integer[]{row+1,col});
            }
        }
        if (col + 1 < tomatos[row].length) {

            if (tomatos[row][col+1] ==0) {
                tomatos[row][col+1] =1;
                queue.add(new Integer[]{row,col+1});
            }

        }

    }




    //해당 ij배열에서 움직일수 있는지 홖인
    boolean isPossible(int[][] tomatos, int i, int j) {

        boolean possible = false;

        if (i - 1 >= 0) {
            if (tomatos[i - 1][j] != -1) {
                return true;
            }
        }

        if (j - 1 >= 0 ) {
            if (tomatos[i][j-1] != -1) {
                return true;
            }
        }

        if (i + 1 < tomatos.length) {
            if (tomatos[i + 1][j] != -1) {
                return true;
            }
        }

        if (j + 1 < tomatos[i].length) {
            if (tomatos[i][j+1] != -1) {
                return  true;
            }
        }

        return possible;
    }


}
