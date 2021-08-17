package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/1157
단어 공부
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	111351	43595	34922	39.087%
문제
알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.

입력
첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.

출력
첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

대문자 65 ~ 90 차이 32

실패원인
Hashmap 정리하면좋을듯
메모리초과
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1157 {

    public static void main(String[] args) throws IOException {
        BJ_1157 test = new BJ_1157();
    }

    public BJ_1157() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char answer = solution(str);
        System.out.println(answer);
    }

    public char solution(String str){
        char answer = '?';
        //알파벳 만큼 배열생성
        int[] cnt = new int[26];

        for(int i = 0 ; i < str.length() ;i++){
            int value = str.charAt(i);
            //대문자 치환
            if(value>=97 && value<123){
                 value=  str.charAt(i)-32;

            }
            cnt[value-65]++;
        }


        int idx = 0;
        int max = -1 ;
        boolean same_value = false;
        for(int i = 0 ; i < cnt.length ; i++){
            if(cnt[i] > max){
                same_value = false;
                max = cnt[i];
                idx = i;
            }else if(cnt[i] == max){
                same_value = true;
            }
        }
        if(same_value){
            idx = -2;// ? ASCII :63
        }
        answer = (char) (idx+65);

        return answer;
    }


}
