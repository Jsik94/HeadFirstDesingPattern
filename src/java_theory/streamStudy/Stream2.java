package java_theory.streamStudy;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Stream2 {

    public static void main(String[] args) {
        System.out.println("Main method");


        /*
            map안에 operand를 인자로 전달
            각 인자가 operand에 의해 control

         */
        System.out.println("1. Map");
        //init range ( 1 ~ 5)
        IntStream stream = IntStream.rangeClosed(1, 5);
        stream.map(operand -> operand * 2).forEach(e -> System.out.println(e));

          /*
            reduce
            모든 데이터를 축척하는 연산을 시행할 수 있음
            해당 연산을 통해 차원을 압축하는 것이 가능함
         */
        System.out.println("2. reduce");
        System.out.println(IntStream.range(1, 6).reduce(0, (left, right) -> left + right));

        /*
            limit 해당 요소까지만으로 제한을 건다

         */
        System.out.println("3. limit");
        IntStream.range(1, 5).limit(3).forEach(System.out::println);

        /*
            skip 해당 요소까지만으로 스킵을 걸고 스트림반환

         */
        System.out.println("4. skip");
        IntStream.range(5, 10).skip(3).forEach(System.out::println);

         /*
            distinct
            중복값 제거 후 새로운 스트림 반환
         */
        System.out.println("5. distinct");
        Arrays.asList("아", "아", "dk", "2323", "2323", "1233").stream().distinct().sorted().forEach(System.out::println);

       /*
            filter
            해당 조건만을 반환
            짝수만 추출하는 코드임
         */
        System.out.println("6. filter");
        IntStream.range(1, 11).filter(value -> value % 2 == 0).forEach(System.out::println);

        /*
            count
            집계함수
         */
        System.out.println("7. count");
        System.out.println(IntStream.range(1, 9999).filter(value -> value % 2 == 0).count());

         /*
            sum
            집계함수
         */
        System.out.println("8. sum");
        System.out.println(IntStream.range(1, 10).filter(value -> value % 2 == 0).sum());

        /*
            max
            집계함수
         */
        System.out.println("9. max");
        System.out.println(IntStream.range(1, 10).filter(value -> value % 2 == 0).max());

        /*
            min
            집계함수
         */
        System.out.println("10. min");
        System.out.println(IntStream.range(1, 10).filter(value -> value % 2 == 0).min().getAsInt());

        /*
            findAny
            집계함수
         */
        System.out.println("11. findAny");
        System.out.println(IntStream.range(1, 100).findAny().getAsInt());

        System.out.println(IntStream.range(1,101).skip(49).filter(e -> e % 5 ==0).reduce((left, right) -> left+right).getAsInt());

    }
}
