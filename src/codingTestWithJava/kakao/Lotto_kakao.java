package codingTestWithJava.kakao;


public class Lotto_kakao {

    public static void main(String[] args) {

        Lotto_kakao lotto = new Lotto_kakao();
    }

    public Lotto_kakao() {

        int[] results = solution(new int[]{44, 1, 0, 0, 31, 25},new int[]{31, 10, 45, 1, 6, 19});

        for (int result : results){
            System.out.println(result);
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer ;

        int zero = 0;
        int min = 0;
        int max ;
        for (int a : lottos) {
            if (a == 0) {
                zero+=1;
                continue;
            }
            for (int i = 0; i < win_nums.length; i++) {


                if (win_nums[i] == a) {
                    min++;
                }
            }
        }

        switch (min){
            case 6:
                min = 1;
                break;
            case 5:
                min = 2;
                break;
            case 4:
                min = 3;
                break;
            case 3:
                min = 4;
                break;
            case 2:
                min = 5;
                break;
            default:
                min = 6;
                break;

        }

        if(min -zero<=0){
            max = 1;
        }else{
            max = min -zero ;
        }

        answer = new int[]{max,min};
        return answer;
    }

}
