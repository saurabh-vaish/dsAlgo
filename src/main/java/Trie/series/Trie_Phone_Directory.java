package Trie.series;

import java.util.ArrayList;
import java.util.List;

/**
 * @Link = https://www.codingninjas.com/studio/problems/implement-a-phone-directory_1062666?leftPanelTab=0
 *
 * @Author saurabh vaish
 * @Date 20-06-2023
 */


class P_Node{
    P_Node[] node = new P_Node[26];
    char value;

    boolean isEnd = false;

    public void set(char ch,P_Node pnode){
        pnode.value=ch;
        node[ch-'a']=pnode;
    }

    public P_Node get(char ch){
        return node[ch-'a'];
    }

    public boolean contains(char ch){
        return node[ch-'a']!=null;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean getEnd(){
        return isEnd;
    }

    public P_Node[] getNode(){
        return node;
    }

    public char getValue(){
        return value;
    }

}

public class Trie_Phone_Directory {

    private static P_Node root = new P_Node();

    public static void insert(String str){
        P_Node node = root;
        for(char ch:str.toCharArray()){
            if(!node.contains(ch)){
                node.set(ch,new P_Node());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }


    // get the char from query
    // get the node starting from that char
    // loop all possible chars and form string
    // add that string to list and reset node to root
    // get another char and add it with previous one
    // first match the prefix till the query and repeat process

    public static List<List<String>> search(String query){
        List<List<String>> dir = new ArrayList<>();

        P_Node node = root;

        for(char ch:query.toCharArray()){
            node = root;
            List<String> list = new ArrayList<>();
            String word = "";

            if(node.contains(ch)){
                word+=node.get(ch);
            }

        }

        return dir;
    }

    public static P_Node getNodeStartsWithPrefix(char ch,P_Node node){
        if(node ==null || node.getEnd())return node;

        if(node.contains(ch)){
            node = node.get(ch);
            return node;
        }

        return getNodeStartsWithPrefix(ch,node);
    }

    public static List<String> getAllWords(P_Node node,char ch){
        List<String> list = new ArrayList<>();
        String word = String.valueOf(ch);

       for(P_Node nod:node.getNode()){
           word+=nod.getValue();
       }

        System.out.println(word);

        return list;
    }

    public static void main(String args[])
    {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
//        String value[] = {"hello", "help", "help", "hel", "hel"};
        String value[] = "cod coding codding code coly".split(" ");

        for(String v:value){
            insert(v);
        }

        getAllWords(root,'c');

        System.out.println(root);
    }



}
