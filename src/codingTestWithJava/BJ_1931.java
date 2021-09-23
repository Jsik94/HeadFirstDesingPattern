package codingTestWithJava;


/*
Solved.ac class project

class 3

 */
/*
회의실 배정 성공
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	91036	27287	19608	28.987%
문제
한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.

입력
첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 231-1보다 작거나 같은 자연수 또는 0이다.

출력
첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.


 */




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_1931 {

    public static void main(String[] args) throws IOException {
        BJ_1931 test = new BJ_1931();
    }



    public BJ_1931() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int cnt = Integer.parseInt(br.readLine());
        List<MyPair<Integer,Integer>> data = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int first = Integer.parseInt(stk.nextToken());
            int last = Integer.parseInt(stk.nextToken());

            data.add(new MyPair<>(first,last));

        }


        Collections.sort(data, new Comparator<MyPair<Integer, Integer>>() {
            @Override
            public int compare(MyPair<Integer, Integer> o1, MyPair<Integer, Integer> o2) {
                if(o1.right.equals(o2.right)){

                    return o1.left.compareTo(o2.left);
                }

                return o1.right.compareTo(o2.right);
            }
        });
        System.out.println(solution(data));


    }

    private int solution(List<MyPair<Integer,Integer>> datas) {
        int result = 0;
        int time =0;
        for(MyPair<Integer,Integer> data : datas){

            if(time <= data.left){
                time = data.right;
                result++;
            }

        }

        return result;
    }

    public class MyPair<L ,R >{
        L left;
        R right;

        public MyPair(L left, R right) {
            this.left = left;
            this.right = right;
        }


    }

}
