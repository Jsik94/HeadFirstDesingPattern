package java_theory.collectionStudy;

import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtility {


    final static String[] CHO = {"ㄱ","ㄲ","ㄴ","ㄷ","ㄸ","ㄹ","ㅁ","ㅂ","ㅃ",
            "ㅅ","ㅆ","ㅇ","ㅈ","ㅉ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};
    final static String[] JOONG = {"ㅏ","ㅐ","ㅑ","ㅒ","ㅓ","ㅔ","ㅕ","ㅖ",
            "ㅗ","ㅘ", "ㅙ","ㅚ","ㅛ","ㅜ","ㅝ","ㅞ","ㅟ","ㅠ","ㅡ","ㅢ","ㅣ"};
    final static String[] JONG = {"","ㄱ","ㄲ","ㄳ","ㄴ","ㄵ","ㄶ","ㄷ","ㄹ","ㄺ",
            "ㄻ","ㄼ", "ㄽ","ㄾ","ㄿ","ㅀ","ㅁ","ㅂ","ㅄ","ㅅ","ㅆ","ㅇ","ㅈ","ㅊ","ㅋ","ㅌ","ㅍ","ㅎ"};




    //[문자열이 숫자 형식이면 true,아니면 false반환]
    public static boolean isNumber(String value) {
        for(int i=0;i < value.length();i++) {
            if(!(value.codePointAt(i) >='0' && value.codePointAt(i) <='9'))
                return false;
        }
        return true;
    }//////
    //두 날짜 차이를 반환하는 메소드]
    //반환타입:long
    //매개변수:String타입의 두 날짜,날짜패턴,구분자(단위)
    public static long getDifferenceDates(
            String stFDate,
            String stSDate,
            String pattern,
            char delim) throws ParseException
    {
        //1]매개변수에 전달된 pattern으로 SimpleDateFormat객체생성
        SimpleDateFormat dateFormat= new SimpleDateFormat(pattern);
        //2]String -> Date:parse()
        Date fDate=dateFormat.parse(stFDate);
        Date sDate=dateFormat.parse(stSDate);
        //3]시간차 구하기:getTime()
        long fTime = fDate.getTime();
        long sTime = sDate.getTime();
        long diff = Math.abs(fTime-sTime);
        //4]매개변수 delim에 따른 날짜 차이 반환
        switch(Character.toUpperCase(delim)) {
            case 'D':return diff/(24*60*60*1000);
            case 'H':return diff/(60*60*1000);
            case 'M':return diff/(60*1000);
            default: return diff/1000;
        }
    }////////////////


    public static String getFirstCharacter(String name) {

        if(name.equals("")) {
            return null;
        }

        char target = name.charAt(0);
        if(target >= 0xAC00) {
            target = (char)(target - 0xAC00);
            target = (char)(target/28/21);

        } else {

        }


        return CHO[target];
    }


//	public static void main(String[] args) {
//		String[] names = {"가불","ㄱ","각불","ㄱ","나길동","ㄴ","다길동","ㄷ","카길동","ㅋ","하길동","ㅎ"};
//
//
//		for(int i = 0 ; i< names.length ; i+=2) {
//			System.out.println("<------------구분 ------------>");
//			System.out.println(getFirstCharacter(names[i]).charAt(0));
//			System.out.println(getFirstCharacter(names[i+1]).charAt(0));
//			System.out.println(Normalizer.normalize(getFirstCharacter(names[i]), Normalizer.Form.NFC));
//			System.out.println("단어 value:\t"+(getFirstCharacter(names[i]).charAt(0)-'0'));
//			System.out.println("문자 value:\t"+(getFirstCharacter(names[i+1]).charAt(0)-'0'));
//
//			System.out.println("차이 : " + ((getFirstCharacter(names[i]).charAt(0)-'0')-(getFirstCharacter(names[i+1]).charAt(0)-'0')));
//		}
//
//
//	}
//


}
