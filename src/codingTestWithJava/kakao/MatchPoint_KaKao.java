package codingTestWithJava.kakao;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



class MatchPoint_KaKao {

    public static void main(String[] args) {
        MatchPoint_KaKao test = new MatchPoint_KaKao();
    }

    public MatchPoint_KaKao() {

//        solution("Muzi", new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\t0muzi0muzi092apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"});

        String[] sample = new String[]{"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\t0muzi0muzi092apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};

        Matcher mt = Pattern.compile("\\b(?i)(muzi)\\b").matcher("0muzi0muzi00muzi0muzi00muzi0muzi0");
        while (mt.find()){
            System.out.println(mt.group(2));
        }

    }
    public int solution(String word, String[] pages) {
        int answer = 0;
//        System.out.println(pages[0]);
        word = word.toLowerCase();
        Matcher mt=null;


        PageInfo[] pageInfos = new PageInfo[pages.length];
        List<String>[] datas = new List[pages.length];

        for(int i = 0 ; i < pages.length ; i++){
            int score = 0 ;
            pages[i] =pages[i].toLowerCase();
            datas[i] = new ArrayList<>();
            pageInfos[i] = new PageInfo();
            mt= Pattern.compile("(<meta property=\"og:url\" content=\"https://(\\S*)\")").matcher(pages[i]);

            while(mt.find()){
                String name = mt.group(2).trim();
                System.out.println(name);
                pageInfos[i].name =name;
            }

            mt = Pattern.compile("(?<=[^a-zA-Z])("+word+")[^a-zA-Z]").matcher(pages[i]);
            while(mt.find()){
                System.out.println(mt.group(1));
                score +=1;
            }

            System.out.println("기본 점수 :" + score);
            pageInfos[i].basicScore = score;

            mt = Pattern.compile("<a href=\"(\\S*)//(\\S*)\"").matcher(pages[i]);
            while(mt.find()){
                String url = mt.group(2).trim();
                System.out.println("a 태그 :"+url);
                datas[i].add(url);
            }
            pageInfos[i].linkedOutPage = datas[i];
            pageInfos[i].outerCnt = datas[i].size();

            // System.out.println(pageInfos[i].toString());
        }




        for(int i = 0 ; i < pageInfos.length;i++){

            for(String url : pageInfos[i].linkedOutPage){
                for(int k = 0 ; k < pageInfos.length;k++){
                    if(i == k) continue;
                    if(url.equals(pageInfos[k].name)){
                        pageInfos[k].score += (double)pageInfos[i].basicScore /pageInfos[i].linkedOutPage.size();
                    }
                }
            }
        }

        double max = 0;
        for(int i = 0 ; i < pageInfos.length;i++) {
            System.out.println((pageInfos[i].basicScore+pageInfos[i].score));
            if(max < (pageInfos[i].basicScore+pageInfos[i].score)){
                max = (pageInfos[i].basicScore+pageInfos[i].score);
                answer = i;
            }
        }


//        System.out.println(answer);
        return answer;
    }


    class PageInfo{
        String name;
        int outerCnt;
        int basicScore;
        List<String> linkedOutPage;
        double score;

        @Override
        public String toString() {
            return "PageInfo{" +
                    "name='" + name + '\'' +
                    ", outerCnt=" + outerCnt +
                    ", basicScore=" + basicScore +
                    ", linkedOutPage=" + linkedOutPage +
                    ", Score=" + score +
                    '}';
        }
    }
}