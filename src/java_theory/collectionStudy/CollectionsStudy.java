package java_theory.collectionStudy;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class CollectionsStudy {


    /*
           Arrays.sort() 배열 계열 정리
           Collections.sort() 객체 계열 정리

           Iterator는 데이터를 빼오는 방식을 표준화하는데 그 목적이 있기 때문에 코드의 재활용이 가능하다.(다형성)

           Enumeration은 Iterator에서 remove() 메소드만 빠지고, 이름만 다를 뿐 사용법은 같다.

     */


    public static void main(String[] args) {


    }

    public CollectionsStudy() {


    }

    public void vectorExample(){
        Vector<Info> vector = new Vector<>();

        for (int i =0 ; i < 20 ; i++){
            vector.add(new Info());
        }

        Iterator<Info> itr = vector.iterator();
        while (itr.hasNext()){

            System.out.println(itr.next().showInfo());
        }

        Enumeration<Info> em = vector.elements();

    }


    public void treeMapCalss(){

    }




    class Info{
        int data1;
        String data2;
        char data3;

        public Info() {
            this(12,"UNKOWN",'A');
        }

        public Info(int data1, String data2, char data3) {
            this.data1 = data1;
            this.data2 = data2;
            this.data3 = data3;
        }

        public String showInfo(){

            return String.format("%3d %10s %c",data1,data2,data3);
        }
    }

}
