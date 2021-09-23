package codingTestWithJava;

/*
Solved.ac class project

class 3


latency

 */

/*
https://www.acmicpc.net/problem/1780
종이의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	20592	12096	9119	58.741%
문제
N×N크기의 행렬로 표현되는 종이가 있다. 종이의 각 칸에는 -1, 0, 1 중 하나가 저장되어 있다. 우리는 이 행렬을 다음과 같은 규칙에 따라 적절한 크기로 자르려고 한다.

만약 종이가 모두 같은 수로 되어 있다면 이 종이를 그대로 사용한다.
(1)이 아닌 경우에는 종이를 같은 크기의 종이 9개로 자르고, 각각의 잘린 종이에 대해서 (1)의 과정을 반복한다.
이와 같이 종이를 잘랐을 때, -1로만 채워진 종이의 개수, 0으로만 채워진 종이의 개수, 1로만 채워진 종이의 개수를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 N(1 ≤ N ≤ 37, N은 3k 꼴)이 주어진다. 다음 N개의 줄에는 N개의 정수로 행렬이 주어진다.

출력
첫째 줄에 -1로만 채워진 종이의 개수를, 둘째 줄에 0으로만 채워진 종이의 개수를, 셋째 줄에 1로만 채워진 종이의 개수를 출력한다.

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1780 {

    public static void main(String[] args) throws IOException {
        BJ_1780 test =new BJ_1780();
    }

    public BJ_1780() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        int[][] arr  = new int[size][size];

        for (int i = 0 ; i < arr.length ; i++){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            for (int j = 0 ; j < arr[i].length; j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }


        int[] output = solution(arr,0,0,new int[3],size);
        for (int answer :output){
            System.out.println(answer);
        }
    }

    int[] solution (int[][] arr,int start_y,int start_x,int[] result,int size){

        //해당 기준좌표부터 size 영역만큼을 검사
        if(isFull(arr,start_y,start_x,size)){
            //모두 같은 수라면 데이터 증가
            if(arr[start_y][start_x]==-1){
                result[0]+=1;
            }else if( arr[start_y][start_x]==0){
                result[1]+=1;
            }else{
                result[2]+=1;
            }
        }else {

            //size/3 만큼 쪼갠다.
            for (int i = start_y; i < start_y + size; i += size/3) {
                for (int j = start_x; j < start_x + size; j += size/3) {
                    {
                        //재귀적으로 들어가서 검사
                        int[] tmp = solution(arr, i, j, result, size / 3);
                        int k = 0;
                        for (int data : tmp) {
                            result[k++] = data;
                        }

                    }
                }
            }
        }

        return result;
    }

    boolean isFull(int[][] arr, int start_y,int start_x, int target_size){

        int compare_val = arr[start_y][start_x];
        for (int i = start_y ; i < start_y+target_size ; i++){
            for (int j = start_x ; j < start_x + target_size; j++){
                if(compare_val != arr[i][j]){
                    return false;
                }
            }
        }

        return true;
    }




}
