package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Saurabh Vaish
 * @Date 19-06-2021
 */
public class TrieNode {

    private Character value; // store current char in node

    private TrieNode parent;  // link to parent node by default contains null as root has no parent

    private Map<Character,TrieNode> children ;  // stores the children of node including current node

    private boolean isTerminateNode; // for marking a node as terminating node

    public TrieNode(){
        this.children=new HashMap<>();
        this.parent=null;
        this.isTerminateNode=false;
    }

    public TrieNode(Character value){
        this();
        this.value=value;
    }

    public boolean isTerminatingNode(){
        return this.isTerminateNode;
    }

    public void setParent(TrieNode node){
        this.parent=node;
    }

    public void addWord(String prefix){
        if(prefix==null || prefix.isEmpty())return;

        char currentChar = prefix.charAt(0);

        this.value=currentChar;  // assigning current char value to node

        if(!this.children.containsKey(currentChar)){ // if this not exist in children as its new char then add as children
            this.children.put(currentChar, new TrieNode(currentChar));  // add children as new node
        }

        TrieNode presentNode = children.get(currentChar);  // getting current node that contains char ,for very first char one will be current as well as parent
        presentNode.setParent(this);  // setting current calling node as parent node

        if(prefix.length()==1){  // means word has been complete so mark as terminating node
            presentNode.isTerminateNode = true;
        }else{
            presentNode.addWord(prefix.substring(1));  // if word has mode chars then add them.
        }

    }

    public List<String> displayAll(){
        List<String> list = new ArrayList<>();
        displayAllWords(this, new StringBuffer(), list);
        return list;
    }

    // method to display all the words in trie
    public void displayAllWords(TrieNode node,StringBuffer str,List<String> list){
        if(node.isTerminateNode){   // if terminating node then means word has been complete add to list
            list.add(str.toString());
        }

        if(node.children==null || node.children.size()==0){  // means no more child traverse back to calling root node
            return;
        }

        for(Map.Entry<Character,TrieNode> child :node.children.entrySet())
        {
            displayAllWords(child.getValue(), str.append(child.getKey()), list);  // call child nodes
            str.setLength(str.length()-1);  // recursion calling is completed ,traversing back to first call ,so reducing string as we are going back
                                            // so calling string should also get reduce otherwise it will add in other words
        }
    }


    // find all matching words with given prefix , if withExacWord is true then it will start from exact prefix if false then it will start with last matching char
    public List<String> findWordWithPrefix(String prefix,boolean withExactWord){
        List<String> list = new ArrayList<>();

        TrieNode child=this; // assigning the node with root
        StringBuffer str=new StringBuffer();
        for(char c:prefix.toCharArray()){
            if(withExactWord){
                child = child.children.get(c); // getting child node from which we need to search
                if(child==null)return list;  // if null means word not present
            }else{
                TrieNode temp = child.children.get(c); // getting child node from which we need to search
                if(temp==null)continue;  // if null means word not present
                child=temp;
            }
            str.append(c);
        }
        displayAllWords(child, new StringBuffer(str), list);
        return list;
    }


    public static void main(String[] args) {
        TrieNode root = new TrieNode();
//        String[] arr = {"app","apple", "boy", "bluetooth","tooth", "yacht"};
//        String [] arr = { "hello", "dog", "hell", "cat", "a", "hel","help","helps","helping"};
        String[] arr = {"geeks", "for", "geeks", "a", "portal", "to", "learn", "can", "be", "computer", "science", "zoom", "yup", "fire", "in", "data"};
        for (String str : arr) {
            root.addWord(str);
        }

        root.displayAll().forEach(System.out::println);
        root.findWordWithPrefix("help",true).forEach(System.out::println);
//        System.out.println(root.countSubString());
    }

}
