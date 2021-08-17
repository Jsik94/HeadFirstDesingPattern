package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/10998
A×B
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	117332	91103	82847	78.724%
문제
두 정수 A와 B를 입력받은 다음, A×B를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 A와 B가 주어진다. (0 < A, B < 10)

출력
첫째 줄에 A×B를 출력한다.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10998 {

    public static void main(String[] args) throws IOException {
        BJ_10998 test =new BJ_10998();
    }

    public BJ_10998() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int num1 = Integer.parseInt(str[0]);
        int num2 = Integer.parseInt(str[1]);

        int answer = solution(num1,num2);
        System.out.println(answer);
    }

    public int solution(int num1, int num2){
        return num1 * num2;
    }
}
