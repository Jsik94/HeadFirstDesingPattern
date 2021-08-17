package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/2562

최댓값 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	106119	50276	43648	47.817%
문제
9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓값이 몇 번째 수인지를 구하는 프로그램을 작성하시오.

예를 들어, 서로 다른 9개의 자연수

3, 29, 38, 12, 57, 74, 40, 85, 61

이 주어지면, 이들 중 최댓값은 85이고, 이 값은 8번째 수이다.

입력
첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.

출력
첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다.

 */


import java.util.ArrayList;
import java.util.Scanner;

public class BJ_2562 {

    public static void main(String[] args) {
        BJ_2562 test = new BJ_2562();

    }

    public BJ_2562 (){
        Scanner sc = new Scanner(System.in);
        int[] data =new int[9];
        for (int i = 0 ; i < data.length ; i++){
            data[i] = sc.nextInt();
        }

        int[] answer = solution(data);
        System.out.println(solution(data)[0]);
        System.out.println(solution(data)[1]+1);

    }

//    public char Test1 (){
//
//        return 0;
//    }
//
//
//    public String Test2 (){
//
//        return null;
//    }
//
//    public ArrayList<Integer> Test3 (){
//
//        return null;
//    }


    public int[] solution(int[] arr){
        int[] target = new int[2];

        target[0] = -1;
        target[1] = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if ( target[0] < arr[i]){
                target[0] =arr[i];
                target[1] = i ;
            }

        }

        return target;
    }

}
