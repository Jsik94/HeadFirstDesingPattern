package codingTestWithJava;
/*
https://www.acmicpc.net/problem/1018
체스판 다시 칠하기 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	44613	20416	16558	46.193%
문제
지민이는 자신의 저택에서 MN개의 단위 정사각형으로 나누어져 있는 M*N 크기의 보드를 찾았다. 어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다. 지민이는 이 보드를 잘라서 8*8 크기의 체스판으로 만들려고 한다.

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8*8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.

sol.

 자르는 기준은 8*8 칸으로 고정
 인접한 칸은 모두 색깔이 반전 되어야 한다
 칸을 정하고 나면 흰 색으로 칠 할때 와 검은 색으로 칠 할때 중 최소로 구한다


 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class BJ_1018 {
    char[][] data;


    public static void main(String[] args) {

        BJ_1018 test = new BJ_1018();
    }

    public BJ_1018() {
        Scanner scanner = new Scanner(System.in);
        int depth = scanner.nextInt(); // 세로
        int width = scanner.nextInt(); // 가로
        data = new char[depth][width];

        scanner.nextLine();
        for (int i = 0; i < depth; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < width; j++) {
                data[i][j] = str.charAt(j);
            }
        }

//        for (char[] a :data){
//            for(char b : a){
//                System.out.print(b);
//            }
//            System.out.println();
//        }
        solution(depth,width);

    }

    public int solution(int depth, int width) {
//        char[][] copy = new char[depth][width];
        int answer = 3000;
//        for (int i = 0; i < depth; i++) {
//            for (int j = 0; j < width; j++) {
//                copy[i][j] = data[i][j];
//            }
//        }


        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < width; j++) {

                if (chessArea(i, j, depth, width)) {

                    answer=Math.min(answer,Math.min(changeCount(data,i,j,0),changeCount(data,i,j,1)));
                }

            }
        }

        System.out.println(answer);
        return answer;
    }

    //8*8
    public boolean chessArea(int y, int x, int depth, int width) {
        if (y + 7 < depth && x + 7 < width) {
            return true;
        }
        return false;
    }

    public char swapChar(char ch) {
        if (ch == 'B') {
            return 'W';
        }
        return 'B';
    }

    public int changeCount(char[][] data, int y, int x, int opt) {
        char[][] tmp = new char[data.length][data[0].length];
        int answer = 3000;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                tmp[i][j] = data[i][j];
            }
        }

        int count = 0;

        if (opt == 1) {
            tmp[y][x] = swapChar(tmp[y][x]);
            count++;
        }

        for (int i = y; i < y + 8; i++) {

            //처음 시작만 비교안함
            //나머지에 대해서는 윗줄 첫 문자와 비교
            if( i != y){
                if(tmp[i-1][x] == tmp[i][x]){
                    tmp[i][x]= swapChar(tmp[i][x]);
                    count++;
                }
            }

            for (int j = x+1; j < x + 8; j++) {
                if(tmp[i][j-1] == tmp[i][j]){
                    tmp[i][j] = swapChar(tmp[i][j]);
                    count++;
                }
            }
        }

        return count;
    }

}


