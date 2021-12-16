package codingTestWithJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1449 {

    public static void main(String[] args) throws IOException {
        BJ_1449 test =new BJ_1449();
    }

    public BJ_1449() throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int cnt = Integer.parseInt(stk.nextToken());
        int tape = Integer.parseInt(stk.nextToken());

        int[] points = new int[cnt];

        stk = new StringTokenizer(br.readLine()," ");
        for (int i = 0 ; i < cnt ; i++){
            points[i] = Integer.parseInt(stk.nextToken());
        }

        Arrays.sort(points);

        System.out.println(solution(points,tape));

    }

    private int solution(int[] points, int tape) {
        int count =1;

        //앞과 뒤의 값차 +1이 테이프 보다 작으면 하나로 가능
        // 값차 +1 이 테이프보다 크면 테이프 추가

        int first_val = points[0];
        for (int i = 1 ; i < points.length ;i++){

            if( points[i] - first_val +1 > tape){
                count+=1;
                first_val = points[i];
            }
        }


        return count;
    }


}
