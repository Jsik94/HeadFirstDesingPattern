package codingTestWithJava;

/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/1546

평균 스페셜 저지
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	108753	53398	44879	49.052%
문제
세준이는 기말고사를 망쳤다. 세준이는 점수를 조작해서 집에 가져가기로 했다. 일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다. 그리고 나서 모든 점수를 점수/M*100으로 고쳤다.

예를 들어, 세준이의 최고점이 70이고, 수학점수가 50이었으면 수학점수는 50/70*100이 되어 71.43점이 된다.

세준이의 성적을 위의 방법대로 새로 계산했을 때, 새로운 평균을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 시험 본 과목의 개수 N이 주어진다. 이 값은 1000보다 작거나 같다. 둘째 줄에 세준이의 현재 성적이 주어진다. 이 값은 100보다 작거나 같은 음이 아닌 정수이고, 적어도 하나의 값은 0보다 크다.

출력
첫째 줄에 새로운 평균을 출력한다. 실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.


 */
import java.util.Scanner;


public class BJ_1546 {

    public static void main(String[] args) {
        BJ_1546 test = new BJ_1546();
    }

    public BJ_1546() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] data = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            data[i] = sc.nextInt();
        }

        double answer = solution(data);

        System.out.println(answer);

    }

    public double solution(int[] arr) {
        double answer = 0;
        double[] modified = new double[arr.length];
        double max = -1 ;
        double average = 0;

        for (int i = 0; i < modified.length; i++) {
            if(max < arr[i]){
                max = arr[i];
            }
        }

        for (int i = 0; i < modified.length; i++) {
            modified[i] = arr[i] / max * 100;
            average+= modified[i];
        }

        answer = average / modified.length;




        return answer;
    }

}
