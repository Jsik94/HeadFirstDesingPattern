package java_theory.collectionStudy;

import java.util.Locale;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);

        while(true){
            String data = sc.nextLine().trim();

            if(data.equals("999")){
                break;
            }

            String result =CommonUtility.getFirstCharacter(data);
            System.out.println(result);

        }

    }
}
