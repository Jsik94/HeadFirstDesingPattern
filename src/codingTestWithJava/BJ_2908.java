package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/2908
상수 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	56548	38893	34058	69.441%
문제
상근이의 동생 상수는 수학을 정말 못한다. 상수는 숫자를 읽는데 문제가 있다. 이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.

상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다. 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.

두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.

입력
첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다. 두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.

출력
첫째 줄에 상수의 대답을 출력한다.

숫자 자리변환

while{
cnt +=1
}
pow(10,cnt - i)

max값 비교



 */


import java.util.Scanner;

public class BJ_2908 {

    public static void main(String[] args) {
        BJ_2908 test = new BJ_2908();
    }

    public BJ_2908(){
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int answer = solution(num1,num2);
        System.out.println(answer);
    }

    public int solution(int num1, int num2){

        int newN1 = reversed(num1);
        int newN2 = reversed(num2);

        return (newN1 > newN2 ) ? newN1 : newN2;
    }

    //숫자 뒤바꾸는 함수
    public int reversed(int num){
        //인덱스 조정을 위해 초기값 -1
        int cnt = -1;
        int result =0;
        int tmp =num;

        //자릿수 확인
        while(num > 0){
            num = (int)(num / 10);
            cnt+=1;
        }

        //나머지를 이용해 오른쪽 자리부터 숫자를 구하고, cnt를 통해 위치를 맞춰줌
        for (int i = 0 ; i <= cnt ; i++){
            result += (int) ((tmp % 10) * Math.pow(10,cnt-i));
            tmp = (int)(tmp/10);
        }

        return result;
    }

}
