package codingTestWithJava.kakao;

import java.util.*;

public class BanUser_kakao {
    private List<String> result;

    public int solution(String[] user_id, String[] banned_id) {
        result = new ArrayList<>();


        for (int i = 0; i < user_id.length; i++) {
            boolean[] user_visit = new boolean[user_id.length];
            List<String> data = new ArrayList<>();
            System.out.println(i+"-----------------------------");
            dfs(user_id, banned_id, user_visit, i, 0, data, 0);

        }

//        for (String atom : result){
//            System.out.println(atom);
//        }

        return result.size();
    }

    //dfs가 가는 조건
    //무조건 4개 일 때 add (set)
    //재귀 조건 현재 ban과 user가 일치하는 조건일때만


    private void dfs(String[] user_id, String[] banned_id, boolean[] user_visit, int start_idx, int regxp_idx, List<String> data, int tmp) {

//        System.out.println((tmp + 1) + ":현재 :" + user_id[start_idx]);
        //현재 일단
        user_visit[start_idx] = true;
        data.add(user_id[start_idx]);
        //정규식 일치하는 지 확인
        //일치한다면 현재에서 갈수있는 방향 , regxp idx +1

//        if (user_id[2].equals("crodo") && tmp == 1) {
//            System.out.println("ㅅㅂ 이상해");
//        }

        if (user_id[start_idx].matches(banned_id[regxp_idx].replaceAll("\\*", ".")) && user_id[start_idx].length() == banned_id[regxp_idx].length()) {
            //모든 정규식을 다 통과했을때
            if (data.size() == banned_id.length) {

//                System.out.println("지금 리스트에 있는것");
//                for (String atom : result){
//                    System.out.println(atom);
//                }
//                System.out.println("확인해야되는 것 :" + String.join(" ",data));
//                Iterator<String> it = data.iterator();
//                while (it.hasNext()) {
//                    System.out.print(it.next() + " ");
//                }
//                System.out.println();
                data.sort((o1, o2) -> o1.compareTo(o2));

                if (result.contains( String.join(" ",data))) {
//                    System.out.println("같은게 있네 ?ㅃ2");
                } else {
//                    Iterator<String> it = data.iterator();
//                    while (it.hasNext()) {
//                        System.out.print(it.next() + " ");
//                    }
//                    System.out.println();
                    result.add(String.join(" ",data));
                }


            } else {
                for (int i = 0; i < user_id.length; i++) {
                    if (!user_visit[i]) {
//                        System.out.println(String.format("다음에 갈 키워드 : %s - 현재 검증 패턴 : %s", user_id[i], banned_id[regxp_idx]));
                        dfs(user_id, banned_id, user_visit, i, regxp_idx + 1, data, tmp + 1);
                    }
                }
            }


        }
        data.remove(user_id[start_idx]);
        user_visit[start_idx] = false;
    }


//    public boolean checkStr(String target, String stan){
//
//        stan.replace()
//
//    }

    public static void main(String[] args) {
        BanUser_kakao test = new BanUser_kakao();
        String[] user = {"abcde1", "accde2", "adcde3", "aecde4"};
        String[] ban = {"***d**", "a*c*e*", "***de*"};

        System.out.println(test.solution(user, ban));


    }

}
