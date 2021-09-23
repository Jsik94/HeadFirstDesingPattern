package codingTestWithJava;

/*
Solved.ac class project

class 2

latency :
 */



/*
https://www.acmicpc.net/problem/1978
소수 찾기
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	80183	38070	31003	48.231%
문제
주어진 수 N개 중에서 소수가 몇 개인지 찾아서 출력하는 프로그램을 작성하시오.

입력
첫 줄에 수의 개수 N이 주어진다. N은 100이하이다. 다음으로 N개의 수가 주어지는데 수는 1,000 이하의 자연수이다.

출력
주어진 수들 중 소수의 개수를 출력한다.

 */

import java.util.Scanner;
public class BJ_1978 {

    public static void main(String[] args){
        BJ_1978 test = new BJ_1978();
    }

    public BJ_1978(){
        Scanner sc = new Scanner(System.in);
        //입력
        int len = sc.nextInt();
        int datas[] = new int[len];
        for (int i = 0 ; i < len ; i++){
            datas[i] = sc.nextInt();
        }

        //로직
        int result = solution(datas);

        //출력
        System.out.println(result);
    }

    public int solution(int[] datas){
        //소수의 갯수
        int result = 0 ;

        //데이터 원소마다 접근
        for (int data : datas){
            //1은 소수가 아니므로 pass
            if( data ==1){
                continue;
            }

            //약수의 갯수를 체크하는 변수
            int cnt = 0;

            //1부터 해당값의 제곱근까지만 반복문 시행
            for (int i = 1 ; i* i <= data ; i++ ){
                //약수라면
                if( data % i == 0 ){
                        //제곱수 일땐 +1
                    if (i * i == data){
                        cnt+=1;
                    }else{
                        //제곱수가 아닐 땐 +2
                        cnt+=2;
                    }
                }
            }

            //약수가 2인 값만 result에 누적
            if(cnt ==2){
                result+=1;
            }

        }
        return result;
    }
}
