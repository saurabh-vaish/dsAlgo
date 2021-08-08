package Trie;
import java.util.*;


// this problem can be solved using hashset also
// using Trie is same as string Trie , just store each value of row as key

/**
 * @author Saurabh Vaish
 * @Date 20-06-2021
 */

class IntNode {
    private Integer value;
    private IntNode parent;
    private Map<Integer, IntNode> child;
    private boolean isTerminatingNode;

    public IntNode() {
        this.parent = null;
        this.child = new HashMap<>();
        this.isTerminatingNode = false;
    }

    public IntNode(Integer value) {
        this();
        this.value = value;
    }

    public void insert(int ar[],int index) {
        if(index>=ar.length){
            this.isTerminatingNode=true;
            return;
        }
        if(!this.child.containsKey(ar[index])){
            this.child.put(ar[index],new IntNode(ar[index]));
        }
        IntNode intNode = this.child.get(ar[index]);
        intNode.parent = this;
        intNode.value=ar[index];
        intNode.insert(ar, ++index);
    }

    List<String> getRows(){
        List<String> list = new ArrayList<>();

        StringBuffer str = new StringBuffer();
        getRowsData(this,list,str);
        return list;
    }

    private void getRowsData(IntNode intNode, List<String> list, StringBuffer str) {
        if(intNode.isTerminatingNode){
            list.add(str.toString());
        }
        if(intNode.child==null || intNode.child.size()==0)return;

        for(Map.Entry<Integer, IntNode> child : intNode.child.entrySet()){
            getRowsData(child.getValue(), list, str.append(child.getKey()));
            str.setLength(str.length()-1);
        }
    }

}

public class FindUniqueRowsInMatrix {

    public static void main(String[] args) {
        IntNode root = new IntNode();
        int arr[][] = { {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0} };

        for (int i = 0; i < arr.length; i++) {
            root.insert(arr[i],0);
        }

        root.getRows().forEach(System.out::println);

        System.out.println("using set =========");

//        Set<String> uniqueSet = new HashSet<>();
//        String str="";
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                str+=arr[i][j];
//            }
//            uniqueSet.add(str);
//            str="";
//        }
//
//        uniqueSet.forEach(System.out::println);

    }

}
