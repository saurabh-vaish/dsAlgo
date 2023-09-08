package Trie.series;

class Node{

        Node [] node = new Node[26];
        boolean isEnd = false;  // to check weather a string is completed

        char value;
        public Node(){}

        public Node(char v){
            value=v;
        }

        public boolean contains(char ch){
            return node[ch-'a']!=null;
        }

        public void add(char ch,Node nnode){
            node[ch-'a']=nnode;
        }

        public Node get(char ch){
            return node[ch-'a'];
        }

        public void setIsEnd(){
            isEnd=true;
        }

        public boolean getIsEnd(){return isEnd;}

}
   

public class Trie {


    //Initialize your data structure here

    
    static Node root= null;

    Trie() {
        //Write your code here
        root = new Node();
    }


    //Inserts a word into the trie

    public static void insert(String word) {
        //Write your code here
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){             // if char does not exist in trie then add that node
//                node.add(ch, new Node());
                node.add(ch, new Node(ch));
            }
            node = node.get(ch);
        }
        node.setIsEnd();
    }


    //Returns if the word is in the trie

    public static boolean search(String word) {
        //Write your code here
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        if(node.getIsEnd())return true;
        
        return false;
    }

    
    //Returns if there is any word in the trie that starts with the given prefix

    public static boolean startsWith(String word) {
        //Write your code here
        Node node = root;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            if(!node.contains(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }


    public static void main(String args[])
    {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
//        String value[] = {"hello", "help", "help", "hel", "hel"};
        String value[] = "cod coding codding code coly".split(" ");
        Trie trie=new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            }
            else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println( "true" );
                }
                else {
                    System.out.println("false");
                }
            }
            else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true" );
                }
                else {
                    System.out.println("false");
                }
            }
        }

        for(String v:value){
            trie.insert(v);
        }

        System.out.println(root);
    }

}