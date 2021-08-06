package codingTestWithJava;


import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;

public class Programmers_kamo {

    public Programmers_kamo(){
        String args[][] = {{"yellowhat", "headgear"},{"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};

        solution(args);
    }

    public int solution (String[][] clothes){
        int answer =0;

        ArrayList<Pair<String,Integer>> data = new ArrayList<>();
        Pair<String,Integer> kind ;
        int total_cnt = clothes.length;
        // 어떤 종류의 세부 개체 이름은 필요가 없음 갯수만 있으면 됨
        for (String[] i : clothes){
            boolean toggle = false;
            System.out.println(Arrays.toString(i));
            if (data.isEmpty()){
                kind = new Pair<>(i[1],1);
                data.add(kind);
            }else{

                for(Pair<String,Integer> j : data){
                    if (j.getLeft() == i[1]){
                        toggle = true;
                        int cnt  = j.getRight()+1;
                        j.setRight(cnt);
                    }else{
                        continue;
                    }
                }

                if (!toggle){
                    kind = new Pair<>(i[1],1);
                    data.add(kind);
                }
            }


        }


        System.out.println("Total_cnt : " +total_cnt+ "\t kind_cnt : " + data.size());

        for(int i = 1 ; i <= data.size();i++){
        // combination 사용
            /*
            ex) i = 1
            전체 data.size() (2) 중 1개를 뽑았을때
            data[0],data[2] 2개  -> 2 + 1 -> 3개
            ex) i = 2
            전체 data.size() (2) 중 2개를 뽑았을때
            data[0] & data[1] 1개 -> 2*1 - > 2개

            함수 종류는 한가지 필요함
            -조합 함수, 나온결과를 계산하는 함수

            함수 필수 파라미터
            Arraylist , combination_cnt
            output
            int

            arraylist
             */




        }


        return answer;
    }
}
