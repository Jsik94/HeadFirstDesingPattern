package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/1152

단어의 개수
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	176791	51161	39941	29.173%
문제
영어 대소문자와 띄어쓰기만으로 이루어진 문자열이 주어진다. 이 문자열에는 몇 개의 단어가 있을까? 이를 구하는 프로그램을 작성하시오. 단, 한 단어가 여러 번 등장하면 등장한 횟수만큼 모두 세어야 한다.

입력
첫 줄에 영어 대소문자와 띄어쓰기로 이루어진 문자열이 주어진다. 이 문자열의 길이는 1,000,000을 넘지 않는다. 단어는 띄어쓰기 한 개로 구분되며, 공백이 연속해서 나오는 경우는 없다. 또한 문자열의 앞과 뒤에는 공백이 있을 수도 있다.

출력
첫째 줄에 단어의 개수를 출력한다.

실패원인
앞의 공백을 지우기위해 메소드를 활용하지 않고 하려했으나 공백이 들어가 답이 없음\
-->근데 공백이라도 일치해야되는거아닌가 싶은데 모르겠네

공백 제거 정규식이거 한번보고

빈문자가 들어가는것도 확인해야됨 그차이에서 시간걸림

tokenizer가 가장 간결한듯

 */


import java.util.Scanner;

public class BJ_1152 {

    public static void main(String[] args) {
        BJ_1152 test = new BJ_1152();
    }

    public BJ_1152(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int answer = solution(str);
        System.out.println(answer);
    }

    public int solution(String str){
        int cnt = 0;

        if(str.isEmpty() || str.isBlank()){

            return 0;
        }

        //연속된 공백을 하나로 치환
        str = str.replaceAll("\\s+"," ");
        //앞뒤 공백제거
        str = str.trim();

        String[] words= str.split(" ");

        cnt = words.length;

        return cnt;
    }
}
