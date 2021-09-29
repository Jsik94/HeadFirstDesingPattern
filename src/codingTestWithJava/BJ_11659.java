package codingTestWithJava;

/*
Solved.ac class project

class 3


latency
 */

/*
https://www.acmicpc.net/problem/11659
구간 합 구하기 4
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	21003	10334	7978	48.243%
문제
수 N개가 주어졌을 때, i번째 수부터 j번째 수까지 합을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N과 합을 구해야 하는 횟수 M이 주어진다. 둘째 줄에는 N개의 수가 주어진다. 수는 1,000보다 작거나 같은 자연수이다. 셋째 줄부터 M개의 줄에는 합을 구해야 하는 구간 i와 j가 주어진다.

출력
총 M개의 줄에 입력으로 주어진 i번째 수부터 j번째 수까지 합을 출력한다.

제한
1 ≤ N ≤ 100,000
1 ≤ M ≤ 100,000
1 ≤ i ≤ j ≤ N
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_11659 {

    public static void main(String[] args) throws IOException {
        BJ_11659 test = new BJ_11659();
    }

    public BJ_11659() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(stk.nextToken());
        int cnt = Integer.parseInt(stk.nextToken());

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,0);
        stk= new StringTokenizer(br.readLine()," ");
        for (int i = 1 ; i <= len ; i ++){
            int pre = map.get(i-1);

            map.put(i,Integer.parseInt(stk.nextToken())+pre);
        }

        for (int i = 0 ; i < cnt ; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int result = 0;
            int start = Integer.parseInt(stk.nextToken())-1;
            int end = Integer.parseInt(stk.nextToken());
            result = map.get(end)-map.get(start);
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }


}
