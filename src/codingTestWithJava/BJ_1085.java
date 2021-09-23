package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 8m34s
 */


/*
https://www.acmicpc.net/problem/1085
직사각형에서 탈출
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	41335	23944	21307	58.272%
문제
한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다. 직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 x, y, w, h가 주어진다.

출력
첫째 줄에 문제의 정답을 출력한다.



sol.

x 축 변이나 y 축 변에 접근할 수 있는 최단거리를 구하는게 솔루션
ex 6,2
1)x 축으로 생각했을 떄 0 이나 10에 가까운 값 4
2)y 축으로 생각했을 때 0 나  3에 가까운 값 1


 */


import java.util.Scanner;

public class BJ_1085 {

    public static void main(String[] args) {
        BJ_1085 test = new BJ_1085();
    }

    public BJ_1085(){
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int answer = solution(x,y,w,h);
        System.out.println(answer);

    }

    private int solution(int x, int y, int w, int h) {
        int min = 9999999;

        //  0과 w 사이 중 x와 가까운 거리 저장
        if( Math.abs(x-w) <x){
            min=Math.abs(x-w);
        }else{
            min =x;
        }

        // 0과 h 사이 중 y와 가까운 거리 저장 , but 그것이 현재 min 값보다 작을 때만 저장
        if( (Math.abs(y-h) < y) && Math.abs(y-h) < min  ){
            min = Math.abs(y-h);
        }else if( y < min){
            min= y;
        }

        return min;
    }

}
