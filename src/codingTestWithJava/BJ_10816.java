package codingTestWithJava;
/*
Solved.ac class project

class 2


latency
 */

/*
https://www.acmicpc.net/problem/10816
숫자 카드 2
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	43410	15602	11079	35.618%
문제
숫자 카드는 정수 하나가 적혀져 있는 카드이다. 상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다. 숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다. 넷째 줄에는 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수가 주어지며, 이 수는 공백으로 구분되어져 있다. 이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.

출력
첫째 줄에 입력으로 주어진 M개의 수에 대해서, 각 수가 적힌 숫자 카드를 상근이가 몇 개 가지고 있는지를 공백으로 구분해 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ_10816 {

    public static void main(String[] args) throws IOException {
        BJ_10816 test = new BJ_10816();
    }

    public BJ_10816() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        HashMap<Integer, Integer> datas = new HashMap<>();


        int N = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");

        for (int i = 0 ; i < N ; i++){
            int keyNum = Integer.parseInt(stk.nextToken());
            datas.put(keyNum,datas.getOrDefault(keyNum,0)+1);
        }


        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        stk = new StringTokenizer(br.readLine()," ");

        for(int k = 0 ; k < M ; k++){
            targets[k] =Integer.parseInt(stk.nextToken());

        }

        System.out.println(solution(datas,targets));


    }

    public StringBuilder solution(HashMap<Integer,Integer> datas, int[] targets){
        StringBuilder sb = new StringBuilder();
        for (int target : targets){
            sb.append(datas.getOrDefault(target,0)+" ");
        }
        return sb;
    }
}
