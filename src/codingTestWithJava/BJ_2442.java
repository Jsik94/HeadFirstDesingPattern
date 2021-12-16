package codingTestWithJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2442 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());

        for(int i = 1 ; i <= cnt ; i++){

            for (int k = 0 ; k < cnt-i ; k++){
                sb.append(" ");
            }
            for (int j = 0 ; j < i*2-1 ;j++){
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
