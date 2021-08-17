package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/10869
사칙연산 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	186178	93645	82459	51.340%
문제
두 자연수 A와 B가 주어진다. 이때, A+B, A-B, A*B, A/B(몫), A%B(나머지)를 출력하는 프로그램을 작성하시오.

입력
두 자연수 A와 B가 주어진다. (1 ≤ A, B ≤ 10,000)

출력
첫째 줄에 A+B, 둘째 줄에 A-B, 셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10869 {
    public static void main(String[] args) throws IOException {


        BJ_10869 test = new BJ_10869();
    }

    public BJ_10869() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] num = br.readLine().split(" ");

        int[] answer = solution(Integer.parseInt(num[0]),Integer.parseInt(num[1]));

        for (int ans : answer){
            sb.append(ans+"\n");
        }

        System.out.println(sb);
    }

    public int[] solution(int num1,int num2){
        int[] answer = new int[5];

        answer[0]= num1 + num2;
        answer[1]= num1 - num2;
        answer[2]= num1 * num2;
        answer[3]= (num1 / num2);
        answer[4]= num1 % num2;

        return answer;
    }

}
