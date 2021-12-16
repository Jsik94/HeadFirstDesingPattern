package codingTestWithJava;

import java.util.Random;

public class TestForNumGen {

    public static void main(String[] args) {
        System.out.println(NumberGen.getGen(4));
    }
}

class NumberGen {


    public static String getGen(int len) {

        Random rand  = new Random();
        String numStr = "";
        for(int i=0; i<len; i++) {
            String ran = Integer.toString(rand.nextInt(10));
            numStr+=ran;
        }

        return numStr;
    }

}
