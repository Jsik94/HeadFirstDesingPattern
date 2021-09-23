package codingTestWithJava;

/*
Solved.ac class project

class 3


 */
/*
https://www.acmicpc.net/problem/1260
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1260 {

    public static void main(String[] args) throws IOException {

        BJ_1260 test = new BJ_1260();
    }

    public BJ_1260() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(stk.nextToken());
        int M = Integer.parseInt(stk.nextToken());
        int V = Integer.parseInt(stk.nextToken());

        ArrayList<Integer>[] info = new ArrayList[N];
        for(int i = 0 ; i < info.length;i++){
            info[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(stk.nextToken())-1;
            int y = Integer.parseInt(stk.nextToken())-1;

            info[x].add(y);
            info[y].add(x);

        }

        for(int i = 0 ; i < info.length;i++){
            Collections.sort(info[i]);
        }

        solution(N,V,info);


    }

    void solution(int N, int V,  ArrayList<Integer>[] info) {
        StringBuilder sb = new StringBuilder();

        boolean[] visit = new boolean[N];
        dfs(V,visit,info);
        bfs(V,visit,info);

    }


    void dfs(int start ,boolean[] visit ,  ArrayList<Integer>[] info){

        Stack<Integer> stack =new Stack<>();
        StringBuilder sb =new StringBuilder();

        stack.push(start-1);

        while(!stack.isEmpty()){
            int cur = stack.pop();
            if(!visit[cur]){
                visit[cur] = true;
                sb.append((cur+1)+" ");


                for(int next =info[cur].size()-1 ; next >=0 ; next--){
                    if(!visit[info[cur].get(next)]){
                        stack.push(info[cur].get(next));
                    }

                }

            }

        }
        System.out.println(sb);

    }

    void bfs(int start, boolean[]visit, ArrayList<Integer>[] info){

        visit = new boolean[visit.length];
        StringBuilder sb =new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

       queue.add(start-1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(!visit[cur]){
                visit[cur] = true;
                sb.append((cur+1)+" ");
                for(Integer next : info[cur]){
                    if(!visit[next]){
                        queue.add(next);
                    }

                }

            }

        }
        System.out.println(sb);
    }



}
