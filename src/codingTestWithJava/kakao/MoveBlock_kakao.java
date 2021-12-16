package codingTestWithJava.kakao;

import java.util.LinkedList;
import java.util.Queue;

public class MoveBlock_kakao {

    public static void main(String[] args) {
        MoveBlock_kakao test = new MoveBlock_kakao();

    }

    public MoveBlock_kakao() {

    }

    boolean[][][] visited;
    int[][] ways = {{1,0},{-1,0},{0,1},{0,-1}};


    public int solution(int[][] board) {
        int answer = 0;
        //가로세로확인 ㅅㅂ ㅈ같넴ㄴㅇ림낭러ㅣ
        visited = new boolean[board.length][board.length][2];

        Queue<Robot> queue = new LinkedList<>();

        queue.add(new Robot(new Cord(0,0),new Cord(0,1),0,0));

        while (!queue.isEmpty()){

            Robot cur = queue.poll();
            //조건 tail이든 heaer 든 n-1,n-1 좌표면 끝

            if (!isMovable(cur,board)) continue;
            if (isEnd(cur,board)){
                answer = cur.latency;
                break;
            }

            visited[cur.tail.x][cur.tail.y][0] = true;
            visited[cur.header.x][cur.header.y][1] = true;

            for (int i = 0 ; i < ways.length ; i++){
                Cord n_tail,n_header;
                n_tail = new Cord(cur.tail.x+ways[i][0],cur.tail.y+ways[i][1]);
                n_header = new Cord(cur.tail.x+ways[i][0],cur.tail.y+ways[i][1]);
                queue.add(new Robot(n_header,n_tail,cur.isVertical,cur.latency+1));
            }

            //세로일때
            if (cur.isVertical ==1){
                //대각선
                if(cur.header.y -1 >=0  && board[cur.header.x][cur.header.y-1] ==0
                && board[cur.tail.x][cur.tail.y-1] ==0){
                    queue.offer(new Robot(cur.header, new Cord(cur.header.x,cur.header.y-1),0, cur.latency+1));
                    queue.offer(new Robot(cur.tail, new Cord(cur.tail.x,cur.tail.y-1),0, cur.latency+1));
                }
                if(cur.header.y +1 <board.length  && board[cur.header.x][cur.header.y+1] ==0
                        && board[cur.tail.x][cur.tail.y+1] ==0){
                    queue.offer(new Robot(cur.header, new Cord(cur.header.x,cur.header.y+1),0, cur.latency+1));
                    queue.offer(new Robot(cur.tail, new Cord(cur.tail.x,cur.tail.y+1),0, cur.latency+1));
                }

            }else{
                //대각선
                if(cur.header.x -1 >=0  && board[cur.header.x-1][cur.header.y] ==0
                        && board[cur.tail.x][cur.tail.y-1] ==0){
                    queue.offer(new Robot(cur.header, new Cord(cur.header.x-1,cur.header.y),1, cur.latency+1));
                    queue.offer(new Robot(cur.tail, new Cord(cur.tail.x-1,cur.tail.y),1, cur.latency+1));
                }
                if(cur.header.x +1 <board.length  && board[cur.header.x][cur.header.y+1] ==0
                        && board[cur.tail.x][cur.tail.y+1] ==0){
                    queue.offer(new Robot(cur.header, new Cord(cur.header.x+1,cur.header.y),1, cur.latency+1));
                    queue.offer(new Robot(cur.tail, new Cord(cur.tail.x+1,cur.tail.y),1, cur.latency+1));
                }


            }



        }

        return answer;
    }

    //이동가능 범위의 기준 board 내부
    public boolean isMovable(Robot robot, int[][] board){

        if(0<= robot.tail.x && robot.tail.x <board.length &&0<= robot.tail.y && robot.tail.y <board.length
        && 0<= robot.header.x && robot.header.x <board.length && 0<= robot.header.y && robot.header.y <board.length
        &&board[robot.tail.x][robot.tail.y] ==0&& board[robot.header.x][robot.header.y] ==0){
            return true;
        }

        return false;
    }


    public boolean isEnd(Robot robot,int[][] board){
        if(robot.tail.x ==board.length-1 &&robot.tail.y ==board.length-1
                &&  robot.header.x ==board.length-1 &&  robot.header.y ==board.length-1){
            return true;
        }

        return false;
    }


    //필요한 객체
    class Cord{
        int x,y;

        public Cord(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    class Robot{
        Cord header,tail;
        int isVertical;
        int latency;

        public Robot(Cord header, Cord tail, int isVertical, int latency) {
            this.header = header;
            this.tail = tail;
            this.isVertical = isVertical;
            this.latency = latency;
        }
    }
}
