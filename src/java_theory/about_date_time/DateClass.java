package java_theory.about_date_time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateClass {

    public static void main(String[] args) throws ParseException {


        Date mydate =new Date(System.currentTimeMillis());

        //Date 인자로나온 표준 시간 반환 toString 이나 반환은 똑같음
        System.out.println(mydate.toString());

        //long형 반환
        System.out.println(mydate.getTime());


        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        //패턴 출력
        System.out.println(sd.toPattern());
        //addr
        System.out.println(sd.toString());

        //해당 포멧으로 데이터 타임 출력
        System.out.println(sd.format(mydate));


        System.out.println("<-------- Test my self  -------------->");


        /*
		  Date클래스:날짜 정보를 다루는 클래스로   대부분 Deprecated되었음
		  Date()기본 생성자나 Date(long date)인자 생성자를 제외한
		  모든  생성자와 대부분의 메소드가  Deprecated됨.

		  java.util패키지에 있음

		  Date클래스의 toString() 메소드도 메모리의 주소를 문자열로 반환하는 것이 아니라
		  저장된 날짜 데이타를 문자열로 반환되도록 오버라이딩 되었음.
		   */

        //현재 시간 반환
        System.out.println("Today is : "+new Date());
        //address는 안나옴
        System.out.println("Address : " + new Date().toString());


        //int getDay():숫자 반환(0:일요일,1:월요일...6:토요일)

        System.out.println("요일은 0~ 6 일 ~ 토 - " + new Date().getDay());


        //※1970년 1월 1일 0시 0분 0초부터 특정 시점까지 흘러온
        //시간을
        //1000분 1초단위로 반환:long getTime()
        //영국에 있는 그리리치천문대 기준
        //우리나라는 9시간 빠름
        //pasteDate객체를 1970년 1월 1일 0시 0분 1초

        Date date =new Date();
        System.out.printf("%d년 %3d월 %3d일 %d:%d:%d\n",
                date.getYear()+1900,
                date.getMonth(),
                date.getDay(),
                date.getHours(),
                date.getMinutes(),
                date.getSeconds());


        /*
         * Calendar클래스:
         * 생성자로 Calendar객체를 인스턴스화 할 수없다
         * 왜냐하면 접근지정자가 protected이기때문에
         * Calendar클래스는 Single tone Design으로
         * 정의 되었음.
         * 그래서 getInstance()메소드로 인스턴스화 함.
         *
         * java.util패키지에 존재
         */

        //Calendar cal = new Calendar();//[x]

        System.out.println("<---------Calendar Class---------->");
        Calendar cal = Calendar.getInstance();
        //얘는 주소 나온다. toString도 주소임
        System.out.println(cal.getTime());
        System.out.println("Calendar Address : "+cal.toString());


        //1:일요일,2:월요일.... 7:토요일
        System.out.println("오늘은  " + cal.DAY_OF_WEEK+" 요일 입니다."  );
        //오전 오후 구분]
        //cal.get(Calendar.AM_PM)의 반환값:0이면 오전 ,1이면 오후

        System.out.println("Am 0 | Pm 1 : "+ cal.get(Calendar.AM_PM));



        //Calendar타입으로 날짜 설정-set()메소드
        cal.set(2013,02,2,3,5,20);
        System.out.println("after setting");
        System.out.println(cal.getTime());



        /*
         * SimpleDateFormat클래스:java.text패키지에 있는
         * 클래스로 날짜관련 정보를 얻는 데 유용한 클래스
         */

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/YY");


        //1]Date타입을 String형으로 반환해주는 메소드
        //  날짜패턴에 맞게 반환 해줌.
        //  String format(Date d);
        //  Date->String
        System.out.println(simpleDateFormat.format(new Date()).toString());;

        //2]중간에 날짜 패턴 변경 -applyPattern(String 날짜패턴)
        // a는 오전/오후를 나타내는 패턴
        // 예로 날짜 패턴에 at를 출력하고 싶다면
        // a는 패턴을 의미하는 문자 이기때문에
        // "yyyy년 MM월 dd일 at HH시"라고 하면 에러
        // 그래서 'at'으로 표현하면 a는 패턴을 의미하는게아니라
        // 그냥 a문장에 해당
        // "yyyy년 MM월 dd일 'at' HH시"는 정상

        simpleDateFormat.applyPattern("YYYY.MM.dd a");

        System.out.println(simpleDateFormat.format(new Date()).toString());


        //3]날짜형식의 문자열을 Date타입으로 반환 해주는 메소드
        //  Date parse("날짜형식의 문자열");
        //  String ->Date
        //※단,날짜 형식의 문자열이 날짜패턴과 일치해야한다.
        simpleDateFormat.applyPattern("YYYY-MM-dd");

        System.out.println("날짜 형식의 문자열을 Date 타입으로 바꾸는 법");
        String sample1 = "2019-04-05";
        String sample2 = "4/5/2019";
        String sample3 = "20:23";

        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat format2 = new SimpleDateFormat("MM/dd/yyyy");
        SimpleDateFormat format3 = new SimpleDateFormat("HH:mm");
        Date parse_sample1 = format1.parse(sample1);
        Date parse_sample2 = format2.parse(sample2);
        Date parse_sample3 = format3.parse(sample3);

        //이상태에서 다시 바꿔야한 것임
        System.out.println("Sample : " + sample1 +" --change--> " + parse_sample1);
        System.out.println("Sample : " + sample2 +" --change--> " + parse_sample2);
        System.out.println("Sample : " + sample3 +" --change--> " + parse_sample3);

        //4]패턴을 반환하는 메소드:toPattern()

        System.out.println("Current pattern : " + simpleDateFormat.toPattern());
        //1]String -> Date : parse()


        //2]1970년 1월1 일 0시 0분0초부터
        //  각 날짜까지 흘러온 시간을 1000분의 1초
        //  단위로 얻기:Date클래스의 getTime()호출
        mydate.getTime();

        //Calendar타입->Date타입으로 변환:Calendar객체.getTime()

        Date simple = Calendar.getInstance().getTime();
        System.out.println(simple);

        //100일째되는 날을 천분의 1초 단위로 바꿔서 처음 만난날에 더하기
        //long hundredTime = (long)100*24*60*60*1000;
        //1000분의 1초 단위를 Date로 변환


        //Date클래스의 날짜 차이관련 메소드]
        //1]두 날짜 사이의 선후관계 판단하는 메소드
        //boolean after()/before()


        //2]두 날짜가 같은지 비교
        //  같으면 true,다르면 false
        //  Date클래스의 equals()메소드는
        //  메모리 주소 비교가 아닌
        //  날짜 비교하도록 오버라이딩 됨
        System.out.println(mydate.equals(simple));

        //3]int compareTo(Date anotherDate)
        //  두 날짜가 같다면 0반환
        //  다르다면 양수(1)나 음수(-1) 반환.
        //  날짜 차이는 계산 안됨
        Calendar comp = Calendar.getInstance();
        comp.set(2000,3,3,0,0,0);
        cal.set(2000,3,3,0,0,0);

        mydate= comp.getTime();
        simple = comp.getTime();
        System.out.println(mydate);
        System.out.println(simple);
        System.out.println("둘이 같음 ? equals " + mydate.equals(simple));
        System.out.println("둘이 같음 ? compare " + mydate.compareTo(simple));
    }
}
