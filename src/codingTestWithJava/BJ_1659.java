package codingTestWithJava;
/*
Solved.ac class project

class 1

 */


/*
https://www.acmicpc.net/problem/1659
수 (Hard) 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	179	65	54	42.520%
문제
음 아닌 정수들로 이루어진 두 개의 집합 S와 T가 있다. S의 원소들과 T의 원소들을 짝지으려고 하는데, 다음과 같은 규칙을 만족하도록 하고 싶다.

S의 임의의 원소 s는 T의 어떤 원소와도 짝지어질 수 있다. 또한 T의 임의의 원소 t도 S의 어떤 원소와도 짝지어질 수 있다.
S의 모든 원소는 적어도 하나의 T의 원소와는 짝지어져야 하고, T의 모든 원소 역시 적어도 하나의 S의 원소와는 짝지어져야 한다.
예를 들어 S={2, 8, 9, 10, 11}, T={0, 3, 4, 6, 7, 11}을 보자. {(2, 0), (2, 3), (2, 4), (8, 6), (9, 7), (10, 11), (11, 11)}은 규칙을 만족하는 경우가 된다. 하지만 {(2, 0), (8, 3), (9, 4), (10, 6), (11, 7)}은 규칙을 만족하는 경우가 아닌데, T의 원소 11이 S의 어떤 원소와도 짝지어지지 않았기 때문이다.

각각의 짝 (a, b)의 비용이란, a와 b의 차이의 절댓값으로 정의된다. 우리는 모든 비용의 합을 최소로 하도록 S의 원소들과 T의 원소들을 짝지으려 한다. 위에서 주어진 S와 T에 대해서는 10이 최소의 비용합이 된다.

S와 T가 주어지면, 모든 비용의 합을 최소로 하도록 S의 원소들과 T의 원소들을 짝지어 주는 프로그램을 작성하시오.

입력
첫째 줄에 S의 원소의 개수와 T의 원소의 개수가 빈 칸을 사이에 두고 주어진다. 둘째 줄에는 S의 원소, 셋째 줄에는 T의 원소가 첫째 줄에 주어진 개수만큼 빈 칸을 사이에 두고 증가하는 순서대로 주어진다. 각 집합의 원소의 크기는 500,000 이하의 자연수이며, 주어지는 수는 0 이상 1,000,000,000 이하의 정수이다.

출력
첫째 줄에 최소의 비용합을 출력한다.

sol
DP로 할 수 있는 일과 DP로 할수 없는 일을 분리해야됨

1.DP로 채울 수 있는 부분을 다 채운다.
DP[s개중 사용된 것에 원소에 대한][t개중 사용된 것] = 지금까지 abs의 합
종결 조건 DP[?][t] 일때 종결
종결 후
s 집합에서 visit[false]이 남아 있는 부분만 전부 추출

2.DP로 못 채운 부분을 모은다
1이 남아있는 부분에 대해 최소 절대 값을 만들 수 있는 t 매핑
(9,7) ,(10 ,11)
3. 중복되는 부분이 있는지 판별
9의 매핑되는 t원소 7은 8,7 이 존재함.
그럼 s원소 8이 7말고 다른 한쌍이 있는지 확인
- 없다면 9,7 그냥추가
- 있다면 t가 7이고 s가 8인 쌍 삭제

 */


import java.util.*;

public class BJ_1659 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sCnt = sc.nextInt();
        int tCnt = sc.nextInt();
        int[] sArr = new int[sCnt];
        boolean[] sVisit = new boolean[sCnt];
        int[] tArr = new int[tCnt];
        HashMap<Integer, ArrayList<Integer>> first_pair = new HashMap<>();
        ArrayList<Pair<Integer, Integer>> add_pair = new ArrayList<>();
        int answer = 0;

        //집합 t를 기준으로 뺄 수 있는거 다 빼자

        for (int i = 0; i < sCnt; i++) {
            sArr[i] = sc.nextInt();
        }

        for (int i = 0; i < tCnt; i++) {
            tArr[i] = sc.nextInt();
        }


        //t기준으로 최소 비용 구함
        for (int t_value : tArr) {
            int min = 1000000000;
            int min_idx = 0;
            //t와 매핑되는 가장작은 s 탐색
            for (int s_value = 0; s_value < sArr.length; s_value++) {
                if (Math.abs(sArr[s_value] - t_value) < min) {
                    min = Math.abs(sArr[s_value] - t_value);
                    min_idx = s_value;
                }
            }
            //그 쌍을 저장하고 사용한 s 집합 확인
            ArrayList<Integer> list = new ArrayList<>();
            //key 가 존재한다면
            if (first_pair.containsKey(sArr[min_idx])) {

                list = first_pair.get(sArr[min_idx]);
                list.add(t_value);
            } else {
                list.add(t_value);
            }
            first_pair.put(sArr[min_idx], list);
            sVisit[min_idx] = true;

        }

        //
        for (int s_value = 0; s_value < sArr.length; s_value++) {
            if (sVisit[s_value] == false) {
                int min = 1000000000;
                int min_idx = 0;
                for (int t_value = 0; t_value < tArr.length; t_value++) {
                    if (Math.abs(sArr[s_value] - tArr[t_value]) < min) {
                        min = Math.abs(sArr[s_value] - tArr[t_value]);
                        min_idx = t_value;
                    }
                }
                add_pair.add(new Pair<>(sArr[s_value], tArr[min_idx]));
                sVisit[s_value] = true;

            } else {
                continue;
            }
        }

        //add Pair에 있는 자료중 right이 있는 쌍의 left 갯수를 채크
        for (Pair<Integer, Integer> a : add_pair) {

            int target = a.getRight();

            Set<Map.Entry<Integer, ArrayList<Integer>>> entrySet = first_pair.entrySet();

            for (Map.Entry<Integer, ArrayList<Integer>> entry : entrySet) {
                //value 리스트를 가져와 그안에 target value 가 있다면, 그것으로 키값 find

                if (entry.getValue().contains(target)) {
                    //해당 키에 값이 여러개 존재한다면
                    if (first_pair.get(entry.getKey()).size() >= 2) {
                        //해당 key 가 가지고있는 value 값 삭제
                        first_pair.get(entry.getKey()).remove(Integer.valueOf(target));

                    }
                }

            }
        }

        Set<Map.Entry<Integer, ArrayList<Integer>>> entrySet = first_pair.entrySet();

        for (Map.Entry<Integer, ArrayList<Integer>> entry : entrySet){
             answer = entry.getKey() * entry.getValue().size();
             for (Integer a : entry.getValue()){
                 answer += a;
             }
        }



        System.out.println(answer);
    }


}








