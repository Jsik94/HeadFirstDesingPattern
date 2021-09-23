package codingTestWithJava;


/*
Solved.ac class project

class 2

latency :
 */

/*
https://www.acmicpc.net/problem/4153

직각삼각형 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	128 MB	31880	16789	15132	52.774%
문제
과거 이집트인들은

 */

import java.io.IOException;
import java.util.Scanner;

public class BJ_4153 {

    public static void main(String[] args) throws IOException {
        BJ_4153 test =new BJ_4153();
    }

    public BJ_4153() throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int num3 = sc.nextInt();

            if(num1==num2 && num2 ==num3 && num3 ==0){
                break;
            }else{
                sb.append(solution2(num1,num2,num3)+"\n");
            }
        }
        System.out.println(sb);


    }


    public String solution2(int num1,int num2,int num3){
        boolean toggle = false;
        if(num1*num1 + num2*num2 == num3*num3){
            toggle =true;
        }else if(num1*num1 + num3*num3 == num2*num2){
            toggle =true;
        }else if(num3*num3 + num2*num2 == num1*num1){
            toggle =true;
        }

        if(toggle) return "right";
        return "wrong";
    }
}
