package codingTestWithJava.kakao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DartGame_kakako {

    public static void main(String[] args) {
        DartGame_kakako dart = new DartGame_kakako();
    }

    public DartGame_kakako() {


        System.out.println(solution("1D#2S*3S"));

        //내가 많이 실수한부분
        /*
        1. 정규식표현에서 |는 또는이지만 전체는 아님 그냥 *써야함
        2. 정규식쓸때 Matcher 인스턴스가 matchers를 돌리기전까지 제대로 작동안함
        3. 숫자가 여러개일 수 있기 때문에 char형 자릿수비교는 피했어야함

         */
    }


    public int solution(String dartResult) {
        //정규식으로 1회 2회 3회 다트로 나눔
        Pattern pt = Pattern.compile("([0-9]+[A-Z][\\*,#)]*)([0-9]+[A-Z][\\*,#)]*)([0-9]+[A-Z][\\*,#)]*)");
        Matcher mt = pt.matcher(dartResult);

        //다트 기회는 3번이므로 3값
        int dart_opp = 3;
        mt.matches();
        //1회당 점수 계산 변수
        int[] nums = new int[dart_opp];

        for (int i = 1; i <= dart_opp; i++) {
            String line = mt.group(i);
            //숫자와 지수 구분
            // 고호님 feed back : ([0-9]+)([A-Z])([*,#]?) 정규식 ? 로 표현
            Matcher mt2 = (Pattern.compile("([0-9]+)([A-Z])([*,#]?)").matcher(line));
            mt2.matches();

            //수 입력
            nums[i - 1] = Integer.parseInt(mt2.group(1));
            //지역 변환
            char type = mt2.group(2).charAt(0);
            int mul = 1;

            switch (type) {
                case 'S':
                    mul = 1;
                    break;
                case 'D':
                    mul = 2;
                    break;
                case 'T':
                    mul = 3;
                    break;
            }
            nums[i - 1] = (int) Math.pow(nums[i - 1], mul);

            //보너스가 있는 부분만 계산
            if(line.matches(".+[#,\\*]$")){
                switch (line.toCharArray()[line.length()-1]) {
                    case '#':
                        nums[i - 1] = nums[i - 1] * -1;
                        break;
                    case '*':
                        if (i - 2 >= 0) {
                            nums[i - 2] = nums[i - 2] * 2;
                        }
                        nums[i - 1] = nums[i - 1] * 2;
                        break;
                    default:
                        break;

                }
            }

        }

        int answer = 0;


        //총합
        for (int num : nums) {
            answer += num;
        }

        return answer;
    }


}
