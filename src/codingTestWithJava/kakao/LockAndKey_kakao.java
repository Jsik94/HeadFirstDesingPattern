package codingTestWithJava.kakao;

public class LockAndKey_kakao {

    public static void main(String[] args) {
        LockAndKey_kakao test = new LockAndKey_kakao();

        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        test.solution(key, lock);

    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int M = key.length;
        int N = lock.length;
        int[][] extend_loc = null;


//        for (int[] rows : extend_loc) {
//            for (int atom : rows) {
//                System.out.print(atom + " ");
//            }
//            System.out.println();
//        }

        int[] rots = {0, 90, 180, 270};

        for (int row = 0; row < N + 2 * (M - 1); row++) {
            for (int col = 0; col < N + 2 * (M - 1); col++) {

                for (int rot : rots){
                    rotate(key,rot);

                    System.out.println("검사"+row+"- "+col);

                    if(makeSet(key, lock, row, col)){
                        return true;
                    }
                }

            }
        }


        return answer;
    }


    public boolean makeSet(int[][] key, int[][] lock, int r, int c) {
        int M = key.length;
        int N = lock.length;
        int[][] extend_loc = new int[N + 2 * (M - 1)][N + 2 * (M - 1)];
        boolean result = true;

        for (int row = 0; row < extend_loc.length; row++) {
            for (int col = 0; col < extend_loc[row].length; col++) {

                //lock 바운더리
                if ((row >= M - 1 && row < extend_loc.length - (M - 1)) && (col >= M - 1 && col < extend_loc.length - (M - 1))) {
                    extend_loc[row][col] = lock[row - (M - 1)][col - (M - 1)];

                    if ((row >= r && row <= M + r - 1) && (col >= c && col <= M + c - 1)) {

                        if(!(extend_loc[row][col] ==key[row - r][col - c] )){
                            extend_loc[row][col] = 1;
                        }else{
                            extend_loc[row][col] = 0;
                        }
                    }
                    //lock 바운더리
                    if (extend_loc[row][col] != 1) {
                        return false;
                    }

                }

            }
        }

        return result;
    }


    //key와 extend_lock이 존재하고 , 해당 키가 x,y 에 존재할때, 확인하는 함수 
    public boolean isComplete(int[][] extend_loc, int M) {
//        int M = key.length;
//        int row_max = y+M-1;
//        int col_max = x+M-1;
        boolean result = true;

        for (int row = M - 1; row < extend_loc.length - (M - 1); row++) {
            for (int col = M - 1; col < extend_loc.length - (M - 1); col++) {

                //lock 바운더리
                if (extend_loc[row][col] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate(int[][] arr, int degree) {
        int[][] rotate;
        int n = arr.length;
        int m = arr[0].length;

        switch (degree) {
            case 0:
                return arr;
            case 90:
            case 270:
                rotate = new int[m][n];
                break;
            case 180:
                rotate = new int[n][m];
                break;
            default:
                throw new IllegalArgumentException();
        }

        for (int i = 0; i < rotate.length; i++) {
            for (int j = 0; j < rotate[i].length; j++) {
                switch (degree) {
                    case 90:
                        rotate[i][j] = arr[n - 1 - j][i];
                        break;
                    case 180:
                        rotate[i][j] = arr[n - 1 - i][m - 1 - j];
                        break;
                    case 270:
                        rotate[i][j] = arr[j][m - 1 - i];
                        break;
                }
            }
        }

        return rotate;
    }
}
