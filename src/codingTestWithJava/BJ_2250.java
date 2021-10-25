package codingTestWithJava;

/*
https://www.acmicpc.net/problem/2250
트리의 높이와 너비 출처
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	13541	3788	2580	27.132%
문제
이진트리를 다음의 규칙에 따라 행과 열에 번호가 붙어있는 격자 모양의 틀 속에 그리려고 한다. 이때 다음의 규칙에 따라 그리려고 한다.

이진트리에서 같은 레벨(level)에 있는 노드는 같은 행에 위치한다.
한 열에는 한 노드만 존재한다.
임의의 노드의 왼쪽 부트리(left subtree)에 있는 노드들은 해당 노드보다 왼쪽의 열에 위치하고, 오른쪽 부트리(right subtree)에 있는 노드들은 해당 노드보다 오른쪽의 열에 위치한다.
노드가 배치된 가장 왼쪽 열과 오른쪽 열 사이엔 아무 노드도 없이 비어있는 열은 없다.
이와 같은 규칙에 따라 이진트리를 그릴 때 각 레벨의 너비는 그 레벨에 할당된 노드 중 가장 오른쪽에 위치한 노드의 열 번호에서 가장 왼쪽에 위치한 노드의 열 번호를 뺀 값 더하기 1로 정의한다. 트리의 레벨은 가장 위쪽에 있는 루트 노드가 1이고 아래로 1씩 증가한다.

아래 그림은 어떤 이진트리를 위의 규칙에 따라 그려 본 것이다. 첫 번째 레벨의 너비는 1, 두 번째 레벨의 너비는 13, 3번째, 4번째 레벨의 너비는 각각 18이고, 5번째 레벨의 너비는 13이며, 그리고 6번째 레벨의 너비는 12이다.



우리는 주어진 이진트리를 위의 규칙에 따라 그릴 때에 너비가 가장 넓은 레벨과 그 레벨의 너비를 계산하려고 한다. 위의 그림의 예에서 너비가 가장 넓은 레벨은 3번째와 4번째로 그 너비는 18이다. 너비가 가장 넓은 레벨이 두 개 이상 있을 때는 번호가 작은 레벨을 답으로 한다. 그러므로 이 예에 대한 답은 레벨은 3이고, 너비는 18이다.

임의의 이진트리가 입력으로 주어질 때 너비가 가장 넓은 레벨과 그 레벨의 너비를 출력하는 프로그램을 작성하시오

입력
첫째 줄에 노드의 개수를 나타내는 정수 N(1 ≤ N ≤ 10,000)이 주어진다. 다음 N개의 줄에는 각 줄마다 노드 번호와 해당 노드의 왼쪽 자식 노드와 오른쪽 자식 노드의 번호가 순서대로 주어진다. 노드들의 번호는 1부터 N까지이며, 자식이 없는 경우에는 자식 노드의 번호에 -1이 주어진다.

출력
첫째 줄에 너비가 가장 넓은 레벨과 그 레벨의 너비를 순서대로 출력한다. 너비가 가장 넓은 레벨이 두 개 이상 있을 때에는 번호가 작은 레벨을 출력한다.

결국 하나의 페어가 가지고 있어야하는 정보

자기 자신
왼쪽
오른쪽
레벨


 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ_2250 {

    MyNode[] myNodes;


    public static void main(String[] args) throws IOException {
        BJ_2250 test = new BJ_2250();
    }

    public BJ_2250() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk;
        int cnt_Node = Integer.parseInt(br.readLine());
        myNodes = new MyNode[cnt_Node + 1];

        //level , dist
        HashMap<Integer, ArrayList<Integer>> dist_per_lv = new HashMap<>();

        for (int i = 1 ; i <=cnt_Node ;i++){
            myNodes[i] = new MyNode(i,-1);
        }

        for (int i = 0; i < cnt_Node; i++) {
            stk = new StringTokenizer(br.readLine(), " ");
            int self = Integer.parseInt(stk.nextToken());
            int left = Integer.parseInt(stk.nextToken());
            int right = Integer.parseInt(stk.nextToken());


            myNodes[self].left = left;
            myNodes[self].right = right;

            if(left != -1){
                myNodes[left].parents = self;
            }
            if(right != -1){
                myNodes[right].parents = self;
            }



        }

        int root = 1;

        for (int i = 1 ; i <=cnt_Node ;i++){
            if(myNodes[i].parents ==-1){
                root = i;
            }
        }


        getNodeCnt( root, 1, 0, 0);
        setAbsDistance(root);
        for (int i = 1 ; i < myNodes.length ; i++){
            if(!dist_per_lv.containsKey(myNodes[i].depths)){
                dist_per_lv.put(myNodes[i].depths,new ArrayList<>());
            }
            dist_per_lv.get(myNodes[i].depths).add(myNodes[i].abs_dist);
        }

        int depths =0 , max =0;
        for (Map.Entry<Integer, ArrayList<Integer>> entry : dist_per_lv.entrySet()){
            int data =Collections.max(entry.getValue())-Collections.min(entry.getValue())+1;
            if(max < data){
                depths = entry.getKey();
                max = data;
            }
        }

        System.out.println(depths+" "+max);
    }


    private int getNodeCnt( int cur, int levels, int parent, int ways) {

        if (cur == -1) {
            return 0;
        }


        int left = 0;
        int right = 0;

        left = getNodeCnt( myNodes[cur].left, levels + 1, cur, 1);
        right = getNodeCnt( myNodes[cur].right, levels + 1, cur, 2);



        System.out.println("<------>");
        System.out.println("현재 레벨 : " + levels);
        System.out.println("현재 값 : " + cur);
        System.out.println("왼자식의 수 " + left);
        System.out.println("오른자식의 갯수 " + right);
        int rel_dist = 0;
        if (ways == 1) {
            rel_dist = -(1 + right);


        } else if (ways == 2) {
            rel_dist = 1 + left;


        }

        System.out.println("부모와의 상대거리 : " + rel_dist);
        myNodes[cur].abs_dist = rel_dist;
        myNodes[cur].depths = levels;
        return left + right + 1;
    }


    private void setAbsDistance(int cur){

        if (cur ==-1){
            return;
        }
        int ac = myNodes[cur].abs_dist;
        if(myNodes[cur].parents !=-1){
            ac += myNodes[myNodes[cur].parents].abs_dist;
        }
        myNodes[cur].abs_dist = ac;
        setAbsDistance(myNodes[cur].left);
        setAbsDistance(myNodes[cur].right);

    }


    class MyNode {
        int parents;
        int myNo;
        int left = -1;
        int right = -1;
        int abs_dist;
        int depths;


        public MyNode(int myNo, int parents) {
            this.myNo = myNo;
            this.parents = parents;
        }


    }

}
