package codingTestWithJava;

/*
https://www.acmicpc.net/problem/2447
별 찍기 - 10
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	33873	17474	12872	51.604%
문제
재귀적인 패턴으로 별을 찍어 보자. N이 3의 거듭제곱(3, 9, 27, ...)이라고 할 때, 크기 N의 패턴은 N×N 정사각형 모양이다.

크기 3의 패턴은 가운데에 공백이 있고, 가운데를 제외한 모든 칸에 별이 하나씩 있는 패턴이다.

***
* *
***
N이 3보다 클 경우, 크기 N의 패턴은 공백으로 채워진 가운데의 (N/3)×(N/3) 정사각형을 크기 N/3의 패턴으로 둘러싼 형태이다. 예를 들어 크기 27의 패턴은 예제 출력 1과 같다.

입력
첫째 줄에 N이 주어진다. N은 3의 거듭제곱이다. 즉 어떤 정수 k에 대해 N=3k이며, 이때 1 ≤ k < 8이다.

출력
첫째 줄부터 N번째 줄까지 별을 출력한다.


sol.
기본 패턴 3 * 3 칸 , N 은 3의 제곱수
N = 9 지수 2
3*3 기준  1.1 좌표가 빔
1) 기준좌표 0,0 을 중심으로 패턴 정중앙 1,1 빔
2) 기준좌표 0,3 을 중심으로 패턴 정중앙 1,4 빔
3) 기준좌표 0,6 을 중심으로 패턴 정중앙 1,7 빔
4) 기준좌표 3,0 을 중심으로 패턴 정중앙 4,1 빔
5) 기준좌표 3,3 을 중심으로 패턴 정중앙 4,4 포함 전구간 빔
3,3 / 3,4 / 3,5
4,3 / 4,4 / 4,5
5,3 / 5,4 / 5,5

기준좌표 N,M이 존재할 때 나타나는 패턴
1. N,M 이 3의 제곱수 인경우 패턴 자체가 빔


구하는방법
출력이 패턴을 찍어야하므로 별을 다찍고 중앙을 삭제하는 방식이 좋지않을까

재귀함수 구현

특정좌표를 받을 시, 받은좌표가 /3 으로 나누어 몫이 1이나 0이 될때 까지 재귀


if N = 9

*********
* ** ** *
*********
***   ***
* *   * *
***   ***
*********
* ** ** *
*********

if N = 27

***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
*********         *********
* ** ** *         * ** ** *
*********         *********
***   ***         ***   ***
* *   * *         * *   * *
***   ***         ***   ***
*********         *********
* ** ** *         * ** ** *
*********         *********
***************************
* ** ** ** ** ** ** ** ** *
***************************
***   ******   ******   ***
* *   * ** *   * ** *   * *
***   ******   ******   ***
***************************
* ** ** ** ** ** ** ** ** *
***************************
 */


import java.util.Arrays;
import java.util.Scanner;

public class BJ_2447 {


    public static void main(String[] args) {
        BJ_2447 test = new BJ_2447();
    }

    public BJ_2447() {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        solution(N);
    }


    public void solution(int N) {
        int mul = multi(N);
        char[][] arr = new char[N][N];
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                {

                    arr[i][j] = '*';
                }

            }
        }
        makeBlock(arr, N, 0, 0);

        for (int i = 0 ; i < N ;i ++){
            for (int j = 0 ; j < N ; j++){

                stringBuilder.append(arr[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }



    //공백 블록을 그릴 재귀함수
    //탈출조건 : 공백을 그리거나, 혹은 3*3 최소 블록을 만나면 아웃
    public void makeBlock(char[][] arr, int N, int cord_y, int cord_x) {
        int mult = multi(N);
        int range = (int) Math.pow(3, mult - 1);

        // 3 * 3 일때
        if (N ==3) {
            arr[cord_y + 1][cord_x + 1] = ' ';
        } else {
            //아직 큰 블럭일 때 9 개로 쪼개어 1개씩 접근함
            for (int i = cord_y; i < N + cord_y; i = i + range) {
                for (int j = cord_x; j < N + cord_x; j = j + range) {

                    if(arr[i][j]==' '){
                        continue;
                    }

                    // 타겟 블럭일 때
                    if (i == (range+ cord_y) && j ==( range+ cord_x)) {
                        for (int k = i; k < i + range; k++) {
                            for (int r = j; r < j + range; r++) {
                                arr[k][r] = ' ';
                            }
                        }
                    }else{
                        //타겟 블록이 아닐 때 쪼개야함

                        makeBlock(arr, Math.floorDiv(N, 3), i, j);


                    }
                }
            }

        }
    }


    public int multi(int N) {
        int cnt = 1;
        while (N / 3 != 1) {
            N = N / 3;
            cnt++;
        }
        return cnt;
    }


}
