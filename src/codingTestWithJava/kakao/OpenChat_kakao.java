package codingTestWithJava.kakao;


import java.util.*;

public class OpenChat_kakao {

    public static void main(String[] args) {
        OpenChat_kakao test = new OpenChat_kakao();
    }

    public OpenChat_kakao() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        String[] answers = solution(record);

        for (String answer : answers){
            System.out.println(answer);
        }
    }

    public String[] solution(String[] record) {
        HashMap<String, String> uidToName = new HashMap<>();
        Queue<String[]> out_put_queue = new LinkedList<>();
        StringTokenizer stk;
        int out_num = 0;

        for (String line : record) {
            stk = new StringTokenizer(line, " ");
            String command = stk.nextToken();
            if (command.equals("Enter") ){
                String key,value;
                key =stk.nextToken();
                value =stk.nextToken();
                if (uidToName.getOrDefault(line, "-1").equals("-1")) {
                    uidToName.put(key,value);
                }
//                out_num+=1;
                out_put_queue.add(new String[]{key,command});

            } else if(command.equals("Change")){
                String key,value;
                key =stk.nextToken();
                value =stk.nextToken();
//                if (uidToName.getOrDefault(line, "-1").equals("-1")) {
//                    uidToName.put(key, value);
//                }else{
//                    uidToName.put(key, value);
//                }
                uidToName.put(key, value);

            }else{
                //leave
                String key = stk.nextToken();
//                out_num+=1;
                out_put_queue.add(new String[]{key,command});
            }
        }





        String[] answer = new String[out_put_queue.size()];
        for (int i = 0 ; i < answer.length ; i++){

            String[] uidNcommand = out_put_queue.poll();
            answer[i] = uidToName.get(uidNcommand[0])+toChangeKor(uidNcommand[1]);

        }

        return answer;
    }

    private String toChangeKor(String command){
        String result ;
        if(command.equals("Enter")){
            result = "님이 들어왔습니다.";
        }else{
            result = "님이 나갔습니다.";
        }

        return result;
    }

}
