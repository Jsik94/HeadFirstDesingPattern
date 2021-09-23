package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/8958

OX퀴즈 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	102896	51618	43595	51.009%
문제
"OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다. 문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.

"OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다.

OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.

출력
각 테스트 케이스마다 점수를 출력한다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_8958 {
    public static void main(String[] args) throws IOException {
        BJ_8958 test = new BJ_8958();
    }

    public BJ_8958() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().toString());
        String[] data = new String[tc];

        for (int i = 0; i < tc; i++){
            data[i] = br.readLine();
        }

        int[] answers = solution(data);

        for (int result : answers){
            System.out.println(result);
        }

    }

    public int[] solution(String[] data) {
        int[] answers = new int[data.length];

        for (int i = 0 ; i < data.length ; i++){
            int score = 0;
            int result = 0 ;
            for(char ch : data[i].toCharArray()){

                if( ch == 'O'){
                    //맞을 때 누적
                    score +=1;
                }else{
                    //실패하면 초기화
                    score = 0;
                }

                result += score;
            }

            answers[i] = result;
        }
        return answers;
    }


}
