package java_theory.ioPractice;

import java_theory.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ObjectIOStream {

    public static void main(String[] args) {

        List<Custom> cs = new ArrayList<>();
        cs.add(new Custom(1,2,"으어아"));
        cs.add(new Custom(2,2,"으어아12"));
        cs.add(new Custom(3,2,"으어아23"));
        cs.add(new Custom(4,2,"으어아23"));



        try {
            ObjectOutputStream dos = new ObjectOutputStream(new FileOutputStream("src/java_theory/ioPractice/datas/test.txt"));
            dos.writeObject(cs);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //데이터 다넣음 !

        System.out.println("Get out !!@!@");

        try {
            ObjectInputStream dis  = new ObjectInputStream(new FileInputStream("src/java_theory/ioPractice/datas/test.txt"));
            List<Custom> a = (List<Custom>) dis.readObject();

            for (Custom k : a){

                System.out.println(k.age +" " + k.kk);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static class Custom implements Serializable{
        int age;
        int id;
        String kk;

        public Custom(int i, int i1, String 아몰랑_ㅋ) {
            this.age =i;
            this.id = i1;
            this.kk = 아몰랑_ㅋ;

        }
    }
}
