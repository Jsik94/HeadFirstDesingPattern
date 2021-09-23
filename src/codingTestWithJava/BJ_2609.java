package codingTestWithJava;

/*
Solved.ac class project

class 2


latency
 */


/*
https://www.acmicpc.net/problem/2609
대공약수와 최소공배수 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	45364	26895	21895	61.351%
문제
두 개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 두 개의 자연수가 주어진다. 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.

출력
첫째 줄에는 입력으로 주어진 두 수의 최대공약수를, 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_2609 {

    public static void main(String[] args) throws IOException {
        BJ_2609 test =new BJ_2609();

    }

    public BJ_2609() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int num1 = Integer.parseInt(stk.nextToken());
        int num2 = Integer.parseInt(stk.nextToken());


        int[] answers = solution(num1,num2);

        System.out.println(answers[0]+" " +answers[1]);
    }

    private int[] solution (int a, int b){
        int gc = gcd(a,b);
        int[] result = new int[]{gc,gc*(a/gc)*(b/gc)};

        return result;
    }

    //유클리드 알고리즘
    private int gcd(int a , int b){
        // 나머지가 0 이되는 순간 다음 호출에서 리턴한다.
        if( b== 0 ){
            return a;
        }

        int mod = a % b;

        return gcd(b,mod);
    }


}
