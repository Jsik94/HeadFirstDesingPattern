package codingTestWithJava;

public class Binary {
    public static void main(String[] args) {

        int size = 1000;
        int target = (int)(Math.random()*size);
        int[] data = new int[size];

        for (int i = 0 ; i < data.length ;i++){
            data[i] = i;
        }

        System.out.println(" "+size+"개 짜리 데이터를 가진 배열이 생성되었습니다.");
        System.out.println("타겟 데이터 : "+target+" \t 찾아주세요.");


        int start = 0;
        int end = data[size-1];

        int answer = binarySearch(start,end,target,0);

        System.out.println("데이터를 찾았습니다 : " + answer + "회 탐색 시행");
        System.out.println("선형 탐색 : " + target + "회 탐색 시행 \t 이진 탐색 : " + answer + "회 시행");

    }

    public static int binarySearch(int start,int end,int target,int cnt){

        int mid = (start+end)/2;

        //중앙값이 원하는 값이면 반환
        if(mid == target){
            return cnt;
        }



        //타겟이 중앙값 보다 왼쪽
        if( mid > target){
            //기준 범위가 왼쪽이 될 수 있게 end 변경
            end = mid -1;

        }else{
        //타겟이 중앙값 보다 오른쪽
            //기준 범위가 오른쪽이 될 수 있게 start 변경
            start = mid+1;

        }

        int result = binarySearch(start,end,target,cnt+1);

        return result;

    }



}
