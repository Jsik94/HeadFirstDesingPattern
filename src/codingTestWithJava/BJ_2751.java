package codingTestWithJava;
/*
Solved.ac class project

class 2


latency
 */

/*
https://www.acmicpc.net/problem/2751
수 정렬하기 2
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	138741	37133	25367	30.029%
문제
N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 수는 중복되지 않는다.

출력
첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2751 {

    //int[] result;

    public static void main(String[] args) throws IOException {
        BJ_2751 test = new BJ_2751();
    }

    public BJ_2751() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[] datas = new int[tc];

        for (int i = 0; i < tc; i++) {
            datas[i] = Integer.parseInt(br.readLine());
        }

        countingSort(datas);

        for (int data : datas) {
            sb.append(data + "\n");
        }

        System.out.println(sb);

    }


    private void countingSort(int[] datas) {
        int[] results = new int[2000001];
        for (int data : datas) {
            results[data + 1000000] += 1;
        }

        int idx = 0;
        for (int i = 0; i < results.length; i++) {
            if (results[i] != 0) {
                datas[idx] = i - 1000000;
                idx++;
            }
        }

    }
//
//    private void insertSort(int[] datas) {
//
//        //insert Sort
//        for (int i = 1 ;  i < datas.length ;i++){
//            int tmp = datas[i];
//            for (int j = i-1  ; j >= 0 ; j--){
//                //
//                if (datas[j] > tmp){
//
//                    datas[j+1] = datas[j];
//                    datas[j] = tmp;
//                }
//            }
//        }
//    }
//
//    private void mergeSort(int[] datas, int left,int right){
//        if(left ==right){
//            return;
//        }
//
//        int mid = (left+right)/2;
//
//
//        mergeSort(datas, left,mid);
//
//        mergeSort(datas, mid+1, right);
//
//        merge(datas,left, mid, right);
//
//    }
//
//    private void merge(int[] datas, int left, int mid, int right) {
//        int left_start = left;
//        int right_start = mid +1;
//        int idx = left;
//
//        while (left_start <= mid && right_start <= right){
//
//            if(datas[idx] <= datas[right_start]){
//                //왼쪽을 넣는 경우
//                result[idx++] = datas[left_start++];
//            }
//            else{
//                //오른쪽을 넣는 경우
//                result[idx++] = datas[right_start++];
//
//            }
//
//            if(left_start > mid) {
//                while(right_start <= right) {
//                    result[idx++] = datas[right_start++];
//
//                }
//            }else {
//                while(left_start <= mid) {
//                    result[idx++] = datas[left_start++];
//                }
//            }
//
//            for(int i = left; i <= right; i++) {
//                datas[i] = datas[i];
//            }
//        }
//
//    }


}
