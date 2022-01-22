package codingTestWithJava.kakao;

public class TaxiCaple_kakao {

    //각자 이동하는 경우 합 > 같이 갔다가 따로 가는 값의 합


    //1] 각자 이동경우는 아래의합
    //A가 집에 가장빨리가는 법 ->다익스트라
    //B가 집에 가장빨리가는 법 ->다익스트라

    //2] 같이 갔다가 따로가는 합
    // 같이 가는 경로 -> 시작부터 다익
    // A가 거기서 부터 최단 -> 다익
    // B가 거기서 부터 최단  -> 다익

    //ex
    //1] 66 + 50 = 116
    //2] 34 + 2 + 46 = 82

    /*
        4번 116
        1번 63 + 25  + 10 98
        5번 46 + 2   + 34 82
        2번 0  + 48  + 66 114
        3번 22 + 26  + 51 99
        6번 48 + 0   + 50 98
     */

    int[][] maps;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        maps = new int[n][n];

//        for (int i = 0; i < maps.length ; i++){
//            Arrays.fill(maps[i],Integer.MAX_VALUE);
//        }

        for(int[] rows : fares){
            int x = rows[0]-1;
            int y = rows[1]-1;
            int cost = rows[2];
            maps[x][y] =cost;
            maps[y][x] =cost;
        }

        System.out.println(s+"번에서 갈수 있는 모든 최단 경로");
//        dijkstra(s,n);
        int[] dist = dijkstra(s-1,n);
        int defaultcost = dist[a-1]+dist[b-1];
        System.out.println(defaultcost);



        for(int i = 0 ; i < n ;i++){
            if( i ==s-1) continue;
            int moved_cost =dist[i];
            if(moved_cost == Integer.MAX_VALUE) continue;
            int[] dist_area = dijkstra(i,n);
            int home_cost = dist_area[a-1]+dist_area[b-1];
            System.out.println(i+"까지 이동한 뒤 총 계산하면 :" + (home_cost+moved_cost));
            answer = Math.min(answer,(home_cost+moved_cost));
        }


        return Math.min(answer,defaultcost);
    }


    public int[] dijkstra(int v,int n) {
        int distance[] = new int[n];          //최단 거리를 저장할 변수
        boolean[] check = new boolean[n];     //해당 노드를 방문했는지 체크할 변수

        //distance값 초기화.
        for (int i = 0; i < n ; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //시작노드값 초기화.
        distance[v] = 0;
        check[v] = true;

        //연결노드 distance갱신
        for (int i = 0; i < n ; i++) {
            if (!check[i] && maps[v][i] != 0) {
                distance[i] = maps[v][i];
            }
        }


        for (int a = 0; a < n - 1; a++) {
            //원래는 모든 노드가 true될때까지 인데
            //노드가 n개 있을 때 다익스트라를 위해서 반복수는 n-1번이면 된다.
            //원하지 않으면 각각의 노드가 모두 true인지 확인하는 식으로 구현해도 된다.
            int min = Integer.MAX_VALUE;
            int min_index = -1;

            //최소값 찾기
            for (int i = 0; i < n; i++) {
                if (!check[i] && distance[i] != Integer.MAX_VALUE) {
                    if (distance[i] < min) {
                        min = distance[i];
                        min_index = i;
                    }
                }
            }

            if(min_index ==-1) continue;

            check[min_index] = true;
            for (int i = 0; i < n ; i++) {
                if (!check[i] && maps[min_index][i] != 0) {
                    if (distance[i] > distance[min_index] + maps[min_index][i]) {
                        distance[i] = distance[min_index] + maps[min_index][i];
                    }
                }
            }

        }

        //결과값 출력

//        distance[v] = Integer.MAX_VALUE;
//        int min = distance[v];
//        int min_idx = 0;
//        for (int i = 1; i < n + 1; i++) {
////            if (min > distance[i]) {
////                min = distance[i];
////                min_idx = i;
////            }
//            System.out.print(distance[i] + " ");
//        }

//        System.out.println("");

//        return new Data(min, min_idx);
        return distance;
    }

    public static void main(String[] args) {
        int n,s,a,b;
        int[][] fare;
        n =6;
        s =4;
        a =6;
        b =2;
        fare= new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
//        n =7;
//        s =3;
//        a =4;
//        b =1;
//        fare= new int[][]{{5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};
        TaxiCaple_kakao test = new TaxiCaple_kakao();
        ;
        System.out.println(test.solution(n,s,a,b,fare));
    }
}


class Data{
    int cost;
    int node;

    public Data(int cost, int node) {
        this.cost = cost;
        this.node = node;
    }
}
