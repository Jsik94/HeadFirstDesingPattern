package codingTestWithJava.kakao;

/*
    26.22분




 */


import java.util.*;
public class ShuttleBus_kakao {

    public static void main(String[] args) {
        ShuttleBus_kakao test = new ShuttleBus_kakao();

        System.out.println(test.solution(1,1,5,new String[]{"08:00", "08:01", "08:02", "08:03"}));
    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        Queue<Integer> queue = new PriorityQueue<>();

        for(String time : timetable){
            int min =Integer.parseInt(time.substring(0,2))*60+ Integer.parseInt(time.substring(3,5));
            queue.add(min);
        }

//        while(!queue.isEmpty()){
//            System.out.println(queue.poll());
//        }

        //9시 시작
        int start_time = 540;

        while(n-- >0){
            int available = m;
            int last_man =0;
            System.out.println("현재 버스 출발 현재 시간 :"+timeToString(start_time));
            System.out.println("남은 버스 수 :" + n);
            while(available>0 && !queue.isEmpty()){
                if(queue.peek() <= start_time){

                    last_man = queue.poll();
                    available-=1;
                    System.out.println("빠짐!");
                }else{
                    break;
                }
            }
            //while을 탈출하는 경우 1. 버스 인원에 여유가 있음 2. 버스에 여유가 없음 3.시간대에  태울사람이 더이상 없음

            //콘이 들어가는 경우는 언제나 마지막버스임
            if(n==0){

                //여유가있을경우 -> 맨 마지막 버스시간 노리면됨
                if(available>0){
                    answer = timeToString(start_time);
                }else{
                    answer = timeToString(last_man-1);
                }
            }
            start_time += t;



        }


        return answer;
    }

    public String timeToString(int time){
        int hour=(time/60);
        int min = (time%60);
        return String.format("%02d:%02d", hour, min);
    }
}
