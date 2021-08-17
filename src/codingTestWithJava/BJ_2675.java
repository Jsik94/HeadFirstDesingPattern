package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/2675
문자열 반복 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	82190	42282	36671	52.209%
문제
문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오. 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.

QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.

입력
첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다. S의 길이는 적어도 1이며, 20글자를 넘지 않는다.

출력
각 테스트 케이스에 대해 P를 출력한다.



쉬운문제였는데 입출력을 컨트롤하면서 이슈대처를 제대로 못한게 큰듯


 */


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_2675 {

    public static void main(String[] args) throws IOException {

        BJ_2675 test = new BJ_2675();
    }

    public BJ_2675() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int cnt = Integer.parseInt(br.readLine().split(" ")[0]);
        String[] sen = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            sen[i] = br.readLine();
        }
        String answer = String.valueOf(solution(cnt, sen));
        System.out.println(answer);
    }

    public StringBuilder solution(int cnt, String[] sen) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < cnt; i++) {
            int repeat = Integer.parseInt(sen[i].split(" ")[0]);
            String str = sen[i].split(" ")[1];

            for (char word : str.toCharArray()){
                for (int j = 0 ; j < repeat ; j++) {
                    sb.append(word);
                }
            }
            sb.append("\n");
        }

        return sb;
    }

}
