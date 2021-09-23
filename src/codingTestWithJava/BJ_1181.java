package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 8m34s
 */

/*
https://www.acmicpc.net/problem/1181
단어 정렬
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	62735	25690	19113	40.243%
문제
알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.

길이가 짧은 것부터
길이가 같으면 사전 순으로
입력
첫째 줄에 단어의 개수 N이 주어진다. (1 ≤ N ≤ 20,000) 둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다. 주어지는 문자열의 길이는 50을 넘지 않는다.

출력
조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.

sol
다음 조건으로 정렬
1. 길이가 짧은 것
2. 길이가 짧은 것이 같이 있다면 사전순으로 단 중복은 안됨

HashMap 사용 -- 33min 결과 실패

배열과 Array list 사용 - 시간 안잼

resutl

 */
import java.util.*;

public class BJ_1181 {
    public static void main(String[] args) {
        BJ_1181 test = new BJ_1181();
    }

    public BJ_1181() {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        //입력
        int tc = sc.nextInt();
        String[] data = new String[tc];
        //개행문자 제거
        sc.nextLine();


        //입력
        for (int i = 0; i < tc; i++) {
            data[i] =sc.nextLine();
        }

        ArrayList<String> answers = new ArrayList<>();
        for (String str : data){
            if(answers.contains(str)){
                continue;
            }else{
                answers.add(str);
            }

        }

        //익명클래스를 이용
        answers.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //같으면
                if (o1.length() == o2.length()){
                    //자연비교(사전순)
                    return o1.compareTo(o2);
                }else{
                    //글자수가 적은 원소가 나올 수 있게 조절
                    if (o1.length() < o2.length()){
                        return -1;
                    }else{
                        return 1;
                    }

                }

            }
        });

        for (String answer : answers){
            sb.append(answer+"\n");
        }

        System.out.println(sb);
    }

}

