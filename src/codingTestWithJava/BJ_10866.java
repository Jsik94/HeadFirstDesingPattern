package codingTestWithJava;

/*
Solved.ac class project

class 2


latency
 */
/*
acmicpc.net/problem/10866
덱
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초 (추가 시간 없음)	256 MB	31133	16815	14234	56.354%
문제
정수를 저장하는 덱(Deque)를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 여덟 가지이다.

push_front X: 정수 X를 덱의 앞에 넣는다.
push_back X: 정수 X를 덱의 뒤에 넣는다.
pop_front: 덱의 가장 앞에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
pop_back: 덱의 가장 뒤에 있는 수를 빼고, 그 수를 출력한다. 만약, 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 덱에 들어있는 정수의 개수를 출력한다.
empty: 덱이 비어있으면 1을, 아니면 0을 출력한다.
front: 덱의 가장 앞에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
back: 덱의 가장 뒤에 있는 정수를 출력한다. 만약 덱에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10866 {

    List<Integer> datas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BJ_10866 test = new BJ_10866();
    }

    public BJ_10866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            String command = stk.nextToken();
            int data = 0;
            if (stk.hasMoreTokens()) {
                data = Integer.parseInt(stk.nextToken());
            }

            solution(command, data);
        }
    }

    public void solution(String command, int data) {
        int result = 0;
        if (command.equals("push_front")) {
            datas.add(0,data);
            return;
        } else if (command.equals("push_back")) {
            int idx = 0;
            if( datas.size() -1 >= 0 ){
                idx = datas.size();
            }

            datas.add(idx,data);
            return;
        } else if (command.equals("pop_front")) {

            if (datas.isEmpty()){
                result = -1;
            }else{

                result = datas.remove(0);
            }
        } else if (command.equals("pop_back")) {
            if (datas.isEmpty()){
                result  = -1;
            }else{

                result = datas.remove(datas.size()-1);
            }
        } else if (command.equals("size")) {
            result = datas.size();
        } else if (command.equals("empty")) {
            result  =datas.isEmpty() ? 1: 0 ;
        } else if (command.equals("front")) {
            if (datas.isEmpty()){
                result =  -1;
            }else{

                result = datas.get(0);
            }
        } else if (command.equals("back")) {
            if (datas.isEmpty()){
                result =  -1;
            }else{

                result =datas.get(datas.size()-1);
            }
        }
        System.out.println(result);
        return;
    }
}
