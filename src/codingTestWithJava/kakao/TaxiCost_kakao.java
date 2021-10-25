package codingTestWithJava.kakao;

/*
https://programmers.co.kr/learn/courses/30/lessons/72413


 */

//두 간선은 양방향이나 요금은 단방향만 지원함 ( 즉 값이 없다면 계산해야됨)

import java.util.Arrays;

public class TaxiCost_kakao {
    public static void main(String[] args) {
        TaxiCost_kakao test = new TaxiCost_kakao();
    }

    public TaxiCost_kakao() {
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10},
                {3, 5, 24},
                {5, 6, 2},
                {3, 1, 41},
                {5, 1, 24},
                {4, 6, 50},
                {2, 4, 66},
                {2, 3, 22},
                {1, 6, 25}};


        solution(n, s, a, b, fares);
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] arr = new int[n][n];
        for (int i = 0 ; i < arr.length ; i++){
            Arrays.fill(arr[i],Integer.MAX_VALUE);
        }
        for (int i = 0 ; i < arr.length ; i++){
            for (int j = 0 ; j <arr.length ; j++){
                if(i==j){
                    arr[i][j] =0;
                }
            }
        }


        //우선적으로 양방향 부터 정리 해야됨
        for (int i = 0; i < fares.length; i++) {
            int row;
            int col;
            int val;


            row = fares[i][0] - 1;
            col = fares[i][1] - 1;
            val = fares[i][2];
            arr[row][col] = val;
            arr[col][row] = val;

        }


        int target = 0;
        //start에서 a,b를 제외하고 특정 지점으로 가는경우
        for (int i = 0; i < arr.length; i++) {

            //시작점 or (종단점은 제외 - || i == (a-1) || i ==(b-1))
            if (i == (s - 1)) {
                continue;
            }
            target = i;

            System.out.println(s + " 에서 " + (i+1) + " 까지의 최단 거리 : " + dfs(arr, s-1, i));

        }


        //해당 지점에서 a,b 까지의 최단 거리

        //특정 지점 값 + a+b까지의 거리


        return answer;
    }

    private int dfs(int[][] arr, int current, int target) {
        int result = 0;

        if (current == target) {
            return 0;
        }
        int[][] dist = new int[arr.length][arr.length];


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                dist[i][j] = arr[i][j];
            }
        }

        for (int via = 0; via < arr.length; via++) {
            for (int start = 0; start < arr.length; start++) {
                for (int end = 0; end < arr.length; end++) {

                    dist[start][end] = Math.min(dist[start][end], dist[start][via] + dist[start][via]);

                }
            }
        }


        return arr[current][target];
    }


}
