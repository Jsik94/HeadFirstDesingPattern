package codingTestWithJava;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_11657 {

    public static void main(String[] args) throws IOException {
        BJ_11657 test = new BJ_11657();
    }

    public BJ_11657() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int vertex = Integer.parseInt(stk.nextToken());
        int cnt = Integer.parseInt(stk.nextToken());
        long[] dist = new long[vertex+1];

        List<Vertax> lists = new ArrayList<>();

        for (int i = 0 ; i <cnt; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(stk.nextToken());
            int end = Integer.parseInt(stk.nextToken());
            int weight = Integer.parseInt(stk.nextToken());
            lists.add(new Vertax(start,end,weight));
        }


        Arrays.fill(dist,Integer.MAX_VALUE);

        boolean toggle =false;
        dist[1] = 0;
        for (int i = 1 ; i < vertex+1 ; i++){
            for (int j = 0 ; j< lists.size();j++){

                // 갈수 있는 곳중  start 노드에서 가중치값을 더한게 작다면 변경
                if(dist[lists.get(j).start] != Integer.MAX_VALUE  && dist[lists.get(j).end] > dist[lists.get(j).start]+ lists.get(j).weight){
                    dist[lists.get(j).end] = dist[lists.get(j).start]+ lists.get(j).weight;

                    if(i ==vertex){
                        toggle = true;
                    }
                }
            }
        }

        if(toggle){
            System.out.println("-1");
        }else{
            for (int i = 2 ; i <= vertex ; i++){
                if(dist[i]==Integer.MAX_VALUE){
                    sb.append("-1").append("\n");
                }else{
                    sb.append(dist[i]).append("\n");
                }
            }

            System.out.println(sb);
        }


    }


    public class Vertax{
        int start;
        int end;
        int weight;

        public Vertax(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
}
