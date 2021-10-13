package codingTestWithJava;

/*
Solved.ac class project

class 3

latency : 8m34s
 */

/*
https://www.acmicpc.net/problem/1107
리모컨
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	52884	12340	8417	22.220%
문제
수빈이는 TV를 보고 있다. 수빈이는 채널을 돌리려고 했지만, 버튼을 너무 세게 누르는 바람에, 일부 숫자 버튼이 고장났다.

리모컨에는 버튼이 0부터 9까지 숫자, +와 -가 있다. +를 누르면 현재 보고있는 채널에서 +1된 채널로 이동하고, -를 누르면 -1된 채널로 이동한다. 채널 0에서 -를 누른 경우에는 채널이 변하지 않고, 채널은 무한대 만큼 있다.

수빈이가 지금 이동하려고 하는 채널은 N이다. 어떤 버튼이 고장났는지 주어졌을 때, 채널 N으로 이동하기 위해서 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.

수빈이가 지금 보고 있는 채널은 100번이다.

입력
첫째 줄에 수빈이가 이동하려고 하는 채널 N (0 ≤ N ≤ 500,000)이 주어진다.  둘째 줄에는 고장난 버튼의 개수 M (0 ≤ M ≤ 10)이 주어진다. 고장난 버튼이 있는 경우에는 셋째 줄에는 고장난 버튼이 주어지며, 같은 버튼이 여러 번 주어지는 경우는 없다.

출력
첫째 줄에 채널 N으로 이동하기 위해 버튼을 최소 몇 번 눌러야 하는지를 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1107 {
    public static void main(String[] args) throws IOException {
        BJ_1107 test = new BJ_1107();
    }

    public BJ_1107() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int target = Integer.parseInt(br.readLine());

        int error_cnt = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[10];

        if(error_cnt !=0){
            stk = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < error_cnt; i++) {
                arr[Integer.parseInt(stk.nextToken())] = true;
            }
        }

        System.out.println(solution(target, arr));
    }

    private int solution(int target, boolean[] arr) {

        // 100부터 순차적으로 갔을때
        int count = Math.abs(target -100);
        for (int i = 0 ; i <= 999999 ; i++){

            int press_cnt =getlen(i,arr);
            if(press_cnt==-1){
                continue;
            }
            int total_cnt=  press_cnt+ Math.abs(target-i);
            count = Math.min(count,total_cnt);
        }


        return count;
    }


    //해당 i에 대해 갈 수 있다면, 자릿수 반환, 없다면 0 반환
    private int getlen(int i,boolean[] arr){
        int result =0;

        //i : 0 인데 고장난경우
        if (i ==0){
            if(arr[0]){
                return -1;
            }
            return 1;
        }

        while(i!= 0){
            if(arr[i%10]){
                return -1;
            }else{
                result++;
                i/=10;
            }
        }


        return result;
    }

}
