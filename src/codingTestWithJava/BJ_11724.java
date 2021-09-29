package codingTestWithJava;

/*
Solved.ac class project

class 3


latency
 */
/*
https://www.acmicpc.net/problem/11724
연결 요소의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	512 MB	51183	24199	15798	44.255%
문제
방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정점의 개수 N과 간선의 개수 M이 주어진다. (1 ≤ N ≤ 1,000, 0 ≤ M ≤ N×(N-1)/2) 둘째 줄부터 M개의 줄에 간선의 양 끝점 u와 v가 주어진다. (1 ≤ u, v ≤ N, u ≠ v) 같은 간선은 한 번만 주어진다.

출력
첫째 줄에 연결 요소의 개수를 출력한다.

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_11724 {
    HashMap<Integer, ArrayList<Integer>> map;
    boolean[] visit ;

    public static void main(String[] args) throws IOException {
        BJ_11724 test = new BJ_11724();
    }

    public BJ_11724() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int node = Integer.parseInt(stk.nextToken());
        int relation = Integer.parseInt(stk.nextToken());
        map = new HashMap<>();
        visit = new boolean[node+1];

        for (int i = 0; i < relation; i++) {
            stk= new StringTokenizer(br.readLine()," ");
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            if(!map.containsKey(x)){
                map.put(x, new ArrayList<>());
            }
            map.get(x).add(y);
            if(!map.containsKey(y)){
                map.put(y, new ArrayList<>());
            }
            map.get(y).add(x);

        }
        System.out.println(solution(node));
    }


    private int solution(int node) {
        int way = 0;

        //모든 방문을 검색
        for (int start = 1 ; start <= node ; start++){
            //방문하지 않았다면
            if(!visit[start]){
                //dfs
                dfs(start);
                way+=1;
            }
        }

        return way;
    }

    private void dfs(int start){
        visit[start] = true;
        if(map.containsKey(start)){
            for (int ways: map.get(start)){
                if(!visit[ways]){
                    dfs(ways);
                }
            }
        }
    }
}
