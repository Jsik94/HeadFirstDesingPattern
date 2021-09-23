package codingTestWithJava.kakao;


/*

https://programmers.co.kr/learn/courses/30/lessons/72410
 */


import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class newIDRecog_kakao {

    public static void main(String[] args) {
        newIDRecog_kakao test =new newIDRecog_kakao();
    }

    public newIDRecog_kakao() {

        Scanner sc = new Scanner(System.in);

        solution(sc.nextLine());
    }

    public String solution(String new_id){
        String answer = "";
        char[] ids = new_id.toCharArray();
        StringBuffer bf = new StringBuffer();

        //1차 2차통합
        for (int i = 0 ; i <ids.length ;i++){
            ids[i] = Character.toLowerCase(ids[i]);
            if((ids[i]>='a'&&ids[i]<='z')||(ids[i]>='0'&&ids[i]<='9')||ids[i]=='-'
                    ||ids[i]=='_'
                    ||ids[i]=='.'){
                bf.append(ids[i]);
            }
        }

        new_id = new String(bf);
        //4차 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
        Matcher mt = Pattern.compile("\\.*(.+)\\.*").matcher(new_id);
        mt.matches();
        new_id = mt.group(1);
        bf = new StringBuffer();

        //3차마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환
        StringTokenizer stk = new StringTokenizer(new_id,".");
        while (stk.hasMoreTokens()){
            bf.append(stk.nextToken());
            if (stk.hasMoreTokens()){
                bf.append(".");
            }
        }

        new_id = new String(bf);



        //5차 빈 문자열이라면, new_id에 "a"

        if(new_id.isEmpty()){
            new_id = "a";
        }

        //6차 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거

        if(new_id.length()>=16){
            new_id = new_id.substring(0,15);
            if(new_id.matches("(.+)(\\.)+")){
                mt = Pattern.compile("(.+)(\\.)+").matcher(new_id);
                mt.matches();
                new_id = mt.group(1);
            }else{

            }

        }

        //7차 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입
        bf = new StringBuffer();
        if(new_id.length()<=2){
            char tmp =' ';
            for (char a : new_id.toCharArray()){
                bf.append(a);
                tmp = a;
            }
            for(int i = new_id.length()-1 ; i <2 ;i++){
                bf.append(tmp);
            }
            new_id = new String(bf);
        }

       return new_id;
    }
}
