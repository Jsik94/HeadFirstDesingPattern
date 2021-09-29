package codingTestWithJava;

/*
Solved.ac class project

class 3

 */

/*
https://www.acmicpc.net/problem/16928
뱀과 사다리 게임
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	512 MB	7313	2760	2064	35.385%
문제
뱀과 사다리 게임을 즐겨 하는 큐브러버는 어느 날 궁금한 점이 생겼다.

주사위를 조작해 내가 원하는 수가 나오게 만들 수 있다면, 최소 몇 번만에 도착점에 도착할 수 있을까?

게임은 정육면체 주사위를 사용하며, 주사위의 각 면에는 1부터 6까지 수가 하나씩 적혀있다. 게임은 크기가 10×10이고, 총 100개의 칸으로 나누어져 있는 보드판에서 진행된다. 보드판에는 1부터 100까지 수가 하나씩 순서대로 적혀져 있다.

플레이어는 주사위를 굴려 나온 수만큼 이동해야 한다. 예를 들어, 플레이어가 i번 칸에 있고, 주사위를 굴려 나온 수가 4라면, i+4번 칸으로 이동해야 한다. 만약 주사위를 굴린 결과가 100번 칸을 넘어간다면 이동할 수 없다. 도착한 칸이 사다리면, 사다리를 타고 위로 올라간다. 뱀이 있는 칸에 도착하면, 뱀을 따라서 내려가게 된다. 즉, 사다리를 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 크고, 뱀을 이용해 이동한 칸의 번호는 원래 있던 칸의 번호보다 작아진다.

게임의 목표는 1번 칸에서 시작해서 100번 칸에 도착하는 것이다.

게임판의 상태가 주어졌을 때, 100번 칸에 도착하기 위해 주사위를 굴려야 하는 횟수의 최솟값을 구해보자.

입력
첫째 줄에 게임판에 있는 사다리의 수 N(1 ≤ N ≤ 15)과 뱀의 수 M(1 ≤ M ≤ 15)이 주어진다.

둘째 줄부터 N개의 줄에는 사다리의 정보를 의미하는 x, y (x < y)가 주어진다. x번 칸에 도착하면, y번 칸으로 이동한다는 의미이다.

다음 M개의 줄에는 뱀의 정보를 의미하는 u, v (u > v)가 주어진다. u번 칸에 도착하면, v번 칸으로 이동한다는 의미이다.

1번 칸과 100번 칸은 뱀과 사다리의 시작 또는 끝이 아니다. 모든 칸은 최대 하나의 사다리 또는 뱀을 가지고 있으며, 동시에 두 가지를 모두 가지고 있는 경우는 없다. 항상 100번 칸에 도착할 수 있는 입력만 주어진다.

출력
100번 칸에 도착하기 위해 주사위를 최소 몇 번 굴려야 하는지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16928 {
    public static void main(String[] args) throws IOException {
        BJ_16928 test = new BJ_16928();

    }

    public BJ_16928() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        Map<Integer, Integer> ladder = new HashMap<>();
        Map<Integer, Integer> snake = new HashMap<>();

        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine(), " ");

            ladder.put(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            snake.put(Integer.parseInt(stk.nextToken()), Integer.parseInt(stk.nextToken()));
        }


        System.out.println(solution(ladder, snake));

    }

    private int solution(Map<Integer, Integer> ladder, Map<Integer, Integer> snake) {

        int[] field = new int[101];
        Arrays.fill(field, Integer.MAX_VALUE);
        //param : cur_loc , move_cnt
        Queue<IntPair> queue = new LinkedList<>();
        queue.add(new IntPair(1, 0));
        field[1] = 0;

        while (!queue.isEmpty()) {

            IntPair cur_info = queue.poll();
            System.out.println("현재 위치 : \t" + cur_info.left + "\t cnt :" + cur_info.right);
            if (cur_info.left == 100) {
                break;
            }

            int move_cnt = cur_info.right + 1;

            for (int i = 6; i > 0; i--) {
                int next_cur = cur_info.left;
                next_cur += i;
                if (next_cur > 100) {
                    continue;
                }
                if (snake.containsKey(next_cur)) {
                    next_cur = snake.get(next_cur);
                }

                //사다리를 탈 수 있다면 탄 위치로
                else if (ladder.containsKey(next_cur)) {
                    next_cur = ladder.get(next_cur);
                }

                //해당 필드에 있는 값보다 지금값이 더 작을때만 작동
                if (field[next_cur] > move_cnt) {
                    field[next_cur] = move_cnt;
                    queue.add(new IntPair(next_cur, move_cnt));
                }

            }
        }


        return field[100];
    }


    class IntPair {
        Integer left;
        Integer right;

        public IntPair(Integer left, Integer right) {
            this.left = left;
            this.right = right;
        }
    }

}
