package codingTestWithJava;

/*
Solved.ac class project

class 3

latency
 */

/*
카잉 달력 출처다국어
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	42096	10078	7530	24.466%
문제
최근에 ICPC 탐사대는 남아메리카의 잉카 제국이 놀라운 문명을 지닌 카잉 제국을 토대로 하여 세워졌다는 사실을 발견했다. 카잉 제국의 백성들은 특이한 달력을 사용한 것으로 알려져 있다. 그들은 M과 N보다 작거나 같은 두 개의 자연수 x, y를 가지고 각 년도를 <x:y>와 같은 형식으로 표현하였다. 그들은 이 세상의 시초에 해당하는 첫 번째 해를 <1:1>로 표현하고, 두 번째 해를 <2:2>로 표현하였다. <x:y>의 다음 해를 표현한 것을 <x':y'>이라고 하자. 만일 x < M 이면 x' = x + 1이고, 그렇지 않으면 x' = 1이다. 같은 방식으로 만일 y < N이면 y' = y + 1이고, 그렇지 않으면 y' = 1이다. <M:N>은 그들 달력의 마지막 해로서, 이 해에 세상의 종말이 도래한다는 예언이 전해 온다.

예를 들어, M = 10 이고 N = 12라고 하자. 첫 번째 해는 <1:1>로 표현되고, 11번째 해는 <1:11>로 표현된다. <3:1>은 13번째 해를 나타내고, <10:12>는 마지막인 60번째 해를 나타낸다.

네 개의 정수 M, N, x와 y가 주어질 때, <M:N>이 카잉 달력의 마지막 해라고 하면 <x:y>는 몇 번째 해를 나타내는지 구하는 프로그램을 작성하라.

입력
입력 데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 구성된다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다. 각 테스트 데이터는 한 줄로 구성된다. 각 줄에는 네 개의 정수 M, N, x와 y가 주어진다. (1 ≤ M, N ≤ 40,000, 1 ≤ x ≤ M, 1 ≤ y ≤ N) 여기서 <M:N>은 카잉 달력의 마지막 해를 나타낸다.

출력
출력은 표준 출력을 사용한다. 각 테스트 데이터에 대해, 정수 k를 한 줄에 출력한다. 여기서 k는 <x:y>가 k번째 해를 나타내는 것을 의미한다. 만일 <x:y>에 의해 표현되는 해가 없다면, 즉, <x:y>가 유효하지 않은 표현이면, -1을 출력한다.



 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_6064 {

    public static void main(String[] args) throws IOException {
        BJ_6064 test = new BJ_6064();
    }

    public BJ_6064() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stk;
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0 ; i < tc ; i++){
            stk = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(stk.nextToken());
            int M = Integer.parseInt(stk.nextToken());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());

            int result ;

            if ( N<M){
                result = solution(N,M,x,y);
            }else{
                result=solution(M,N,y,x);
            }
            sb.append(result+"\n");
        }


        System.out.println(sb);

    }

    private int solution(int n, int m, int x, int y) {
        //rotation 단위
        int unit = m-n;

        //최소 공배수까지 반복 숫자
        int time_limit =0;

        //unit ==0 이라면 n 과 m 이 같다는 의미
        if(unit==0){
            //n과 m 같다면, x와y는 같은 값 밖에 안나옴
            if(x==y){
                return y;
            }else{
                //말이안됨
                return -1;
            }
        }else if ( n%unit!=0){
            //서로소 인 경우엔 x값에 대해 y값의 정의역 수가 m 개임
            time_limit =m;
        }else{
            //1이 아닌 최대공약수가 존재함을 의미 따라서 y값의 정의역은 n/unit개
            time_limit = n/ unit;
        }

        //default 자릿수(비순환시)
        int result=x;

        for (int i = 0 ; i <= time_limit+1;i++){

            if(x == y){
                result +=i*n;
                return result;
            }
            //unit만큼 빼주면서 문자 실행
            x =rotate(m,x,unit);
        }



        return -1;
    }

    private int rotate(int standard,int target, int unit){

            if(target - unit<=0){
                target-=unit;
                target+=standard;
            }else{
                target-=unit;
            }


        return target;
    }

}
