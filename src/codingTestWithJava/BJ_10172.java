package codingTestWithJava;
/*
Solved.ac class project

class 1

 */

/*
https://www.acmicpc.net/problem/10171
고양이 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	236016	74854	65500	34.247%
문제
아래 예제와 같이 고양이를 출력하시오.

입력
없음.

출력
고양이를 출력한다.

 */

public class BJ_10172 {

    public static void main(String[] args) {
        BJ_10172 test = new BJ_10172();
    }

    public BJ_10172(){
        solution();
    }

    public void solution(){
        StringBuilder sb = new StringBuilder();
        sb.append("|\\_/|\n");
        sb.append("|q p|   /}\n");
        sb.append("( 0 )\"\"\"\\\n");
        sb.append("|\"^\"`    |\n");
        sb.append("||_/=\\\\__|");
        System.out.println(sb);
    }
}
