package codingTestWithJava.kakao;


/*
 * 오래걸린 원인 : 2차원에서 깊은 복사 및 얕은 복사 차이를 인지못함
 * 주석을 안써놓고 하니 항상 헷갈릴때 디버그해서 고치는 나쁜습관이있음
 * 로직이 더완벽해야함함
*
 */


import java.util.ArrayList;
import java.util.List;

public class BorderRotate_kakao {

    public static void main(String[] args) {
        BorderRotate_kakao test =new BorderRotate_kakao();
    }
    public BorderRotate_kakao() {
        solution(6,6, new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}});

    }

    public int[] solution(int rows, int columns, int[][] queries) {

        List<Integer> list = new ArrayList<>();
        int[][] matrix = new int[rows][columns];

        for(int i= 0 ; i < rows ; i++ ){
            for(int j = 0 ; j < columns ; j++){
                matrix[i][j] = ((i) * columns + j+1);
                System.out.printf("%3d",matrix[i][j]);
            }
            System.out.println();
        }


        //출력용
        for (int i = 0 ; i < queries.length ;i++){

            int[] rotate_cord = queries[i];
            Pair<Integer,Integer>[] vertex = null;
            vertex = extract_vertex(vertex,rotate_cord);
            matrix= rotate(vertex,matrix,list);
        }


        //결과용
        int[] answer = new int[list.size()];
        for(int i = 0 ; i < list.size() ; i++){
            answer[i] = list.get(i);
        }

        return answer;
    }

    private Pair<Integer,Integer>[] extract_vertex(Pair<Integer,Integer>[] vertex, int[] cord ){
        vertex = new Pair[4];
        //위 왼
        vertex[0] = new Pair<>(cord[0], cord[1]);
        //위 오른
        vertex[1] = new Pair<>(cord[0], cord[3]);
        //끝 오른
        vertex[2] = new Pair<>(cord[2], cord[3]);
        //끝 왼
        vertex[3] = new Pair<>(cord[2], cord[1]);

        return vertex;
    }


    //시계방향 1칸식 회전
    private int[][] rotate(Pair<Integer,Integer>[] vertex, int[][] matrix,List<Integer> list){
        int min =10001;
        int[][] copied = new int[matrix.length][matrix[0].length];

        for (int i = 0 ; i < matrix.length ; i++){

            System.arraycopy(matrix[i],0,copied[i],0,matrix[i].length);
        }

        int[][] way = {{0,1},{1,0},{0,-1},{-1,0}};

        int[] range = {vertex[2].right - vertex[0].right, vertex[2].left - vertex[0].left};
        for (int i = 0 ; i < vertex.length;i++){
                int move = range[i%2];

                int row = vertex[i].left-1;
                int col = vertex[i].right-1;
            while(move>0){
                if(min >matrix[row][col] ){
                    min = matrix[row][col];
                }
                System.out.println("Copied Cord : "+(row+way[i][0])+", "+(col+way[i][1])+" value : "+   matrix[row][col]);
                int data =matrix[row][col];
                copied[row+way[i][0]][col+way[i][1]] = data;
                System.out.println("Result - "+ copied[row+way[i][0]][col+way[i][1]] );
                row += way[i][0];
                col += way[i][1];
                move--;
            }

        }

        list.add(min);
        return  copied;
    }

    public class Pair<L,R>{
        private L left;
        private R right;
        public Pair(L left, R right){
            this.left = left;
            this.right = right;
        }

        public Pair() {

        }

    }


//    class TestSet{
//        public int row;
//        public int col;
//        public int[][] queries;
//
//        public TestSet(int selector) {
//            int[] rows = {6,3,100};
//            int[] cols = {6,3,98};
//            int[][][] queries = {{{1,1,2,2},{3,3,6,6},{5,1,6,3}},
//                    {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}},
//                    {{1,1,100,97}}};
//
//            this(rows[selector],cols[selector],queries[selector]);
//        }
//
//        public TestSet(int row, int col, int[][] queries) {
//            this.row = row;
//            this.col = col;
//            this.queries = queries;
//        }
//
//
//
//    }
}


