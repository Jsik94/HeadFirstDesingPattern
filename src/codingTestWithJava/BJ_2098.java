package codingTestWithJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2098 {



    int INF = 18000000;

    public static void main(String[] args) throws IOException {
        BJ_2098 test = new BJ_2098();
    }

    public BJ_2098() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;

        int[][] dp;
        int[][] arr;
        int cnt = Integer.parseInt(br.readLine());
        dp = new int[cnt][(1<<cnt)-1];
        arr = new int[cnt][cnt];

        for (int i = 0; i < cnt; i++) {

            stk = new StringTokenizer(br.readLine(), " ");
            int j = 0;
            while (stk.hasMoreTokens()) {
                arr[i][j++] = Integer.parseInt(stk.nextToken());
            }

        }

        for (int i = 0; i < cnt; i++) {
            Arrays.fill(dp[i], INF);
        }

        System.out.println(solution(0,1,dp,arr));

    }


    public int solution(int curr_loc, int visit, int[][] dp, int[][] arr) {

        if (visit == (1<< dp.length) -1) {

            return arr[curr_loc][0] == 0 ? INF : arr[curr_loc][0];
        }

        if (dp[curr_loc][visit] != INF) {
            return dp[curr_loc][visit];
        }

        for (int i = 0; i < arr.length; i++) {
            //해당 노드를 거치지 않은 경우 + 경로가 있는 경우

            if ((visit & (1<< i)) == 0 && arr[curr_loc][i] != 0) {

                dp[curr_loc][visit] = Math.min(dp[curr_loc][visit], solution(i, visit | (1<<i) , dp, arr)+ arr[curr_loc][i]);
            }

        }


        return dp[curr_loc][visit];

    }


}
