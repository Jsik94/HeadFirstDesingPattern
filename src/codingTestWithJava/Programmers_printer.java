package codingTestWithJava;

/*

문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.


1. 가장 큰 우선순위를 먼저 찾음, 로케이션 등록

### 대기목록을 다 사용할 때 까지 반복
###
### -1.로케이션 +1 , 현재 pop
###
### 0. 인덱스가 하나 남았다면 그대로 로케이션 출력
### 1. 바로 오른쪽 인덱스가 있는지 확인
###     1-1. 없다면 가장 큰 우선순위를 왼쪽에서 부터 찾음
###     1-2. 오른쪽 인덱스가 있다면, 오른쪽 인덱스와 지금 가장 큰 인덱스 를 비교
###        1-2-1. 오른쪽 인덱스가 크다면, 로케이션을 오른쪽 인덱스로 옮김
###        1-2-1. 오른쪽 인덱스보다 큰 값이 있다면, 로케이션을 해당 위치로 옮김
###


result = 25 point



 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;





public class Programmers_printer {


    public Programmers_printer(int[] properties, int location) {
        Programmers_printer(properties,location);
    }

    public int Programmers_printer(int[] priorities, int location){


        int answer =0;
        int order =1;
        int cnt = priorities.length;
        //정답을 찾기 위한 answer sheet, 사용확인을 위한 함수
        int[] answer_sheet = new int[priorities.length];
        //추가
        boolean[] used  = new boolean[priorities.length];

        //priorities list로 변경
        ArrayList<Integer> prop = new ArrayList<>(priorities.length);
        for(int i : priorities){
            prop.add(i);
        }

        int max_value = Collections.max(prop);
        int current_idx = prop.indexOf(max_value);

//        System.out.println("idx :" + current_idx);

        answer_sheet[current_idx] = order;
        used[current_idx] = true;
        while(cnt > 1){
            cnt--;
            order +=1 ;
            prop.set(current_idx,-99999);

            int compare_value = Collections.max(prop);
            int right_idx = current_idx+1;
            int next_idx = 0;


            // 배열을 넘을 수 있으므로
            if (right_idx<priorities.length){
                //추가 : 오른쪽 인덱스가 사용 X 크거나 같을 경우만
                if (priorities[right_idx] >= compare_value && !used[right_idx] ){
                  next_idx = right_idx;
                }else {
                    next_idx = prop.indexOf(compare_value);
                }
            }else{

                next_idx = prop.indexOf(compare_value);
            }
            answer_sheet[next_idx] = order;
            current_idx = next_idx;

        }

        System.out.println(Arrays.toString(answer_sheet));

        System.out.println("Index "+location+" : " + answer_sheet[location]);
        answer = answer_sheet[location];
        return answer;
    }


}
