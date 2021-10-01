package codingTestWithJava;

/*
Solved.ac class project

class 3

latency
 */
/*
https://www.acmicpc.net/problem/11286
절댓값 힙
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초 (추가 시간 없음) (하단 참고)	256 MB	15205	8388	6983	57.153%
문제
절댓값 힙은 다음과 같은 연산을 지원하는 자료구조이다.

배열에 정수 x (x ≠ 0)를 넣는다.
배열에서 절댓값이 가장 작은 값을 출력하고, 그 값을 배열에서 제거한다. 절댓값이 가장 작은 값이 여러개일 때는, 가장 작은 수를 출력하고, 그 값을 배열에서 제거한다.
프로그램은 처음에 비어있는 배열에서 시작하게 된다.

입력
첫째 줄에 연산의 개수 N(1≤N≤100,000)이 주어진다. 다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다. 만약 x가 0이 아니라면 배열에 x라는 값을 넣는(추가하는) 연산이고, x가 0이라면 배열에서 절댓값이 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다. 입력되는 정수는 -231보다 크고, 231보다 작다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BJ_11286 {

    public static void main(String[] args) throws IOException {
        BJ_11286 test =new BJ_11286();
    }

    public BJ_11286() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs_a = Math.abs(o1);
            int abs_b = Math.abs(o2);
            if(abs_a ==abs_b){
               return o1.compareTo(o2);
           }else{
               return (abs_a - abs_b) < 0 ? -1 : 1;
           }
        });

        StringBuilder sb = new StringBuilder();


        for (int i = 0 ; i < cnt ; i++){
            int k = Integer.parseInt(br.readLine());

            if(k !=0){
                pq.add(k);
            }else{
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }else{
                    sb.append(pq.poll()+"\n");
                }
            }

        }

        System.out.println(sb);

    }


}
