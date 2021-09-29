package codingTestWithJava;
/*
Solved.ac class project

class 3

 */

/*
https://www.acmicpc.net/problem/1927
최소 힙
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초 (추가 시간 없음) (하단 참고)	128 MB	31621	14335	11209	48.631%
문제
널리 잘 알려진 자료구조 중 최소 힙이 있다. 최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.

배열에 자연수 x를 넣는다.
배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. x는 231보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.

출력
입력에서 0이 주어진 횟수만큼 답을 출력한다. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class BJ_1927 {

    public static void main(String[] args) throws IOException {
        BJ_1927 test = new BJ_1927();
    }

    public BJ_1927() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        Queue<Integer> pque = new PriorityQueue<>();

        for (int i = 0 ; i <tc ; i++){
            int data = Integer.parseInt(br.readLine());

            if(data ==0){
                if(pque.isEmpty()){
                    sb.append(0);
                }else{
                    sb.append(pque.poll());
                }
                sb.append("\n");
                continue;
            }

            pque.add(data);

        }

        System.out.println(sb);

    }
}
