package codingTestWithJava;
/*
Solved.ac class project

class 2

latency
 */

/*
https://www.acmicpc.net/problem/2869
달팽이는 올라가고 싶다 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.15 초 (추가 시간 없음) (하단 참고)	128 MB	106018	28158	23792	27.950%
문제
땅 위에 달팽이가 있다. 이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.

달팽이는 낮에 A미터 올라갈 수 있다. 하지만, 밤에 잠을 자는 동안 B미터 미끄러진다. 또, 정상에 올라간 후에는 미끄러지지 않는다.

달팽이가 나무 막대를 모두 올라가려면, 며칠이 걸리는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 세 정수 A, B, V가 공백으로 구분되어서 주어진다. (1 ≤ B < A ≤ V ≤ 1,000,000,000)

출력
첫째 줄에 달팽이가 나무 막대를 모두 올라가는데 며칠이 걸리는지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2869 {

    public static void main(String[] args) throws IOException {
        BJ_2869 test = new BJ_2869();
    }

    public BJ_2869() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int morning = Integer.parseInt(stk.nextToken());
        int night = Integer.parseInt(stk.nextToken());
        int target = Integer.parseInt(stk.nextToken());

        int result = solution(morning,night,target);

        System.out.println(result);
    }


    public int solution(int morning ,int night,int target){
//        while(true){
//            day++;
//            if(target - morning <= 0){
//                break;
//            }
//            target -=(morning-night);
//
//
//        }
//
//
//        return day;

        //일단 나눈다
        int day = 0;
        int diff = morning - night;
        int semi_target= target -morning;
        day++;

        //나머지가 존재하는 경우는 +1 해주면 끝남
        if( semi_target % diff != 0){
            day+= semi_target/diff +1;
        }else{
            //나머지가 존재하지 않는 경우 (딱맞아 떨어짐)
            day+= semi_target/diff;

        }
        return day;

    }
}
