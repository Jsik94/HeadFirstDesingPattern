//package codingTestWithJava;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//public class BJ_2610 {
//
//    public static void main(String[] args) throws IOException {
//        BJ_2610 test = new BJ_2610();
//    }
//
//    public BJ_2610() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stk;
//        StringBuffer sb = new StringBuffer();
//        int person =Integer.parseInt(br.readLine());
//
//        int cnt = Integer.parseInt(br.readLine());
//
//        int[][] field = new int[person][person];
//        for (int i = 0 ; i < person ; i++){
//
//            Arrays.fill(field[i],Integer.MAX_VALUE);
//        }
//
//
//        for(int i = 0 ; i < cnt ; i++){
//            stk = new StringTokenizer(br.readLine()," ");
//
//            int a = Integer.parseInt(stk.nextToken())-1;
//            int b = Integer.parseInt(stk.nextToken())-1;
//
//            field[a][b] = 1;
//            field[b][a] = 1;
//        }
//
//
//        int[] result = solution(field,person);
//        for (int atom : result){
//            sb.append(atom+"\n");
//        }
//
//        System.out.println(sb);
//    }
//
//    private int[] solution(int[][] field, int person) {
//        int com_cnt = 0;
//        int list_cnt= -1 ;
//        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
//        boolean[] visit = new boolean[person];
//        for (int i = 0 ; i < person ;i++ ){
//            if(visit[i]) continue;
//
//            list.add(new ArrayList<>());
//            list_cnt+=1;
//            com_cnt+=1;
//            Queue<Integer> queue = new LinkedList<>();
//            visit[i] = true;
//            queue.add(i);
//            list.get(list_cnt).add(i);
//            while (!queue.isEmpty()){
//
//                int num = queue.poll();
//
//                for (int j = 0 ; j < person ; j++){
//
//                    if(!visit[j]& field[num][j] ==1){
//                        visit[j] = true;
//                        queue.add(j);
//                        list.get(list_cnt).add(j);
//                    }
//                }
//            }
//
//        }
//
//       // System.out.println("위원회 수부터 : " + com_cnt);
//        int[] result = new int[com_cnt+1];
//        result[0] = com_cnt;
//        int idx = 1;
//        int weight =0;
//        for (ArrayList com : list){
//            result[idx++] = floyid(com,field,weight)+1;
//            weight+= com.size();
//
//        }
//
//
//
//        return result;
//    }
//
//    private int floyid(ArrayList<Integer> com, int[][] field,int weight) {
//
//        int[][] arr = new int[com.size()][com.size()];
//        if( i==j){
//
//        for (int i = 0 ; i < com.size();i++){
//            for (int j = 0 ; j < com.size();j++){
//                        arr[i][j] =0;
//                    }else{
//
//                        arr[i][j] = field[com.get(i)][com.get(j)];
//                    }
//
//            }
//        }
//
//        for (int k = 0; k < arr.length; k++) {
//            for (int i = 0; i < arr.length; i++) {
//                for (int j = 0; j < arr.length; j++) {
//
//                    if(arr[i][k] == Integer.MAX_VALUE || arr[k][j] ==Integer.MAX_VALUE) continue;
//                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
//                        arr[i][j] = arr[i][k] + arr[k][j];
//                    }
//                }
//            }
//        }
//
//        int best_line =0;
//
//        int eval = Integer.MAX_VALUE;
//        for (int i = 0 ; i < arr.length ;i++){
//
//            int total = 0;
//            for (int line : arr[i]){
//                total = Math.max(total,line);
//            }
//            if(eval > total){
//                eval = total;
//                best_line=  i;
//            }
//        }
//
//
//       // System.out.println("가장 효율적인 대표 : " + best_line+weight);
//
//
//        return best_line+weight ;
//    }
//
//
//}
