//package codingTestWithJava;
//
//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Scanner;
//
//public class Main_test {
//
//
//    int[] properties;
//    int location;
//
//    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Select - 1 : sample \t 2 : dynamic \t 3 : another \t 4 : Kamo");
//        int data = sc.nextInt();
//        Main_test cas =new Main_test();
//        switch (data){
//            case 1:
//                cas.sample_data();
//                break;
//            case 2:
//                cas.dynamic_data();
//                break;
//            case 3:
//
//                Programmers_coloringBook test2 = new Programmers_coloringBook();
//                return;
//            case 4:
//                cas.kamo();
//                return;
//        }
//
//                Programmers_printer_1 test = new Programmers_printer_1(cas.getProperties(),cas.getLocation());
//
//
//    }
//
//
//    public void sample_data(){
//        this.properties = new int[]{2, 1, 3, 2};
//        this.location = 2;
//    }
//
//    public void dynamic_data(){
//        int[] prop;
//        int loc;
//        Scanner sc = new Scanner(System.in);
//        String tmp = sc.nextLine();
//
//        // 정수 추출 코드
//        List<Integer> lst = new ArrayList<>();
//
//        for (char ch : tmp.toCharArray()){
//            if (48 <= ch && ch <= 57) {
//                lst.add(Integer.parseInt(Character.toString(ch)));
//            }
//        }
//        //배열화 코드
//        prop = lst.stream().mapToInt(i->i).toArray();
////        System.out.println(Arrays.toString(prop));
//
//        loc = sc.nextInt();
//
//        this.properties = prop;
//        this.location =loc;
//    }
//
//
//    // 두개는 printer 전용
//    public int[] getProperties() {
//        return properties;
//    }
//    public int getLocation() {
//        return location;
//    }
//
//
//    //coloring 전용 테스트용
//    public void test(){
//
//
//        int[][] sample  = {{1, 1, 1, 0},{1, 2, 2, 0},{1, 0, 0, 1},{0, 0, 0, 1},{0, 0, 0, 3},{0, 0, 0, 3}} ;
//
//        System.out.println("m :" + sample.length +" \t n :"+sample[0].length);
//
//
//    }
//
//    //kamo
//
//    public void kamo(){
//        Programmers_kamo kamo = new Programmers_kamo();
//    }
//}
