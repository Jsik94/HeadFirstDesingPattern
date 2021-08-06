package codingTestWithJava;


import java.util.Arrays;




public class Programmers_coloringBook {

    private static final int NOWAY = -2983;
    int height;
    int width;
    boolean[][] visits ;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};


    public Programmers_coloringBook(){
        int m =6 , n = 4;
        int[][] pic = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}};
        solution(m,n,pic);
    }


    public int dfs (int[][] pictures,int cur_x,int cur_y,int color,boolean toggle){

//        //Already visited
//        if(visits[cur_x][cur_y]){
//           return NOWAY;
//        }
        int nx,ny ;
        int count = 0 ;
        visits[cur_x][cur_y] = true;

        //인접방향탐색
        for(int i = 0 ; i <dx.length;i++){
            nx = cur_x + dx[i];
            ny = cur_y + dy[i];

            //기본 범위 안
            if ( nx>= 0 && nx <height && ny>= 0 && ny <width){
                //컬러 코드가 같고 방문하지 않은 부분만

            if (pictures[nx][ny] == color && !visits[nx][ny]){
                    count += dfs(pictures,nx,ny,color,false);
                    toggle = true;
                }
            }

        }

        if (toggle){
            return count+1;
        }
        return 1;


    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        height = picture.length;
        width = picture[0].length;
        visits =new boolean[height][width];


        for (int i = 0 ; i < height ; i++){
            for(int j =0 ; j < width;j++){
                // dfs ,but if it was visited ,continue
                if(!visits[i][j] && picture[i][j] !=0){
                    maxSizeOfOneArea= Math.max(dfs(picture,i,j,picture[i][j],true),maxSizeOfOneArea);
                    numberOfArea +=1;
                }

            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
