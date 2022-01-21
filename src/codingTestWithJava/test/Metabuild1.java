package codingTestWithJava.test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class Metabuild1 {

    private List<DataType> result;
    private List<String> data;
    String str = "";
    Matcher mt;

    public Metabuild1() {
        result = new ArrayList<>();
        data = new ArrayList<>();
    }

    public void sample(String filePath) {

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
            boolean start_toggle = false;
//            while ((str = br.readLine()) != null) {
//                mt = Pattern.compile("(\\[.*\\]) (\\[.*\\])  (\\[.*thread.*\\]) - (.*) (.*)").matcher(str);
//                mt = Pattern.compile("\\s*(.*) (.*%) (.*)").matcher(str);
//                if(mt.matches()){
//                    System.out.println(String.format("%s - %s -%s "));
//                }
//
//                //조건 1 스레드명 + galileo_bean start 태그가 나오면 객체가 하나 생성
//                //그리고 그객체에 start 일때만 시간을 넣어줌
//                //galileo_bean start
//                //그다음에 검색하다가 EST_TRAN_ID를 찾으면 그걸 해당 스레드 명인 곳에 넣어둠
//                //그다음에 Content-Length 가 나오면 해당 값을 넣어줌
//                //그다음에 Call time 수행
//                //소요시간 체크 StopWatch 스레드가 같이나옴 이걸로 잡아서 토글 활성화 시키고
//                //그때동안만 추가 matcher 실행해서 잡아냄
//                //그다음루프에서 StopWatch 나오면 토글키 반환하여 다음엔 macher off
//
//            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("C:\\Users\\yoonsic\\IdeaProjects\\HeadFirstDesingPattern\\src\\codingTestWithJava\\test\\result.txt")), StandardCharsets.UTF_8));
            bw.append("ㅇㅅㅇ\n");
            bw.write("ㅇㅂㅇ\n");
            bw.append("ㅇㅅㅇ\n");
            bw.close();

            bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\yoonsic\\IdeaProjects\\HeadFirstDesingPattern\\src\\codingTestWithJava\\test\\result.txt"), Charset.forName("UTF-8"),true));

            bw.append("앙기마띠!");
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        Metabuild1 test = new Metabuild1();
        test.sample("C:\\Users\\yoonsic\\IdeaProjects\\HeadFirstDesingPattern\\src\\codingTestWithJava\\test\\galileo.log");

//        System.out.println(1);
//        System.out.println(1<<1);
//        System.out.println((1<<2)|1);
    }

}


class DataType {
    private String startTime;
    private String endTime;
    private String threadName;
    private List<String> keyword;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public List<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(List<String> keyword) {
        this.keyword = keyword;
    }
}