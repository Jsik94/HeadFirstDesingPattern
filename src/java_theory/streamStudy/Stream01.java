package java_theory.streamStudy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Stream01 {

    public static void main(String[] args) {

        System.out.println("Array Source Case [origin]");
        String[] mountains = {"일품진로","한라산","참이슬","좋은데이","대선","처음처럼"};
        for (String mountain : mountains){
            System.out.println(mountain);
        }

        System.out.println("Using Stream");
        Stream<String> stream1 = Arrays.stream(mountains);

        stream1.forEach(s -> {
            if(s.indexOf("산")>=0){
                System.out.println(s);
            }
        });
        //최종연산 함수를 사용하여 재사용할 수 없음
        //stream1.forEach(y-> System.out.println(y)); // runtime error : stream has already been operated upon or closed

        System.out.println("Stream Sort -> Origin data doesn't changed");
        Stream<String> Stream2 = Arrays.stream(mountains);
        //내림차순
        Stream2.sorted((o1, o2) -> o2.compareTo(o1)).forEach(s -> System.out.println(s));


        System.out.println("Arrays Sort -> Origin data changed");
        Arrays.sort(mountains);
        for (String mountain : mountains){
            System.out.println(mountain);
        }



        System.out.println("List Source Case [origin]");

        List<String> lists = Arrays.asList("일품진로","한라산","참이슬","좋은데이","대선","처음처럼");
        for (String list : lists){
            System.out.println(list);
        }
        System.out.println("Stream Sort -> Origin data doesn't changed");
        Stream<String> stream3 = lists.stream();

        stream3.sorted((o1, o2) -> o2.compareTo(o1)).forEach(s -> System.out.println(s));


        System.out.println("Arrays Sort -> Origin data changed");
        Collections.sort(lists,Collections.reverseOrder());
        for (String list : lists){
            System.out.println(list);
        }
    }
}
