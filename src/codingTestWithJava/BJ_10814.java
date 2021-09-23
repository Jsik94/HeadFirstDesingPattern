package codingTestWithJava;

/*
Solved.ac class project

class 2

 */


/*
https://www.acmicpc.net/problem/10814
나이순 정렬 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
3 초	256 MB	53099	22618	17149	41.913%
문제
온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)

둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 입력은 가입한 순서로 주어진다.

출력
첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_10814 {

    public static void main(String[] args) throws IOException {
        BJ_10814 test = new BJ_10814();
    }


    public BJ_10814() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        ArrayList<int[]> datas = new ArrayList<>();
        String[] names = new String[tc];
        for (int i = 0; i < tc; i++) {
            int[] info =new int[2];
            info[1] = i;
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine()," ");
            info[0] = Integer.parseInt(stringTokenizer.nextToken());
            names[i] = stringTokenizer.nextToken();
            datas.add(info);
        }
        solution(datas,names);

        for (int i = 0 ; i < datas.size() ; i++){
            sb.append(datas.get(i)[0] +" "+ names[datas.get(i)[1]]);
            sb.append("\n");
        }

        System.out.println(sb);
    }


    public void solution(ArrayList<int[]> datas, String[] names) {
        Collections.sort(datas,(o1, o2) -> {
            if(o1[0] == o2[0]){
                return  Integer.compare(o1[1],o2[1]);
            }else{
                return Integer.compare(o1[0],o2[0]);
            }
        });
    }
}
