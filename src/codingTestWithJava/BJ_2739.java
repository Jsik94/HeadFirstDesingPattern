package codingTestWithJava;

/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/2739

구구단
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	182162	92625	79997	52.083%
문제
N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.

입력
첫째 줄에 N이 주어진다. N은 1보다 크거나 같고, 9보다 작거나 같다.

출력
출력형식과 같게 N*1부터 N*9까지 출력한다.

 */


import java.util.Scanner;

public class BJ_2739 {

    public static void main(String[] args) {
        BJ_2739 test = new BJ_2739();
    }

    public BJ_2739(){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        System.out.println(solution(num));



    }

    public StringBuilder solution (int n){

        StringBuilder sb =new StringBuilder();

        for (int i = 1 ; i < 10 ; i++){
            String tmp = Integer.toString(n);
            tmp += " * ";
            tmp += i;
            tmp += " = ";
            tmp += i* n;
            if (i != 9){
                tmp+= "\n";
            }
            sb.append(tmp);
        }

        return sb;
    }
}
