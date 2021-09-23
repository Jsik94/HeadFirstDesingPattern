package algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class Combination {

    public static void main(String[] args) {
        Combination test =new Combination();
    }

    public Combination() {
        int[] arr = {1,2,3,4,5};
        boolean[] visit= new boolean[arr.length];
        int r = 2;
        int[] output = new int[r];
        ArrayList<int[]> list = new ArrayList<>();

        combination(arr,visit,0,arr.length,2,output,list);

        Collections.sort(list,(o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }else{
                return o1[0] - o2[0];
            }
        });

        for (int[] datas : list){
            System.out.print("[ ");
            for (int data : datas){
                System.out.print(data+" ");
            }
            System.out.print("] ");
        }
    }


    void combination(int[] arr, boolean[] visit,int start,int N,int r,int[] output,ArrayList<int[]> list){

        if(r ==0){
            list.add(output.clone());
            return;
        }

        for (int i = start ; i <N ; i++){
            visit[i] = true;
            output[r-1] = arr[i];
            combination(arr,visit,i+1,N,r-1,output,list);
            visit[i] = false;
        }

    }

}
