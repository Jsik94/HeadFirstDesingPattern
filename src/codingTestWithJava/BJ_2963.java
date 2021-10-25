package codingTestWithJava;

/*
* https://www.acmicpc.net/problem/2963
무한 이진 트리 탐색 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	295	80	61	31.282%
문제
다음과 같은 세가지 성질을 갖는 트리를 무한 이진 트리라고 한다.

모든 노드는 두 개의 자식 노드를 가지고 있다. 왼쪽 노드, 오른쪽 노드
어떤 노드의 번호가 X라면, 왼쪽 자식 노드의 번호는 2*X, 오른쪽 자식 노드의 번호는 2*X+1이다.
루트의 번호는 1이다.
무한 이진 트리를 탐색할 때는, 루트에서 시작한다. 그리고, 왼쪽 자식 또는 오른쪽 자식으로 이동하거나, 현재 노드에서 그대로 있을 수 있다.

탐색은 'L','R','P'로 이루어진 문자열로 표현할 수 있다.

'L': 왼쪽 자식으로 이동
'R': 오른쪽 자식으로 이동
'P': 현재 노드에 그대로 있음
탐색의 값은 마지막으로 방문한 노드의 번호이다. 예를 들어, LR의 값은 5이고, RPP의 값은 3이다.

탐색의 집합은 'L','R','P','*'로 이루어진 문자열로 표현할 수 있다. '*'는 3개중 그 어떤 것이 될 수 있다.

탐색의 집합은 문자열과 일치하는 모든 패턴을 포함한다.

예를 들어, L*R은 LLR, LRR, LPR이며, **은 LL,LR,LP,RL,RR,RP,PL,PR,PP이다.

마지막으로, 탐색의 집합의 값은 탐색의 집합에 포함되어 있는 모든 탐색의 값의 합이다.

탐색의 집합의 문자열이 주어졌을 때, 탐색의 집합의 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 탐색의 집합의 문자열이 주어진다. 이 문자열은 'L','R','P','*'로만 이루어져 있으며, 길이가 최대 10,000이다.

출력
첫째 줄에 탐색의 집합의 합을 출력한다.
*
*
*
*  내생각인데 걍 노가다 해야됨 답이없음
*
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2963 {
    boolean startoggle=false;

    public static void main(String[] args) throws IOException {
        BJ_2963 test =new BJ_2963();

    }


    public BJ_2963() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


            String data = br.readLine();

            System.out.println(solution(data));


    }

    private long solution(String data) {

        long val = 1;
//        if (data.startsWith("*")) {
//            data = "P" + data;
//        }



        for (int i = 0; i < data.length(); i++) {
            val = cal(val, data.charAt(i));
        }

//        if(data.endsWith("*")){
//            val = 3*val+2*val+3;
//        }else{
//            val = cal(val,data.charAt(data.length()-1));
//        }



        return val;
    }

    private long cal(long cur, char ch) {
        switch (ch) {
            case 'P':
                return cur;
            case 'L':
                return cur * 2;
            case 'R':
                if(startoggle){
                    startoggle = false;
                    return  cur * 2 +3;
                }
                return cur * 2 + 1;

            default:

                if(!startoggle){
                    startoggle = true;
                    //* case
                    return cur * 5 + 1;
                }else{
                    return cur * 5 + 3;
                }




        }
    }


}
