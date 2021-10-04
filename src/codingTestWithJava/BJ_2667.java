package codingTestWithJava;
/*
Solved.ac class project

class 3

latency
 */

/*
https://www.acmicpc.net/problem/2667
단지번호붙이기 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	94776	39486	24889	39.686%
문제
<그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다. 철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다. 여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다. 대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다. 지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.



입력
첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.

출력
첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2667 {

    public static void main(String[] args) throws IOException {
        BJ_2667 test = new BJ_2667();
    }

    public BJ_2667() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int len = Integer.parseInt(br.readLine());

        int[][] table = new int[len][len];
        for (int i = 0; i < len; i++) {
            int r = 0;
            for (char a : br.readLine().toCharArray()){
                table[i][r++]= a-48;
            }

        }

        List<Integer> results = new ArrayList<>();


        solution(table,results);
        Collections.sort(results);

        System.out.println(results.size());
        for (int result : results){
            sb.append(result+"\n");
        }
        System.out.println(sb);

    }

    private void solution(int[][] table, List<Integer> results) {

        int[][] ways = {{-1, 0},
                {1, 0},
                {0, 1},
                {0, -1}};

        for (int i = 0 ; i < table.length ; i++){
            for (int j = 0 ; j < table[i].length ; j++){
                if(table[i][j]==0){
                    continue;
                }else{
                    Queue<Pair> que = new LinkedList<>();
                    que.add(new Pair(i,j));
                    int cnt = 0;
                    while (!que.isEmpty()){
                        Pair cur = que.poll();

                        if(table[cur.left][cur.right] ==0){
                            continue;
                        }
                        table[cur.left][cur.right] = 0;
                        cnt++;
                        for (int k = 0 ; k < ways.length ;k++){
                            Pair next = new Pair(cur.left+ways[k][0], cur.right+ways[k][1]);
                            if(isNext(next,table)){
                                que.add(next);
                            }
                        }

                    }

                    results.add(cnt);

                }


            }
        }
    }


    private boolean isNext(Pair one,int[][] table){

        if( one.left>= 0&&one.left< table.length&&one.right>= 0&&one.right< table.length ){
            if (table[one.left][one.right]!=0){
                return true;
            }
        }
        return false;
    }


    class Pair{
        Integer left;
        Integer right;

        public Pair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }
}
