package codingTestWithJava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ThanksgivingTraffic_kakao {


    public static void main(String[] args) throws ParseException {

        ThanksgivingTraffic_kakao test = new ThanksgivingTraffic_kakao();

        //Test Cases
        String[] lines = new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
//        String[] lines = new String[]{"2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"};
        test.solution(lines);
    }


    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public int solution(String[] lines) throws ParseException {
        int answer = 0;
        StringTokenizer stk;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        List<Info> lists = new ArrayList<>();
        for (String line : lines) {
            stk = new StringTokenizer(line, " ");
            String date = stk.nextToken();
            String time = stk.nextToken();
            String range = stk.nextToken();
            String dateTime = date + " " + time;
            lists.add(new Info(calRange(dateTime, range), calRange(dateTime), range));
        }


        for (int i = 0; i < lists.size(); i++) {
            int tmp = 0;
            long standard = lists.get(i).end;
            for (Info list : lists) {
                if (list.inHere(standard)) {
                    tmp++;
                }
            }
            answer = Math.max(tmp, answer);
        }


        return answer;
    }

    public long calRange(String data) throws ParseException {

        long endTime = sdf.parse(data).getTime();
        return endTime;
    }

    public long calRange(String data, String range) throws ParseException {
        long ran = (long) (Double.parseDouble(range.replace("s", "")) * 1000);
        long endTime = sdf.parse(data).getTime();
        long startTime = endTime - (ran - 1);

        return startTime;
    }

    class Info {
        String date;
        long start;
        long end;
        String range;

        public Info(long start, long end, String range) {
            this.start = start;
            this.end = end;
            this.range = range;
        }

        public boolean inHere(long standard) throws ParseException {
            long stanEnd, stanStart;
            stanStart = standard;
            stanEnd = stanStart + 999;
            if(stanStart > end ||stanEnd < start ){
                return false;
            }
            return true;

        }
    }
}



//설명용
/*
package codingTestWithJava;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ThanksgivingTraffic_kakao {


    public static void main(String[] args) throws ParseException {

        ThanksgivingTraffic_kakao test = new ThanksgivingTraffic_kakao();

        //Test Cases
        String[] lines = new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
//        String[] lines = new String[]{"2016-09-15 01:00:04.002 2.0s",
//                "2016-09-15 01:00:07.000 2s"};
        test.solution(lines);
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    public int solution(String[] lines) throws ParseException {
        int answer = 0;
        StringTokenizer stk;
        sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        List<Info> lists = new ArrayList<>();
        for (String line : lines) {
            stk = new StringTokenizer(line, " ");
            String date = stk.nextToken();
            String time = stk.nextToken();
            String range = stk.nextToken();
            String dateTime = date + " " + time;
            lists.add(new Info(date, calRange(dateTime, range), calRange(dateTime), range));
//            System.out.println("info >> dateTime:" + dateTime + " range : " + range);
//            System.out.println("시작 : " + sdf.format(calRange(dateTime, range))+" ~ " + sdf.format(calRange(dateTime)));
        }


        for (int i = 0; i < lists.size(); i++) {
            int tmp = 0;
            long standard = lists.get(i).end;
//            System.out.println(" 기준점  " + sdf.format(new Date(standard)));
//            System.out.println("타겟 범위 구간 ] ★★ : " + sdf.format(new Date(standard)) + " ~ "+ sdf.format(new Date(standard+999)));
            for (Info list : lists) {

                if (list.inHere(standard)) {
                    tmp++;
                }
            }
            answer = Math.max(tmp, answer);
//            System.out.println(i +"번 기준]  1초간 요청처리횟수 " + tmp);
        }

//        System.out.println("결론은 " + answer);

        return answer;
    }

    public long calRange(String data) throws ParseException {

        long endTime = sdf.parse(data).getTime();
        return endTime;
    }


    public long calRange(String data, String range) throws ParseException {
        long ran = (long) (Double.parseDouble(range.replace("s", "")) * 1000);
        long endTime = sdf.parse(data).getTime();
        long startTime = endTime - (ran - 1);

        return startTime;
    }

    class Info {
        String date;
        long start;
        long end;
        String range;

        public Info(String date, long start, long end, String range) {
            this.date = date;
            this.start = start;
            this.end = end;
            this.range = range;
        }

        public boolean inHere(long targetLang) throws ParseException {
            long endRange, startRange;
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

            startRange = targetLang;
            endRange = startRange + 999;

//            System.out.println("해당 원소 구간 ] 시작 : " + sdf.format(new Date(start)) + " ~ " + sdf.format(new Date(end)));
//            System.out.println("타겟 범위 구간 ] ★★ : " + sdf.format(new Date(startRange)) + " ~ "+ sdf.format(new Date(endRange)));


            if(startRange > end ||endRange < start ){
                return false;
            }
            return true;

        }
    }
}



 */