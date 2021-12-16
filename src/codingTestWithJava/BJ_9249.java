package codingTestWithJava;

/*

최장 공통 부분 문자열 스페셜 저지
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	2021	457	307	26.930%
문제
문자열 \(T=t_1t_2\dots t_m\)가 문자열 \(S=s_1s_2\dots s_n\)의 부분 문자열이 되려면, \(s_{i+1}s_{i+2}\dots s_{i+m} = T\)를 만족하는 \(0 \le i \le n-m\)가 있어야 한다.

두 문자열 \(A\)와 \(B\)가 주어졌을 때, 두 문자열의 공통 부분 문자열의 최대 길이와 그 부분 문자열을 구하는 프로그램을 작성하시오.

입력
두 문자열 \(A\)와 \(B\)가 한 줄에 하나씩 주어진다. 두 문자열 길이의 합은 20만을 넘지 않는다. 주어지는 문자열은 알파벳 소문자로만 이루어져 있다.

출력
첫째 줄에 두 문자열의 최장 공통 부분 문자열의 길이를 출력한다.

둘째 줄에 해당 부분 문자열을 출력한다.

답이 여러 가지인 경우에는 아무거나 출력한다.


teset
sa 를 구하고,


S의 길이를 넘지 않는 한에서 LCS 를 구해야한다...

LCs


ㄴ

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_9249 {

    static String[][] cache;
    static char[] base_arr;
    static char[] com_arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String base =br.readLine();
        String com = br.readLine();

        cache= new String[base.length()][com.length()];
        System.out.println(solution(base,com));
    }



    public static String solution(String base, String com) {
        base_arr = base.toCharArray();
        com_arr = com.toCharArray();

        String result = "";

        for (int i = 0; i < base_arr.length; i++) {
            for (int j = 0; j < com_arr.length; j++) {
                cache[i][j] = "";
            }
        }

        for (int i = 0; i < base_arr.length; i++) {
            for (int j = 0; j < com_arr.length; j++) {
                String s = lcs(i, j);
                //1이상의 lcs 가 존재할때 이전보다 크다면 변경
                if (s == "") {
                    continue;
                } else if (result.length() < s.length()) {
                    System.out.println(result);
                    result = s;
                }
            }
        }
        return result;
    }


    //지금 문자가 일치한다면 이전까지 재귀
    public static String lcs(int i, int j) {
        if (i < 0 || j < 0) {
            return "";
        }
        if (cache[i][j] != "") {
            return cache[i][j];
        }
        if (base_arr[i] == com_arr [j]) {
            cache[i][j] = lcs(i - 1, j - 1) + base_arr[i];
        }
        return cache[i][j];
    }


}
