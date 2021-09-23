package codingTestWithJava;


/*
Solved.ac class project

class 3

 */

/*
https://www.acmicpc.net/problem/18870
좌표 압축
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	14869	6717	5036	43.677%
문제
수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.

Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.

X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.

입력
첫째 줄에 N이 주어진다.

둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.

출력
첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
제한
1 ≤ N ≤ 1,000,000
-109 ≤ Xi ≤ 109
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ_18870 {

    public static void main(String[] args) throws IOException {
        BJ_18870 test = new BJ_18870();
    }

    public BJ_18870() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        Map<Integer, Integer> map = new HashMap<>();
        int tc = Integer.parseInt(br.readLine());
        stk = new StringTokenizer(br.readLine(), " ");
        int[] results = new int[tc];

        for (int i = 0; i < tc; i++) {
            results[i] = Integer.parseInt(stk.nextToken());
        }
        int[] copied = results.clone();
        Arrays.sort(copied);
        int cnt = 0;
        for (int result : copied) {
            //데이터 존재시 넘어감
            if (map.get(result) != null) {
                continue;
            }
            map.put(result, cnt++);

        }

        for (int result : results){
            sb.append(map.get(result)+" ");
        }

        System.out.println(sb);

    }
}
