package codingTestWithJava;
/*
Solved.ac class project

class 2

latency :
 */

/*
https://www.acmicpc.net/problem/1654
랜선 자르기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	80598	18217	11907	20.658%
문제
집에서 시간을 보내던 오영식은 박성원의 부름을 받고 급히 달려왔다. 박성원이 캠프 때 쓸 N개의 랜선을 만들어야 하는데 너무 바빠서 영식이에게 도움을 청했다.

이미 오영식은 자체적으로 K개의 랜선을 가지고 있다. 그러나 K개의 랜선은 길이가 제각각이다. 박성원은 랜선을 모두 N개의 같은 길이의 랜선으로 만들고 싶었기 때문에 K개의 랜선을 잘라서 만들어야 한다. 예를 들어 300cm 짜리 랜선에서 140cm 짜리 랜선을 두 개 잘라내면 20cm는 버려야 한다. (이미 자른 랜선은 붙일 수 없다.)

편의를 위해 랜선을 자르거나 만들 때 손실되는 길이는 없다고 가정하며, 기존의 K개의 랜선으로 N개의 랜선을 만들 수 없는 경우는 없다고 가정하자. 그리고 자를 때는 항상 센티미터 단위로 정수길이만큼 자른다고 가정하자. N개보다 많이 만드는 것도 N개를 만드는 것에 포함된다. 이때 만들 수 있는 최대 랜선의 길이를 구하는 프로그램을 작성하시오.

입력
첫째 줄에는 오영식이 이미 가지고 있는 랜선의 개수 K, 그리고 필요한 랜선의 개수 N이 입력된다. K는 1이상 10,000이하의 정수이고, N은 1이상 1,000,000이하의 정수이다. 그리고 항상 K ≦ N 이다. 그 후 K줄에 걸쳐 이미 가지고 있는 각 랜선의 길이가 센티미터 단위의 정수로 입력된다. 랜선의 길이는 231-1보다 작거나 같은 자연수이다.

출력
첫째 줄에 N개를 만들 수 있는 랜선의 최대 길이를 센티미터 단위의 정수로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1654 {

    //    const int PRV_CALL= -1;
    public static void main(String[] args) throws IOException {
        BJ_1654 test = new BJ_1654();
    }

    public BJ_1654() throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int length = Integer.parseInt(info[0]);
        int target_cnt = Integer.parseInt(info[1]);

        long[] data = new long[length];

        for (int i = 0; i < length; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        //이진 탐색을 위한 정렬
        Arrays.sort(data);

        //탐색
        int result = binary_search(1, data[length - 1], 0, target_cnt, data);

        System.out.println(result);

    }

    //이진 탐색

    /**
     * @param start      start 이진 탐색 시작변수
     * @param end        end 이진 탐색 마지막 변수
     * @param result     result 이진 탐색을 통해 나온 길이
     * @param target_cnt 목표로 하는 랜선 갯수
     * @param data       원본데이터
     */
    public int binary_search(long start, long end, int result, int target_cnt, long[] data) {

        //재귀 종결 조건 (start 지점과 end가 역전되는경우
        if (start > end) {
            return result;
        }

        //중간 지점
        long mid = (long) Math.floor((start + end) / 2);

        //중간 지점을 기준으로 갯수 확인
        int count = check_count(data, mid);


        //count 갯수가 적다 --> mid가 크다 --> 길이를 줄여야한다 --> end 수정
        if (count < target_cnt) {
            end = mid - 1;
        } else {
            //count 갯수가 크다 --> mid가 작다
            // --> target_cnt는 일단 만족한다
            // --> 그러나 최대인지 알 수 없으므로 길이를 늘려야함 --> start 수정
            start = mid + 1;
            result = (int) mid;
        }

        //start 혹은 end를 수정해서 재귀
        int next_result = binary_search(start, end, result, target_cnt, data);

        //새로 구한 랜선의 길이가 이전 길이보다 작다면 결과값을 바꿔줄 필요가 있다.
        if (next_result < result) {
            next_result = result;
        }
        return next_result;
    }


    // div를 기준으로 나눴을 때, 나오는 랜선의 수
    public int check_count(long[] data, long div) {
        boolean answer = true;
        int cnt = 0;
        for (long num : data) {
            cnt += (int) (num / div);
        }

        return cnt;
    }

}