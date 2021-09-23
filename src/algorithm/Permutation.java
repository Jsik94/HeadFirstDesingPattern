package algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation test = new Permutation();
    }

    public Permutation() {
        int[] arr = {1,2,3};
        boolean[] visit= new boolean[arr.length];
        int r = 2;
        int[] output = new int[r];
        ArrayList<int[]> list = new ArrayList<>();

        Arrays.sort(arr);

        permutation(arr,visit,0, arr.length,r,output,list);


        for (int[] datas : list){
            System.out.print("[");
            for (int data :datas){
                System.out.print(data+" ");
            }

            System.out.print("] ");
        }


    }


    void permutation(int[] arr, boolean[] visit, int depth, int N, int r, int[] output, ArrayList<int[]> list){

        if(depth == r){
            //클론하는거 주의!! 참조형이라 얕은복사됨
            list.add(output.clone());
            for (int data : output){
                System.out.print(data+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 0 ; i < N ; i++){

            if(!visit[i]){
                visit[i] = true;
                output[depth] = arr[i];
                permutation(arr,visit,depth+1,N,r,output,list);
                visit[i] = false;
            }


        }

    }

}
