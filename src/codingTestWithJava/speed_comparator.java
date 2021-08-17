package codingTestWithJava;

/*
    System.out.println과
    Stringbuilder의 속도 차이를 위한 실험
 */


import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class speed_comparator {

    final static int DIRECT_PRINT = 1;
    final static int BUILDER_PRINT = 2;
    StringBuilder stringBuilder = new StringBuilder();
    Scanner scanner =new Scanner(System.in);

    public static void main(String[] args) {
        long start,latency_d,latency_s;
        speed_comparator sp ;
        int n = 100;


        start = System.currentTimeMillis();
        sp = new speed_comparator(DIRECT_PRINT,n);
        latency_d = System.currentTimeMillis() -start;


        start = System.currentTimeMillis();
        sp = new speed_comparator(BUILDER_PRINT,n);
        latency_s = System.currentTimeMillis() -start;


        System.out.println("Recursive Call output latency check");
        System.out.println("Standard Count : " + n);
        System.out.println("<---------\tResult\t-------->");
        System.out.println("Case 1. Direct print : " + latency_d);
        System.out.println("Case 2. Stringbuilder print : " + latency_s);

    }

    public speed_comparator(int opt,int count) {

        switch (opt){

            case DIRECT_PRINT:

                recursive_direct(count);
                break;

            case BUILDER_PRINT:

                recursive_sb(count,stringBuilder);
                System.out.println(stringBuilder);
                break;
        }


    }


    //팩토리얼 재귀함수 sout 용
    public int recursive_direct(int k) {
        if (k == 1) {
            return 1;
        } else {
                System.out.println("Call function!!");
                System.out.println("Current k is " + k);
            return k * recursive_direct(k - 1);
        }

    }

    //팩토리얼 재귀함수 stringbuilder용
    public int recursive_sb(int k,StringBuilder sb) {
        if (k == 1) {
            return 1;
        } else {
            sb.append("Call function!!");
            sb.append("Current k is " + k);
            sb.append("\n");
            return k * recursive_direct(k - 1);
        }

    }

}
