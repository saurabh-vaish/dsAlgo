package Trie.series;

/**
 *
 * @Link = https://www.codingninjas.com/codestudio/problems/complete-string_2687860
 *
 *  find the complete string , a complete string is one in which all other strings can come , and if two are same return lexicographically small
 *
 * @Author saurabh vaish
 * @Date 15-06-2023
 */


class C_Node{

    C_Node [] node = new C_Node[26];
    boolean isEnd = false;  // to check weather a string is completed

    public C_Node(){}

    public boolean contains(char ch){
        return node[ch-'a']!=null;
    }

    public void add(char ch,C_Node nnode){
        node[ch-'a']=nnode;
    }

    public C_Node get(char ch){
        return node[ch-'a'];
    }

    public void setIsEnd(){
        isEnd=true;
    }

    public boolean getIsEnd(){return isEnd;}

}



public class Trie_CompleteString {
    private static C_Node root = null;

    public Trie_CompleteString(){
        root = new C_Node();
    }

    public static void insert(String word){
        C_Node node = root;
        for(char ch:word.toCharArray()){
            if(!node.contains(ch)){
                node.add(ch,new C_Node());
            }
            node = node.get(ch);
        }
        node.setIsEnd();
    }

    public static boolean checkIfPrefixExist(String a){
        C_Node node = root;
        boolean flag=true;

        for(char ch:a.toCharArray()){
            if(node.contains(ch)){
                node = node.get(ch);
                flag= flag & node.getIsEnd();  // check for given char , all previous char exist in string
            }else{
                return false;
            }
        }
        return flag;
    }

    public static String completeString(int n,String [] ar){
        root = new C_Node();

        // first insert every string in trie
        for(String a:ar){
            insert(a);
        }

        String longest="";
        for(String a:ar){

            if(checkIfPrefixExist(a)){  // check if given string exist in try of not
                if(a.length()>longest.length()){  // check length of word and longest
                    longest = a;
                }else if(a.length() == longest.length() && a.compareTo(longest)<0){ // if length are same , choose which is lexicographically small
                    longest = a;
                }
            }
        }

        if(longest.length()==0)return "None";
        return longest;
    }

    public static void main(String[] args) {
        int n = 3;
        String ar[][] = {"n ni nin ninj ninja ninga".split(" "),"ak szhkb a g hy ".split(" "),"vfjq kez vfj dotkr vfjqo ".split(" "),"n l i um ar xcfyc ".split(" ")};
//        Trie_CompleteString t = new Trie_CompleteString();

        for(int i=0;i<n;i++) {
            String value [] = ar[i];

            System.out.println(completeString(value.length, value));
        }

    }



}
