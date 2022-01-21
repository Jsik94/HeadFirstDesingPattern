package codingTestWithJava.kakao;

import java.util.*;

public class BanUser_kakao {
    private List<Set<String>> result;

    public int solution(String[] user_id, String[] banned_id) {
        result = new ArrayList<>();


        for (int i = 0; i < user_id.length; i++) {
            boolean[] banned_visit = new boolean[banned_id.length];
            boolean[] user_visit = new boolean[user_id.length];
            Set<String> data = new HashSet<>();
            if (i == 1) {
                System.out.println("여기");
            }
            dfs(user_id, banned_id, user_visit, i, 0, data);

        }

        System.out.println("<--->");
        for (Set<String> atom : result) {
            Iterator<String> it = atom.iterator();
            while (it.hasNext()) {
                System.out.print(it.next() + " ");
            }
            System.out.println();
        }

        return result.size();
    }

    //dfs가 가는 조건
    //무조건 4개 일 때 add (set)
    //재귀 조건 현재 ban과 user가 일치하는 조건일때만


    private void dfs(String[] user_id, String[] banned_id, boolean[] user_visit, int start_idx, int regxp_idx, Set<String> data) {


        //현재 일단
        user_visit[start_idx] = true;
        data.add(user_id[start_idx]);
        //정규식 일치하는 지 확인
        //일치한다면 현재에서 갈수있는 방향 , regxp idx +1

        if (user_id[start_idx].matches(banned_id[regxp_idx].replaceAll("\\*", ".")) && user_id[start_idx].length() == banned_id[regxp_idx].length()) {
            //모든 정규식을 다 통과했을때
            if (data.size() == banned_id.length) {
                System.out.println("도착");
                if (result.contains(data)) {
                    System.out.println("같은게 있네 ?ㅃ2");
                    return;
                }

                Iterator<String> it = data.iterator();
                while (it.hasNext()) {
                    System.out.print(it.next() + " ");
                }
                System.out.println();
                result.add(data);

            } else {
                for (int i = 0; i < user_id.length; i++) {
                    if (!user_visit[i]) {
                        System.out.println(String.format("다음에 갈 키워드 : %s - 현재 검증 패턴 : %s", user_id[i], banned_id[regxp_idx]));
                        dfs(user_id, banned_id, user_visit, i, regxp_idx + 1, data);
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
        String[] user = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] ban = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(test.solution(user, ban));


    }

}
