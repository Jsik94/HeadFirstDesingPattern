package codingTestWithJava;

/*
Solved.ac class project

class 2


latency
 */


/*
https://www.acmicpc.net/problem/11651
좌표 정렬하기 2
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	27814	18434	15546	68.208%
문제
2차원 평면 위의 점 N개가 주어진다. 좌표를 y좌표가 증가하는 순으로, y좌표가 같으면 x좌표가 증가하는 순서로 정렬한 다음 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 점의 개수 N (1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N개의 줄에는 i번점의 위치 xi와 yi가 주어진다. (-100,000 ≤ xi, yi ≤ 100,000) 좌표는 항상 정수이고, 위치가 같은 두 점은 없다.

출력
첫째 줄부터 N개의 줄에 점을 정렬한 결과를 출력한다.
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ_11651 {

    public static void main(String[] args) throws IOException {
        BJ_11651 test = new BJ_11651();

    }

    public BJ_11651() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk ;
        int tc = Integer.parseInt(br.readLine());

        List<int[]> datas = new ArrayList<>();
        for (int i = 0; i < tc; i++) {
            int[] info = new int[2];
            stk = new StringTokenizer(br.readLine()," ");
            info[0] = Integer.parseInt(stk.nextToken());
            info[1] = Integer.parseInt(stk.nextToken());
            datas.add(info);
        }
        solution(datas);

        for (int[] data : datas){
            for (int info : data){
                sb.append(info+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public void solution( List<int[]> datas) {
        Collections.sort(datas, (o1,o2)->{
            if(o1[1] == o2[1]){
                if(o1[0] < o2[0]){
                    return  -1;
                }else{
                    return  1;
                }

            }else{
                return Integer.compare(o1[1],o2[1]);
            }
        });
    }

}
