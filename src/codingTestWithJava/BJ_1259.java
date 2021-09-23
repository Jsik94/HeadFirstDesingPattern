package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 8m34s
 */

/*
https://www.acmicpc.net/problem/1259
팰린드롬수 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	12524	7617	6829	61.834%
문제
어떤 단어를 뒤에서부터 읽어도 똑같다면 그 단어를 팰린드롬이라고 한다. 'radar', 'sees'는 팰린드롬이다.

수도 팰린드롬으로 취급할 수 있다. 수의 숫자들을 뒤에서부터 읽어도 같다면 그 수는 팰린드롬수다. 121, 12421 등은 팰린드롬수다. 123, 1231은 뒤에서부터 읽으면 다르므로 팰린드롬수가 아니다. 또한 10도 팰린드롬수가 아닌데, 앞에 무의미한 0이 올 수 있다면 010이 되어 팰린드롬수로 취급할 수도 있지만, 특별히 이번 문제에서는 무의미한 0이 앞에 올 수 없다고 하자.

입력
입력은 여러 개의 테스트 케이스로 이루어져 있으며, 각 줄마다 1 이상 99999 이하의 정수가 주어진다. 입력의 마지막 줄에는 0이 주어지며, 이 줄은 문제에 포함되지 않는다.

출력
각 줄마다 주어진 수가 팰린드롬수면 'yes', 아니면 'no'를 출력한다.


 */


import java.util.Scanner;

public class BJ_1259 {
    public static void main(String[] args) {
        BJ_1259 test = new BJ_1259();

    }

    public BJ_1259() {
        Scanner sc = new Scanner(System.in);
        //0나오기전까지 무한 반복
        while (true) {
            String number = sc.nextLine();

            //0 혹은 0으로 시작하는 무언가는 모두 out 처리
            if (number.equals("0")||number.charAt(0)=='0') {
                break;
            }
            solution(number);
        }

    }

    public void solution(String number) {
        boolean toggle = true;

            int len = number.length();

        for (int i = 0; i < (len/2); i++) {

            //중앙을 기준으로 대칭인지 문자 마다 확인
            if (number.charAt(i) == number.charAt((len - 1) - i)) {

            } else {
                //하나라도 안되면 자름
                toggle = false;
                break;
            }
        }

        if (toggle) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }


    }


}
