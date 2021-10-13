package codingTestWithJava;

/*
Solved.ac class project

class 3

latency
 */
/*
https://www.acmicpc.net/problem/16236
아기 상어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	512 MB	34122	15040	8646	40.430%
문제
N×N 크기의 공간에 물고기 M마리와 아기 상어 1마리가 있다. 공간은 1×1 크기의 정사각형 칸으로 나누어져 있다. 한 칸에는 물고기가 최대 1마리 존재한다.

아기 상어와 물고기는 모두 크기를 가지고 있고, 이 크기는 자연수이다. 가장 처음에 아기 상어의 크기는 2이고, 아기 상어는 1초에 상하좌우로 인접한 한 칸씩 이동한다.

아기 상어는 자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없고, 나머지 칸은 모두 지나갈 수 있다. 아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다. 따라서, 크기가 같은 물고기는 먹을 수 없지만, 그 물고기가 있는 칸은 지나갈 수 있다.

아기 상어가 어디로 이동할지 결정하는 방법은 아래와 같다.

더 이상 먹을 수 있는 물고기가 공간에 없다면 아기 상어는 엄마 상어에게 도움을 요청한다.
먹을 수 있는 물고기가 1마리라면, 그 물고기를 먹으러 간다.
먹을 수 있는 물고기가 1마리보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리는 아기 상어가 있는 칸에서 물고기가 있는 칸으로 이동할 때, 지나야하는 칸의 개수의 최솟값이다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 그러한 물고기가 여러마리라면, 가장 왼쪽에 있는 물고기를 먹는다.
아기 상어의 이동은 1초 걸리고, 물고기를 먹는데 걸리는 시간은 없다고 가정한다. 즉, 아기 상어가 먹을 수 있는 물고기가 있는 칸으로 이동했다면, 이동과 동시에 물고기를 먹는다. 물고기를 먹으면, 그 칸은 빈 칸이 된다.

아기 상어는 자신의 크기와 같은 수의 물고기를 먹을 때 마다 크기가 1 증가한다. 예를 들어, 크기가 2인 아기 상어는 물고기를 2마리 먹으면 크기가 3이 된다.

공간의 상태가 주어졌을 때, 아기 상어가 몇 초 동안 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에 공간의 상태가 주어진다. 공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.

출력
첫째 줄에 아기 상어가 엄마 상어에게 도움을 요청하지 않고 물고기를 잡아먹을 수 있는 시간을 출력한다.


1. bfs 를 통해 같은 depths 중에서 작은 물고기를 발견했다면, 해당 depths 에서 stop. but 해당 depths 에서 여러개의 작은 물고기를 발견시 x1 <x1 , y1 <y2 조건에 따라 변경
해당 depth가 곧 해당 경로까지의 time임

2. 위를 통해 상어가 해당위치로 옮겨 갔다면,
    해당 위치는 일단 0 으로 바뀌고
    상어는 하나를 먹은 상태이며,
    해당 위치를 기준으로 다시 1번을 수행한다.

3. 1~2번 루프의 종결조건은 자기 자신보다 작은 물고기가 없어질때임


 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_16236 {

    public static void main(String[] args) throws IOException {
        BJ_16236 test = new BJ_16236();
    }

    public BJ_16236() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        Pair shark_loc = null;
        int shark_size = 2;
        for (int i = 0; i < arr.length; i++) {
            String[] rows = br.readLine().split(" ");
            for (int j = 0; j < arr[i].length; j++) {
                if (rows[j].equals("9")) {
                    shark_loc = new Pair(i, j);
                }
                arr[i][j] = Integer.parseInt(rows[j]);
            }
        }

        int result = solution(shark_size, shark_loc, arr);
        System.out.println(result);

    }

    private int solution(int shark_size, Pair shark_loc, int[][] arr) {

        int[][] ways = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int time = 0;
        int eat_cnt = 0;
        while (true) {


            Queue<Pair> queue = new LinkedList<>();
            queue.add(shark_loc);
            boolean[][] visit = new boolean[arr.length][arr.length];

            //현재 상어위치 저장
            visit[queue.peek().x][queue.peek().y] = true;

          //  System.out.println("현재 상어 위치 : " + shark_loc.x + " , " + shark_loc.y);
            List<Pair> fish_list = new ArrayList<>();
            //먹을 수 있는 물고기가 존재할 때 depths 제한하기 위한 변수
            int limit = 401;

            while (!queue.isEmpty()) {

                Pair cur_loc = queue.poll();

                for (int i = 0; i < ways.length; i++) {
                    Pair next_loc = new Pair(cur_loc.x + ways[i][0], cur_loc.y + ways[i][1]);


                    //물고기를 찾았을 때, 작동 찾은 depths를 초과하면 out 시킴
                    if(limit < cur_loc.depths){
                        break;
                    }
                    //depths control
                    next_loc.depths = cur_loc.depths + 1;
                    //범위 안에 있고
                    if (0 <= next_loc.x && next_loc.x < arr.length && 0 <= next_loc.y && next_loc.y < arr.length) {
                        //방문한적 없으며
                        if (!visit[next_loc.x][next_loc.y]&& arr[next_loc.x][next_loc.y] <= shark_size) {

                            //먹을 수 있는 물고기가 존재한다면 way 순서로 우선순위를 보증하므로 break;
                            //단 그냥 break 걸면 같은 depths의 다른 노드를 제어할 수 없으므로 limit 값 depths로 변경
                            if (arr[next_loc.x][next_loc.y] < shark_size && arr[next_loc.x][next_loc.y] != 0) {
                                fish_list.add(next_loc);
                                visit[next_loc.x][next_loc.y] = true;
                                limit = cur_loc.depths;
                                break;
                            } else  {
                                //이동가능하다면 큐에 넣음
                                queue.add(next_loc);
                                visit[next_loc.x][next_loc.y] = true;

                            }

                        }
                    }
                }

            }

            if (fish_list.isEmpty()) {
             //   System.out.println("해당 경로까지 총 " + time + "이 걸림");
                break;
            }

            if (fish_list.size() > 1) {
                //여러개일땐
                Collections.sort(fish_list, (o1, o2) -> {

                        if (o1.x == o2.x) {
                            return o1.y - o2.y;
                        } else {
                            return o1.x - o2.x;
                        }

                });
            }

            /*
                물고기를 잡았다면
                상어가 있던 위치 0으로 변경
                물고기가 있던 위치 9로 변경
                잡아먹기까지 걸린 시간 누적

             */

            Pair loc = fish_list.get(0);
            //System.out.println("현재 타겟 물고기 위치 : " + loc.x + " , " + loc.y + " 크기 : " + arr[loc.x][loc.y]);
            arr[shark_loc.x][shark_loc.y] = 0;
            arr[loc.x][loc.y] = 9;
            time += loc.depths;
            loc.depths = 0;
            shark_loc = loc;

            //System.out.println("해당 경로까지 총 " + time + "이 걸림");

            /*
                레벨업 조건
                상어 레벨만큼 먹었을 때, lv up
                그리고 eat_cnt는 0으로 초기화화
             */
            eat_cnt++;
            if (shark_size == eat_cnt) {
                shark_size += 1;
                eat_cnt = 0;
            }
//            System.out.println("현재 상어 크기 : " + shark_size + "\t-먹은 물고기 수 : " + eat_cnt);
        }


        return time;
    }
//
//    private Pair findFish(int shark_size, Pair shark_loc, List<Pair> fish_list, int[][] arr) {
//        Pair loc = null;
//        int dist = Integer.MAX_VALUE;
//        int get_idx = 0;
//        int idx = -1;
//        for (Pair fish : fish_list) {
//            idx++;
//            if (shark_size <= arr[fish.x][fish.y]) {
//                break;
//            }
//            int compare_dist = (Math.abs(shark_loc.x - fish.x) + Math.abs(shark_loc.y - fish.y));
//            if (dist == compare_dist) {
//                //최소값이 여러개라면
//                if (loc.x > fish.x) {
//                    //위쪽일때 변경
//                    loc = new Pair(fish.x, fish.y);
//                    get_idx = idx;
//                    //심지어 위도 같다면
//                } else if (loc.x == fish.x) {
//                    //왼쪽일 때 이동
//                    if (loc.y > fish.y) {
//                        loc = new Pair(fish.x, fish.y);
//                        get_idx = idx;
//                    }
//                }
//
//            } else if (dist > compare_dist) {
//                //최소값이면 변경
//                dist = compare_dist;
//                loc = new Pair(fish.x, fish.y);
//                get_idx = idx;
//            }
//        }
//
//        fish_list.remove(get_idx);
//        return loc;
//    }


    class Pair {
        int x;
        int y;
        //시간경과용
        int depths = 0;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
