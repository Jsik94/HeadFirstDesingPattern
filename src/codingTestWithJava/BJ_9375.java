package codingTestWithJava;
/*
Solved.ac class project

class 3

 */
/*
https://www.acmicpc.net/problem/9375
패션왕 신해빈 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	11235	6043	5241	54.822%
문제
해빈이는 패션에 매우 민감해서 한번 입었던 옷들의 조합을 절대 다시 입지 않는다. 예를 들어 오늘 해빈이가 안경, 코트, 상의, 신발을 입었다면, 다음날은 바지를 추가로 입거나 안경대신 렌즈를 착용하거나 해야한다. 해빈이가 가진 의상들이 주어졌을때 과연 해빈이는 알몸이 아닌 상태로 며칠동안 밖에 돌아다닐 수 있을까?

입력
첫째 줄에 테스트 케이스가 주어진다. 테스트 케이스는 최대 100이다.

각 테스트 케이스의 첫째 줄에는 해빈이가 가진 의상의 수 n(0 ≤ n ≤ 30)이 주어진다.
다음 n개에는 해빈이가 가진 의상의 이름과 의상의 종류가 공백으로 구분되어 주어진다. 같은 종류의 의상은 하나만 입을 수 있다.
모든 문자열은 1이상 20이하의 알파벳 소문자로 이루어져있으며 같은 이름을 가진 의상은 존재하지 않는다.

출력
각 테스트 케이스에 대해 해빈이가 알몸이 아닌 상태로 의상을 입을 수 있는 경우를 출력하시오.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_9375 {

    public static void main(String[] args) throws IOException {
        BJ_9375 test = new BJ_9375();
    }

    public BJ_9375() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        Map<String, Integer> map ;

        for (int i = 0; i < tc; i++) {
            map= new HashMap<>();
            int cnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < cnt; j++) {
                StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
                stk.nextToken();
                String name = stk.nextToken();
                if(map.get(name)==null){
                    map.put(name,1);
                }else{
                    map.put(name,map.get(name)+1);
                }
            }
            sb.append(solution(map)).append("\n");


        }

        System.out.println(sb);
    }


    private int solution( Map<String, Integer> map){

        int reuslt=1;

        for (Map.Entry<String,Integer> entry: map.entrySet()){
            reuslt*=(entry.getValue()+1);
        }

        reuslt-=1;

        return reuslt;
    }

}
