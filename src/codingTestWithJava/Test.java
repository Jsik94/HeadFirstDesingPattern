package codingTestWithJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {

    public static void main(String[] args) throws IOException {
        Test test = new Test();
    }

    public Test() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;

        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            // 문서 갯수, 목적 인덱스
            stk = new StringTokenizer(br.readLine(), " ");

            int cnt = Integer.parseInt(stk.nextToken());
            int target_idx = Integer.parseInt(stk.nextToken());

            int[] datas = new int[cnt];

            //문서의 중요도
            stk = new StringTokenizer(br.readLine(), " ");

            for (int k = 0; k < cnt; k++) {
                datas[k] = Integer.parseInt(stk.nextToken());
            }

            sb.append(solution(datas, target_idx))
                    .append("\n");

        }


        System.out.println(sb);

    }


    public int solution(int[] datas, int target_idx) {
        int[] datas_sorted = datas.clone();
        int sorted_idx = datas_sorted.length - 1;
        // [0] - Value, [1] - IDX
        Queue<int[]> queue = new LinkedList<>();

        int idx = 0;



        Arrays.sort(datas_sorted);


        for (int i = 0; i < datas.length; i++) {
            queue.add(new int[]{datas[i], i});
        }

        while (!queue.isEmpty()) {
            if (queue.peek()[0] < datas_sorted[sorted_idx]) {
                queue.add(queue.poll());
            } else {
                //출력될 문서 중에서
                idx += 1;
                int[] tmp = queue.poll();

                if (tmp[0] == datas[target_idx] && tmp[1] == target_idx) {
                    break;
                }
                sorted_idx--;

            }

        }


        return idx;
    }

}
