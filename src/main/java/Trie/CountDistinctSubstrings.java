package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// this problem can be solved using hashset also
// using Trie is same as string Trie , just store each value of row as key

/**
 * @author Saurabh Vaish
 * @Date 20-06-2021
 */

class Node {
    private char value;
    private Node parent;
    private Map<Character, Node> child;
    private boolean isTerminatingNode;

    public Node() {
        this.parent = null;
        this.child = new HashMap<>();
        this.isTerminatingNode = false;
    }

    public Node(Character value) {
        this();
        this.value = value;
    }

    public void insert(String str) {
        if(str.isEmpty())return;
        char currentChar = str.charAt(0);
        if(!this.child.containsKey(currentChar)){
            this.child.put(currentChar,new Node(currentChar));
        }
        Node node = this.child.get(currentChar);
        node.parent = this;
        node.value=currentChar;
        if(str.length()==1){
            this.isTerminatingNode=true;
            return;
        }else{
            node.insert(str.substring(1));
        }

    }

    List<String> getRows(){
        List<String> list = new ArrayList<>();

        StringBuffer str = new StringBuffer();
        getRowsData(this,list,str);
        return list;
    }

    private void getRowsData(Node node, List<String> list, StringBuffer str) {
        if(node.isTerminatingNode){
            list.add(str.toString());
        }
        if(node.child==null || node.child.size()==0)return;

        for(Map.Entry<Character, Node> child : node.child.entrySet()){
            getRowsData(child.getValue(), list, str.append(child.getKey()));
            str.setLength(str.length()-1);
        }
    }

    public int countSubString(){
        StringBuffer count=new StringBuffer();
        System.out.println("substrings == ");
        getSubStringCount(this,new StringBuffer(),count);
        return count.length()+1;
    }

    private void getSubStringCount(Node node,StringBuffer s,StringBuffer count) {
        if(node==null || node.child.size()==0)return;

        for(Map.Entry<Character,Node> child :node.child.entrySet()){
            s.append(child.getKey());
            System.out.println(s);
            count.append("a");
            getSubStringCount(child.getValue(),s,count);
            s.setLength(s.length()-1);
        }

//        return 1+count;
    }



}

public class CountDistinctSubstrings {

    public static void main(String[] args) {
        Node root = new Node();
       String str="ababa";

       if(str==null || str.isEmpty()){
           System.out.println("Not a valid string");
       }

        for (int i = 0; i < str.length(); i++) {
            root.insert(str.substring(i));
        }

        System.out.println("total substrings"+root.countSubString());

//        root.getRows().forEach(System.out::println);


    }

}
