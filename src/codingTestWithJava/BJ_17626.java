package codingTestWithJava;
/*
Solved.ac class project

class 3

 */
/*
https://www.acmicpc.net/problem/17626
Four Squares 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
0.5 초 (추가 시간 없음)	512 MB	5847	2758	2214	51.037%
문제
라그랑주는 1770년에 모든 자연수는 넷 혹은 그 이하의 제곱수의 합으로 표현할 수 있다고 증명하였다. 어떤 자연수는 복수의 방법으로 표현된다. 예를 들면, 26은 52과 12의 합이다; 또한 42 + 32 + 12으로 표현할 수도 있다. 역사적으로 암산의 명수들에게 공통적으로 주어지는 문제가 바로 자연수를 넷 혹은 그 이하의 제곱수 합으로 나타내라는 것이었다. 1900년대 초반에 한 암산가가 15663 = 1252 + 62 + 12 + 12라는 해를 구하는데 8초가 걸렸다는 보고가 있다. 좀 더 어려운 문제에 대해서는 56초가 걸렸다: 11339 = 1052 + 152 + 82 + 52.

자연수 n이 주어질 때, n을 최소 개수의 제곱수 합으로 표현하는 컴퓨터 프로그램을 작성하시오.

입력
입력은 표준입력을 사용한다. 입력은 자연수 n을 포함하는 한 줄로 구성된다. 여기서, 1 ≤ n ≤ 50,000이다.

출력
출력은 표준출력을 사용한다. 합이 n과 같게 되는 제곱수들의 최소 개수를 한 줄에 출력한다.
 */


import java.util.Scanner;

public class BJ_17626 {

    public static void main(String[] args) {
        BJ_17626 test =new BJ_17626();
    }

    public BJ_17626() {
        Scanner sc = new Scanner(System.in);

        int num =sc.nextInt();


        System.out.println(solution(num));
    }

    private int solution(int num) {
        int[] arr = new int[50001];
        arr[0]=0;

        //i를 만들 수 있는 제곱의 최소갯수 ?

        for (int i = 1 ; i <= num;i++){
            arr[i] = i;
            for (int j = 0; j*j <= i ;j++){
                //모든 경우의 수 계산다 해봄
                arr[i] = Math.min(arr[i],1+arr[i-j*j]);
            }
        }


        return arr[num];
    }
}
