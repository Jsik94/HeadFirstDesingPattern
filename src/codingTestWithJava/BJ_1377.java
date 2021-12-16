package codingTestWithJava;

/*
https://www.acmicpc.net/problem/1377

버블 소트
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	8346	2146	1725	32.621%
문제
버블 소트 알고리즘을 다음과 같이 C++로 작성했다.

bool changed = false;
for (int i=1; i<=N+1; i++) {
    changed = false;
    for (int j=1; j<=N-i; j++) {
        if (A[j] > A[j+1]) {
            changed = true;
            swap(A[j], A[j+1]);
        }
    }
    if (changed == false) {
        cout << i << '\n';
        break;
    }
}
위 소스에서 N은 배열의 크기이고, A는 정렬해야 하는 배열이다. 배열은 A[1]부터 사용한다.

위와 같은 소스를 실행시켰을 때, 어떤 값이 출력되는지 구해보자.

입력
첫째 줄에 N이 주어진다. N은 500,000보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에 A[1]부터 A[N]까지 하나씩 주어진다. A에 들어있는 수는 1,000,000보다 작거나 같은 자연수 또는 0이다.

출력
정답을 출력한다.


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BJ_1377 {

    public static void main(String[] args) throws IOException {

        String[] data = {"하이","하하이","호이!"};

        String result ="";

        for(String atom : data){
            result+=atom+" ";
        }

        StringTokenizer stk = new StringTokenizer(result," ");

        int i = 1;

        while(stk.hasMoreTokens()){
            System.out.println((i++)+" : "+stk.nextToken());
        }


    }


    public BJ_1377() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        Pair[] A = new Pair[cnt];
        for (int i = 0 ; i < cnt ; i++){
            A[i] = new Pair(Integer.parseInt(br.readLine()),i);
        }
        Arrays.sort(A, Comparator.comparingInt(o -> o.value));

        int max = 0;
        for (int i = 0 ; i < cnt ;i++){

            max = Math.max(max,   A[i].idx -i);
        }
        System.out.println(max+1);

    }



//
//    private void bubbleSort(int[] A) {
//
//        boolean changed = false;
//        for (int i=1; i<=A.length+1; i++) {
//            changed = false;
//            for (int j=1; j<=A.length-i-1; j++) {
//                if (A[j] > A[j+1]) {
//                    changed = true;
//                    int temp = A[j];
//                    A[j] = A[j+1];
//                    A[j+1] = temp;
//                }
//            }
//            if (changed == false) {
//                System.out.println(i);
//                break;
//            }
//        }
//    }



    class Pair{

        int value;
        int idx;

        public Pair(int left, int right) {
            this.value = left;
            this.idx = right;
        }
    }

}
