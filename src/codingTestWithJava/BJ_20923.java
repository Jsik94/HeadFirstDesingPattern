package codingTestWithJava;

/*
Silver 3
 */

/*
숫자 할리갈리 게임 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초 (추가 시간 없음)	1024 MB	917	266	200	28.860%
문제
인간이 가장 심심함을 느낀다는 오후 1시 22분, 도도와 수연이는 숫자 할리 갈리 게임을 하려 한다. 숫자 할리 갈리 게임의 규칙은 다음과 같다.

[숫자 할리 갈리 게임의 규칙]

초기에 도도와 수연이는 각각 N장의 카드로 이루어진 덱을 배분받는다. 게임 시작 시 그라운드는 비어있는 상태이다.
덱은 숫자가 보이지 않게 카드를 뒤집어 쌓아 놓은 카드 더미를 의미한다. 도도와 수연이는 자신의 덱을 가지고 게임을 진행하게 된다.
그라운드는 도도와 수연이가 게임을 진행하며 자신이 가진 덱에서 가장 위에 있는 카드를 내려놓게 되는 땅을 의미한다. 그라운드에 카드를 내려놓을 때는 자신의 그라운드에 카드를 내려놓으며, 그라운드에 카드 더미가 존재할 경우 기존에 만들어진 카드 더미 위로 카드를 내려놓는 방식으로 진행한다.
도도를 시작으로 도도와 수연이가 차례대로 그라운드에 자신이 가진 덱에서 가장 위에 위치한 카드를 그라운드에 숫자가 보이도록 내려놓는다.
종을 먼저 치는 사람이 그라운드에 나와 있는 카드 더미를 모두 가져갈 수 있다. 종을 칠 수 있는 조건은 다음과 같다.
그라운드에 나와 있는 각각의 카드 더미에서 가장 위에 위치한 카드의 숫자 합이 $5$가 되는 순간 수연이가 종을 친다. 단, 어느 쪽의 그라운드도 비어있으면 안된다.

그라운드에 나와 있는 각각의 카드 더미에서 가장 위에 위치한 카드의 숫자가 $5$가 나오는 순간 도도가 종을 친다.

종을 쳤다면, 상대방의 그라운드에 있는 카드 더미를 뒤집어 자신의 덱 아래로 그대로 합친 후 자신의 그라운드에 있는 카드 더미 역시 뒤집어 자신의 덱 아래로 그대로 가져와 합친다.

종을 쳐서 그라운드에 있는 카드 더미를 가져가는 행위는 게임의 진행 순서에 영향을 미치지 않는다.


 $M$번 진행한 후 자신의 덱에 더 많은 카드를 지닌 사람이 승리하고 $M$번 진행 후 각자의 덱에 있는 카드의 개수가 같다면 비긴 것으로 본다. 게임 진행 도중 자신의 덱에 있는 카드의 수가 $0$개가 되는 즉시 상대방이 승리한 것으로 본다. (둘 중 한 명이 2~4번까지의 과정을 진행하는 것을 $1$번 진행한 것으로 본다.)



게임을 $M$번 진행한 후 승리한 사람은 누구일까?

입력
첫째 줄에는 도도와 수연이가 가지는 카드의 개수 $N$($ 1 \leq N \leq 30\,000$)과 게임 진행 횟수 $M$($ 1 \leq M \leq 2\,500\,000$)이 주어진다.

둘째 줄부터 $N$개의 줄에는 띄어쓰기로 구분하여 도도와 수연이가 가진 덱의 맨 아래에 위치한 카드에 적혀 있는 수부터 맨 위에 위치한 카드에 적힌 수까지 차례대로 주어진다. (각각의 카드는 $1$ 이상 $5$ 이하의 자연수가 적혀있다.)

출력
게임을 이긴 사람이 도도라면 do를 출력하고 게임을 이긴 사람이 수연이라면 su를 출력한다. 비겼을 경우, dosu를 출력한다.


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_20923 {

    public static void main(String[] args) throws IOException {
        BJ_20923 test = new BJ_20923();
    }

    public BJ_20923() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");

        int card_cnt = Integer.parseInt(stk.nextToken());
        int game_cnt = Integer.parseInt(stk.nextToken());

        Deque<Integer> do_cards = new LinkedList<>();
        Deque<Integer> su_cards = new LinkedList<>();


        for (int i = 0 ; i < card_cnt ; i++){
            stk = new StringTokenizer(br.readLine()," ");
            do_cards.addFirst(Integer.parseInt(stk.nextToken()));
            su_cards.addFirst(Integer.parseInt(stk.nextToken()));
        }

        System.out.println(solution(do_cards,su_cards,game_cnt));

    }

    private String solution(Deque<Integer> do_cards, Deque<Integer> su_cards, int game_cnt) {
        String result ;
        boolean gameover = false;

        Deque<Integer> do_ground = new LinkedList<>();
        Deque<Integer> su_ground = new LinkedList<>();

        for (int i = 0 ; i < game_cnt ; i++){

            if(do_cards.isEmpty() || su_cards.isEmpty()){
                gameover =true;
                break;
            }
            int cur_do;
            int cur_su;
            //스택의 형태로 빼옴
            if( i %2 ==0){
                cur_do = do_cards.pollFirst();

                do_ground.addLast(cur_do);
                if(do_cards.isEmpty()){
                    gameover =true;
                    break;
                }

                cur_su  = (su_ground.isEmpty()) ? 0 : su_ground.peekLast();
                if(cur_do ==5 || cur_su ==5){
                    //do win case
                    while(!su_ground.isEmpty()){
                        do_cards.addLast(su_ground.pollFirst());
                    }
                    while(!do_ground.isEmpty()){
                        do_cards.addLast(do_ground.pollFirst());
                    }

                }else if(cur_do+cur_su ==5){
                    //su win case
                    while(!do_ground.isEmpty()){
                        su_cards.addLast(do_ground.pollFirst());
                    }
                    while(!su_ground.isEmpty()){
                        su_cards.addLast(su_ground.pollFirst());
                    }
                }else{
                    //no one win



                }



            }else{
                cur_su = su_cards.pollFirst();
                su_ground.addLast(cur_su);
                if(do_cards.isEmpty()){
                    gameover =true;
                    break;
                }
                cur_do = (do_ground.isEmpty()) ? 0 : do_ground.peekLast();
                if(cur_do ==5 || cur_su ==5){
                    //do win case
                    while(!su_ground.isEmpty()){
                        do_cards.addLast(su_ground.pollFirst());
                    }
                    while(!do_ground.isEmpty()){
                        do_cards.addLast(do_ground.pollFirst());
                    }

                }else if(cur_do+cur_su ==5){
                    //su win case
                    while(!do_ground.isEmpty()){
                        su_cards.addLast(do_ground.pollFirst());
                    }
                    while(!su_ground.isEmpty()){
                        su_cards.addLast(su_ground.pollFirst());
                    }
                }else{
                    //no one win

                }

            }

        }


        //중간에 게임이 끝난 경우
        if(gameover){
            if(do_cards.isEmpty()){
                result = "su";
            }else{
                result = "do";
            }
        }else{
            //모든 게임 횟수가 끝나도 승부가 나지 않았다면,
            if(do_cards.size() > su_cards.size()){
                result = "do";
            }else if (do_cards.size() < su_cards.size()){
                result = "su";
            }else{
                result = "dosu";
            }

        }

        return result;
    }
}
