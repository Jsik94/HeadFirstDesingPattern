package codingTestWithJava;

/*
Solved.ac class project

class 2

 */

/*
https://www.acmicpc.net/problem/11866

요세푸스 문제 0
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	23807	13587	11629	57.864%
문제
요세푸스 문제는 다음과 같다.

1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다. 이제 순서대로 K번째 사람을 제거한다. 한 사람이 제거되면 남은 사람들로 이루어진 원을 따라 이 과정을 계속해 나간다. 이 과정은 N명의 사람이 모두 제거될 때까지 계속된다. 원에서 사람들이 제거되는 순서를 (N, K)-요세푸스 순열이라고 한다. 예를 들어 (7, 3)-요세푸스 순열은 <3, 6, 2, 7, 5, 1, 4>이다.

N과 K가 주어지면 (N, K)-요세푸스 순열을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 빈 칸을 사이에 두고 순서대로 주어진다. (1 ≤ K ≤ N ≤ 1,000)

출력
예제와 같이 요세푸스 순열을 출력한다.

 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class BJ_11866 {

    public static void main(String[] args) throws IOException {
        BJ_11866 test =new BJ_11866();
    }

    public BJ_11866() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        String[] data = br.readLine().split(" ");
        int N = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);
        int[] answers = solution(N,K);



        //출력형식
        sb.append("<");
        for (int i = 0 ; i < N ; i++){
            sb.append(answers[i]);
            if(i !=N-1) {
                sb.append(", ");
            }

        }
        sb.append(">");
        System.out.println(sb);
    }

    public int[] solution (int N, int K){

        //결과 값에 저장할 위치 저장용 인덱서, 결과값 저장배열
        int k =0;
        int[] results = new int[N];


        // ArrayList의 현재위치를 기억할 인덱서, 원탁테이블 리스트
        int indexor = 0;
        ArrayList<Integer> circle_table = new ArrayList<>();
        //초기화
        for (int i = 0 ; i <N; i++){
            circle_table.add(i+1);
        }

        //현재 원탁에 앉은 사람 수
        int cur_len = circle_table.size();

        //모든 인원이 빠질때까지 요세푸스 로직 수행
        while (cur_len>0){
            //현재위치로 부터 k번째인 사람
            indexor+=(K-1);

//            //인덱서가 현재 원탁 사람수를 초과한다면,원형으므로 순환하게됨
//            //순환이 끝날때까지 뺀다
//            while (indexor >= cur_len){
//                indexor-=cur_len;
//            }
            if(indexor >= cur_len){
                indexor%=cur_len;
            }


            //빠진 인원을 결과 배열에 저장
            results[k++]= circle_table.remove(indexor);

            //원탁 인원수 줄임
            cur_len -=1;

        }

        return results;
    }

    public int[] solution2 (int N, int K){

        //결과 값에 저장할 위치 저장용 인덱서, 결과값 저장배열
        int k =0;
        int[] results = new int[N];


        // ArrayList의 현재위치를 기억할 인덱서, 원탁테이블 리스트
        int indexor = 0;

        ArrayList<Integer> circle_table = new ArrayList<>();
        //초기화
        for (int i = 0 ; i <N; i++){
            circle_table.add(i+1);
        }

        //현재 원탁에 앉은 사람 수
        int cur_len = circle_table.size();

        //모든 인원이 빠질때까지 요세푸스 로직 수행
        while (cur_len>0){
            //현재위치로 부터 k번째인 사람
            indexor+=(K-1);

//            //인덱서가 현재 원탁 사람수를 초과한다면,원형으므로 순환하게됨
//            //순환이 끝날때까지 뺀다
//            while (indexor >= cur_len){
//                indexor-=cur_len;
//            }
            if(indexor >= cur_len){
                indexor%=cur_len;
            }


            //빠진 인원을 결과 배열에 저장
            results[k++]= circle_table.remove(indexor);

            //원탁 인원수 줄임
            cur_len -=1;

        }

        return results;
    }
}
