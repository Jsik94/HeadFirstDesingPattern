package codingTestWithJava.kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenulRenewal_kakao {
    public static void main(String[] args) {

        MenulRenewal_kakao test =new MenulRenewal_kakao();
    }

    public MenulRenewal_kakao() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};

    }

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        Map<String,Integer> hashmap = new HashMap<>();
        List<String> combination =  new ArrayList<>();


        for (String order : orders){


        }




        return answer;
    }

//    public void combination(int[] arr, int depth, int index, int target) {
//        if (depth == r) {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int i = 0; i < now.length; i++) {
//                temp.add(arr[now[i]]);
//            }
//            result.add(temp);
//            return;
//        }
//        if (target == n) return;
//        now[index] = target;
//        combination(arr, depth + 1, index + 1, target + 1);
//        combination(arr, depth, index, target + 1);
//    }


}


