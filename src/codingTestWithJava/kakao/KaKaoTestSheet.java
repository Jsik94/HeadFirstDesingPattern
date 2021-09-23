package codingTestWithJava.kakao;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KaKaoTestSheet {

    public static void main(String[] args) {
        KaKaoTestSheet test =new KaKaoTestSheet();
    }

    public KaKaoTestSheet() {
        //1 - solution(new String[]{"muzi", "frodo", "apeach", "neo"},new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"},2);

        System.out.println(solution(437674,3));


        //3 - solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});

        //4 - solution(5,new int[]{2,1,1,1,0,0,0,0,0,0,0});

        //5 -solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1},new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});

//        int result = solution(new int[][]{{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}},new int[][]{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}});
//        System.out.println(result);

    }

    //6
//    public int solution(int[][] board, int[][] skill) {
//        int answer = 0;
//        try {
//        Long.par
//        }catch (Exception e){
//                e.printStackTrace();
//        }
//        for (int row = 0 ;row < board.length ;row++){
//            for (int col = 0 ; col<board[row].length; col++){
//                for (int[] action : skill){
//                    board[row][col] += isIncldue(row,col,action);
//                }
//                if(board[row][col]>0){
//                    answer+=1;
//                }
//            }
//        }
//
//        return answer;
//    }
//
//    int isIncldue(int row,int col, int[] skill){
//
//
//        if( row >= skill[1]&& row<=skill[3]&& col>=skill[2] && col<=skill[4]){
//            return (skill[0] ==1)? -1 * skill[5] : skill[5];
//        }
//        return 0;
//    }


//5
//    public int solution(int[] info, int[][] edges) {
//        int sheep_cnt=0;
//        int wolf_cnt=0;
//        ArrayList <Integer> sheep_node = new ArrayList<>();
//        ArrayList <Integer> wolf_node = new ArrayList<>();
//        Map<Integer,ArrayList<Integer>> node_way = new HashMap<>();
//        for(int i = 0 ; i < info.length ;i++){
//            if(info[i]==0){
//                sheep_cnt+=1;
//                sheep_node.add(i);
//            }else{
//                wolf_cnt+=1;
//                wolf_node.add(i);
//            }
//        }
//
//        for (int[] edge : edges){
//            if(node_way.getOrDefault(edge[0],null)==null){
//                node_way.put(edge[0],new ArrayList<>());
//            }
//            node_way.get(edge[0]).add(edge[1]);
//
//            if(node_way.getOrDefault(edge[1],null)==null){
//                node_way.put(edge[1],new ArrayList<>());
//            }
//            node_way.get(edge[1]).add(edge[0]);
//
//        }
//        boolean[] visit = new boolean[info.length];
//        int result = dfs_wolfs(0,5,node_way,info,visit,0);
//
//        System.out.println(result);
//
//
//
//        int answer = 0;
//        return answer;
//    }
//
//    void dfs_wolfs(int cur,int target,Map<Integer,ArrayList<Integer>> node_way,int[] info,boolean[] visit,int wolf){
//
//        if( cur == target){
//            return -999;
//        }
//
//        visit[cur] = true;
//        for (int next_way : node_way.get(cur)){
//            if(!visit[next_way]){
//                wolf += (info[next_way]==1) ? 1:0;
//                int code = dfs_wolfs(next_way,target,node_way,info,visit,wolf);
//                if(code ==-999){
//                    return wolf;
//                }
//                wolf -= (info[next_way]==1) ? 1:0;
//            }
//        }
//
//        return 0;
//    }
//
//
//
//    public class Pair<L,R>{
//        private L left;
//        private R right;
//        public Pair(L left, R right){
//            this.left = left;
//            this.right = right;
//        }
//
//        public Pair() {
//
//        }
//
//
//        public L getLeft() {
//            return left;
//        }
//
//        public R getRight() {
//            return right;
//        }
//
//        public void setLeft(L left) {
//            this.left = left;
//        }
//
//        public void setRight(R right) {
//            this.right = right;
//        }
//    }
//
//



    //4
//    public int[] solution(int n, int[] info) {
//
//        int[] answer = new int[10];
//        ArrayList<Integer[]> totalScore = new ArrayList<>();
//        int appeach_score=0;
//        int lion_score=0;
//
//        for(int i = 0 ; i < info.length ;i++){
//
//            //이미 해당 점수를 가지고있다면 피료없응
//            if(!totalScore.contains(info[i])) {
//                //라이언이 어피치를 이기기위해 써야하는화살 갯수
//                int condition = info[i]+1;
//                ArrayList<Integer[]> tempScore = new ArrayList<>();
//                //화살이 충분하다면
//                if(n >= condition){
//
//                    int k = i+1;
//                    while (condition>0){
//                        //가져갈 수 있는 것들을 봄
//                        if(info[k]< condition){
//                            condition -= (info[k]+1);
//                            tempScore.add(new Integer[]{k,info[k]+1});
//                        }
//                        k++;
//                    }
//                    //여기까지왔을때 condition 만큼 다른데 쓴것임
//
//                    int instead_score =0;
//                    for (Integer[] score : tempScore){
//                        instead_score +=(10-score[0]);
//                    }
//
//                    //대체 점수가 크다면
//                    if(10-i < instead_score){
//                        n -=(info[i]+1);
//
//                    }else{
//                        //현재 점수가 크다면
//                        //idx 초기화
//                        tempScore = new ArrayList<>();
//                        tempScore.add(new Integer[]{i,info[i]+1});
//
//
//                        //투자한 화살 뺌
//                        n-=(info[i]+1);
//                    }
//
//                    for (Integer[] score : tempScore){
//                        totalScore.add(score.clone());
//                    }
//
//                }
//            }
//
//        }
//
//
//
//
//
//
//        return answer;
//    }



//3
//    public int[] solution(int[] fees, String[] records) {
//
//        Map<String,ArrayList<Integer>> card_fee = new HashMap<>();
//
//        //차량을 기준으로 hash map
//        //해당 차량이 들어왔는지 안왔는지 확인할 toggle하나
//
//        for (String record : records){
//            Matcher mt = Pattern.compile("([0-9]+):([0-9]+)\\s([0-9]{4})\\s(.+)").matcher(record);
//
//            if(mt.matches()){
//                int hour = Integer.parseInt(mt.group(1))*60;
//                int min = Integer.parseInt(mt.group(2));
//                int total_time = hour+min;
//
//                String carNum = mt.group(3);
//
//                if(card_fee.getOrDefault(carNum,null)==null){
//                    card_fee.put(carNum,new ArrayList<>());
//                }
//                card_fee.get(carNum).add(total_time);
//            }
//
//        }
//
//        List<String> keys = new ArrayList<>(card_fee.keySet());
//        Collections.sort(keys);
//
//        int[] answer = new int[card_fee.size()];
//        int i = 0;
//        for (String key : keys){
//
//            ArrayList<Integer> datas = card_fee.get(key);
//            int op = -1;
//            int total_time=0;
//            int result = 0;
//            boolean inOrOut =true;
//
//            //짝수가아니라면 한번 안나간거임
//            if(datas.size()%2 !=0){
//                //23:59분 마지막에 더해주기
//                datas.add(23*60+59);
//            }
//
//            for(int data :datas){
//                inOrOut = !inOrOut;
//                total_time += op * data;
//                op*=-1;
//            }
//
//
//                //기본시간보다 작다면
//                if(total_time <= fees[0]){
//                    result= fees[1];
//                }else{
//                    total_time-= fees[0];
//                    int over_time_result = total_time/ fees[2];
//                    if(total_time % fees[2]!=0){
//                        over_time_result +=1;
//                    }
//                    result = over_time_result*fees[3]+fees[1];
//                }
//                answer[i] +=result;
//                //시간초기화
//                total_time= 0;
//
//
//
//
//            i++;
//        }
//
//
//
//        return answer;
//    }




    public int solution(int n, int k) {
        int answer = 0;
        ArrayList<Long> prime = new ArrayList<>();
        prime.add(Long.valueOf(2));
        String data = changer(n,k);

        try{
            StringTokenizer stk = new StringTokenizer(data,"0");
            while(stk.hasMoreTokens()){
                String value = stk.nextToken();
                if(isPrime(Long.parseLong(value),prime)){
                    answer+=1;
                }
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        return answer;
    }


    public boolean isPrime(Long num , ArrayList<Long> prime){
        if(num==1){
            return false;
        }

        for(int i=2; i<=num; i++){
            for (int j = 0; prime.size() > j; j++) {

                if (i % prime.get(j) == 0){
                    break;
                }

                if (j + 1 == prime.size()){

                    prime.add(Long.valueOf(i));
                }

            }

        }
        if(prime.contains(num)){
            return true;
        }
        return false;
    }



    //n진수 변환
    public String changer(int value,int k) {
        StringBuilder sb = new StringBuilder();
        while (value >= 1) {
            sb.insert(0, value % k);
            value /= k;
        }
        return sb.toString();
    }


//    public int[] solution(String[] id_list, String[] report, int k) {
//
//        Map<String,Integer> info = new HashMap<>();
//        Map<String,Boolean[]> ban_card = new HashMap<>();
//        ArrayList<String> indexor =new ArrayList<>();
//        Boolean[] ban = new Boolean[id_list.length];
//        StringTokenizer stk ;
//
//
//        //각유저는 한번씩 밖에 동일 대상 신고할 수 밖에없음
//
//        for (int i = 0 ; i < id_list.length;i++ ){
//            indexor.add(id_list[i]);
//            info.put(id_list[i],0);
//            ban_card.put(id_list[i],new Boolean[id_list.length] );
//            Arrays.fill(ban_card.get(id_list[i]),false);
//        }
//
//        for (int i = 0 ; i < report.length ; i++){
//
//            stk = new StringTokenizer(report[i]," ");
//
//            //신고자 - 신고대상 이나옴
//            while (stk.hasMoreTokens()){
//                String reporter = stk.nextToken();
//                String reported = stk.nextToken();
//                int reporter_idx = indexor.indexOf(reporter);
//                int ban_num = indexor.indexOf(reported);
//                //해당 인원이 처음 신고를 했을 때만 1
//                if(!ban_card.get(id_list[reporter_idx])[ban_num]){
//                    ban_card.get(id_list[reporter_idx])[ban_num] =true;
//                    info.put(reported,info.get(reported)+1);
//
//                }
//
//            }
//
//        }
//
//
//        int[] answer = new int[id_list.length];
//
//        for(Map.Entry<String,Integer> entry : info.entrySet()){
//            int cnt = 0;
//            //자신이 쓴 밴카드의 대상이 횟수가 k 개 이상이면 밴성공
//
//            for(int i = 0 ; i < id_list.length ;i++){
//                if(ban_card.get(entry.getKey())[i]){
//                    if(info.get(indexor.get(i)) >= k){
//                        cnt++;
//                    }
//                }
//            }
//            answer[indexor.indexOf(entry.getKey())] = cnt;
//
//
//
//        }
//
//
//
//        return answer;
//    }

//    void solution(){
//
//    }
//
//    void solution(){
//
//    }
//




}
