package codingTestWithJava;
/*
Solved.ac class project

class 2

latency : 6min 45s
 */


/*
https://www.acmicpc.net/problem/2108
통계학
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	256 MB	56577	14124	11397	26.840%
문제
수를 처리하는 것은 통계학에서 상당히 중요한 일이다. 통계학에서 N개의 수를 대표하는 기본 통계값에는 다음과 같은 것들이 있다. 단, N은 홀수라고 가정하자.

산술평균 : N개의 수들의 합을 N으로 나눈 값
중앙값 : N개의 수들을 증가하는 순서로 나열했을 경우 그 중앙에 위치하는 값
최빈값 : N개의 수들 중 가장 많이 나타나는 값
범위 : N개의 수들 중 최댓값과 최솟값의 차이
N개의 수가 주어졌을 때, 네 가지 기본 통계값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 수의 개수 N(1 ≤ N ≤ 500,000)이 주어진다. 단, N은 홀수이다. 그 다음 N개의 줄에는 정수들이 주어진다. 입력되는 정수의 절댓값은 4,000을 넘지 않는다.

출력
첫째 줄에는 산술평균을 출력한다. 소수점 이하 첫째 자리에서 반올림한 값을 출력한다.

둘째 줄에는 중앙값을 출력한다.

셋째 줄에는 최빈값을 출력한다. 여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.

넷째 줄에는 범위를 출력한다.


sol
산술평균 - double
중앙값 - 모슨 수가 홀수이므로  /2 +1
최빈값 : 여러개있을땐 작은것에서 두번째 수
범위 : 끝 ~ 끝

 */

import java.util.*;

public class BJ_2108 {

    public static void main(String[] args) {
        BJ_2108 test = new BJ_2108();
    }

    public BJ_2108() {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();

        int[] datas = new int[cnt];

        for (int i = 0; i < cnt; i++) {
            datas[i] = sc.nextInt();
        }

        Arrays.sort(datas);
        solution(datas);

    }


    public int[] solution(int[] datas) {
        double sum = 0;
        int avr, median, mode, range;
        int[] result= new int[4];
        LinkedHashMap<Integer,Integer> hashMap = new LinkedHashMap<>();
        for (int data : datas) {
            if(hashMap.isEmpty()){
                hashMap.put(data,1);
            }else if(hashMap.containsKey(data)){
                hashMap.put(data,hashMap.get(data)+1);
            }else{
                hashMap.put(data,1);
            }
            sum += data;
        }

        //산술 평균
        avr = (int)Math.round( sum / datas.length);

        //중앙값
        median = datas[datas.length/2];

        //범위
        range = datas[datas.length-1] - datas[0];

        List<Integer> lst = new ArrayList<>(hashMap.keySet());

        /*
        요구 하는 최빈값 조건
        1순위 - 가장 많은 횟수
        2순위 - 가장 많은 횟수가 두개 이상 이면, 최빈값 중 두 번째로 작은 값
         */

        //데이터가 하나일 땐 하나가 최빈값
        if(datas.length==1){
            mode = datas[0];

        }else{
            //lst 정렬 기준 1차 정렬 - 최빈값 순서
            //2차 정렬 - 최빈값이 같다면 오름차순
            Collections.sort(lst,(o1, o2) -> {
                if(hashMap.get(o1).equals(hashMap.get(o2))){
                    return o1.compareTo(o2) ;
                }else{
                    return hashMap.get(o2).compareTo(hashMap.get(o1));
                }
            });

            PriorityQueue<Integer> queue = new PriorityQueue<>();

            //최빈값이 같은 경우만 우선순위 큐에 넣음
            for (int i = 0; i <lst.size() ; i++){
                if(queue.isEmpty()){
                    queue.offer(lst.get(i));
                }else{
                    if (hashMap.get(queue.peek())>hashMap.get(lst.get(i))){
                        break;
                    }
                    queue.offer(lst.get(i));
                }

            }

            //최빈값이 하나라면 바로 out
            if(queue.size()==1){
                mode = queue.peek();
            }else{
                //최빈값이 여러개라면 두번쨰로 작은 녀석 출력
                queue.poll();
                mode = queue.peek();
            }

        }

        System.out.println(avr);
        System.out.println(median);
        System.out.println(mode);
        System.out.println(range);


        return result;
    }
}
