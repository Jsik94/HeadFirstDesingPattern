package java_theory.ioPractice;

import java.io.*;
import java.util.Arrays;

public class DataIOstream {

    public static void main(String[] args) {

        int k = 1233;
        byte[] a = {67,68,69,70};
        String data = "Hello World!";

        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/java_theory/ioPractice/datas/test.dat"));
            dos.writeInt(k);
            dos.write(a);
            dos.writeUTF(data);
            dos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //데이터 다넣음 !

        System.out.println("Get out !");

        try {
            DataInputStream dis  = new DataInputStream(new FileInputStream("src/java_theory/ioPractice/datas/test.dat"));
            int r_k = dis.readInt();
            byte[] barr = new byte[4];
            dis.read(barr);
            String r_data = dis.readUTF();
            System.out.println(r_k);
            System.out.println(Arrays.toString(barr));
            System.out.println(r_data);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
