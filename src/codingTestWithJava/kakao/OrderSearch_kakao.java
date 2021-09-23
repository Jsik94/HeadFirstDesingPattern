package codingTestWithJava.kakao;


import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderSearch_kakao {

    public static void main(String[] args) {
        OrderSearch_kakao test = new OrderSearch_kakao();
    }

    public OrderSearch_kakao() {
        int[] answer= solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"});

                for (int ans : answer) {
            System.out.println(ans);
        }
    }


    public int[] solution(String[] info, String[] query) {
        StringTokenizer stk;

        Applicant[] info_arr = new Applicant[info.length];

        int[] answer = new int[query.length];

        for (int i = 0; i < info_arr.length; i++) {

            stk = new StringTokenizer(info[i], " ");
            info_arr[i] = new Applicant(stk.nextToken(), stk.nextToken(), stk.nextToken(), stk.nextToken(), Integer.parseInt(stk.nextToken()));
            //System.out.println(info_arr[i].toString());
        }

        Arrays.sort(info_arr, new Comparator<Applicant>() {
            @Override
            public int compare(Applicant o1, Applicant o2) {
                if(o1.score > o2.score){
                 return 1;
                }
                return -1;
            }
        });

        for (int i = 0; i < query.length; i++) {

            Matcher mt = Pattern.compile("(.+)and(.+)and(.+)and(.+)\\s(.+)").matcher(query[i]);
            Applicant standard = null;
            if (mt.matches()) {
                String lan = mt.group(1).trim();
                String position = mt.group(2).trim();
                String exp = mt.group(3).trim();
                String soul_food = mt.group(4).trim();
                int score = Integer.parseInt(mt.group(5).trim());
                standard = new Applicant(lan, position, exp, soul_food, score);
            }
            int cnt =0;
            int target = 0;
            int start = 0;
            int end = info_arr.length-1;
            while(true){
                int mid = (start+end)/2;

                if (start>=end){
                    target =mid;
                    break;
                }

                if(info_arr[mid].score == standard.score){
                    target = mid;
                    break;
                }else if (info_arr[mid].score > standard.score){
                    end = mid -1;
                }else{
                    start = mid +1;
                }

            }
            for (int k = target ; k < info_arr.length;k++){
                if(info_arr[k].matches(standard)){
                    cnt++;
                }
            }


            answer[i] = cnt;
        }




        return answer;
    }


    class Applicant {

        String lan;
        String position;
        String exp;
        String soul_food;
        int score;

        public Applicant(String lan, String position, String exp, String soul_food, int score) {
            this.lan = lan;
            this.position = position;
            this.exp = exp;
            this.soul_food = soul_food;
            this.score = score;
        }


        public boolean matches(Object obj) {
            boolean toggle = false;
            if (obj instanceof Applicant) {

                if (!(lan.equals(((Applicant) obj).lan) || ((Applicant) obj).lan.equals("-"))) {
                    return false;
                }

                if (!(position.equals(((Applicant) obj).position) || ((Applicant) obj).position.equals("-"))) {
                    return false;
                }

                if (!(exp.equals(((Applicant) obj).exp) || ((Applicant) obj).exp.equals("-"))) {
                    return false;
                }

                if (!(soul_food.equals(((Applicant) obj).soul_food) || ((Applicant) obj).soul_food.equals("-"))) {
                    return false;
                }
                if(score < ((Applicant) obj).score){
                    return false;
                }

                toggle = true;
            }

            return toggle;
        }

        @Override
        public String toString() {
            return String.format("%6s %8s %5s %8s %d", lan, position, exp, soul_food, score);
        }
    }

}
