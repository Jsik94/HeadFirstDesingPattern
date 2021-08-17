package codingTestWithJava;

import java.util.Scanner;

public class InputTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //입력 예제
        //1 String
        //2 Str ing String 3

        int first = sc.nextInt();
//        String first_next = sc.next();

        int second = sc.nextInt();
        String second_next = sc.next();
        String second_next_next = sc.nextLine();


        System.out.println(first);
//        System.out.println(first_next);
        System.out.println(second);
        System.out.println(second_next);
        System.out.println(second_next_next);
    }

}
