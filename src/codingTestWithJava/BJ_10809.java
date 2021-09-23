package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/10809
알파벳 찾기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	88569	47346	39754	54.033%
문제
알파벳 소문자로만 이루어진 단어 S가 주어진다. 각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 단어 S가 주어진다. 단어의 길이는 100을 넘지 않으며, 알파벳 소문자로만 이루어져 있다.

출력
각각의 알파벳에 대해서, a가 처음 등장하는 위치, b가 처음 등장하는 위치, ... z가 처음 등장하는 위치를 공백으로 구분해서 출력한다.

만약, 어떤 알파벳이 단어에 포함되어 있지 않다면 -1을 출력한다. 단어의 첫 번째 글자는 0번째 위치이고, 두 번째 글자는 1번째 위치이다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_10809 {
    public static void main(String[] args) throws IOException {
        BJ_10809 test = new BJ_10809();
    }

    public BJ_10809() throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        int[] answers = solution(str);

        for (int result : answers){
            sb.append(result + " ");
        }

        System.out.println(sb);
    }

    public int[] solution (String str){
        int[] data =new int[26];
        for (int i = 97 ; i < 123 ; i++){

            data[i-97] = str.indexOf((char)i);
        }

        return data;
    }

}
