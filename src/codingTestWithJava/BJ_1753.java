package codingTestWithJava;



/*
https://www.acmicpc.net/problem/1753

최단경로
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	106587	29505	14343	23.747%
문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다. 둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다. 이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다. 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.






 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1753 {

    public static void main(String[] args) throws IOException {
        BJ_1753 test = new BJ_1753();
    }

    public BJ_1753() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int V, E;

        V = Integer.parseInt(stk.nextToken());
        E = Integer.parseInt(stk.nextToken());
        int[] dist = new int[V + 1];
        boolean[] visit = new boolean[V + 1];
        int start = Integer.parseInt(br.readLine());
        Arrays.fill(dist, Integer.MAX_VALUE);


        List<Info> datas[] = new List[V + 1];
        for (int i = 0 ; i <= V; i++){
            datas[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(stk.nextToken());
            int c = Integer.parseInt(stk.nextToken());
            int w = Integer.parseInt(stk.nextToken());

            datas[r].add(new Info(c, w));

        }


        solution(datas, start, dist, visit);
        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF");
            } else {
                sb.append(dist[i]);
            }

            if (i != V) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }


    public void solution(List<Info>[] way, int start, int[] dist, boolean[] visit) {

        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.weight-o2.weight);
        pq.offer(new Info(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (!visit[cur.vertex]) {
                visit[cur.vertex] = true;

                for (Info next : way[cur.vertex]) {

                    if (dist[next.vertex] == Integer.MAX_VALUE || dist[next.vertex] > dist[cur.vertex] +next.weight) {
                        dist[next.vertex] = dist[cur.vertex] + next.weight;
                        pq.offer(new Info(next.vertex,dist[next.vertex]));
                    }


                }

            }


        }
    }

    class Info {

        int vertex;
        int weight;


        public Info(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }


    }

}
