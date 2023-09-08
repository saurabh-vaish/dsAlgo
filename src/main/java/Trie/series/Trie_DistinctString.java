package Trie.series;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?leftPanelTab=1
 *
 *  program to count all the distinct substring that could be found in a given string , including empty one
 *
 *
 * @Author saurabh vaish
 * @Date 16-06-2023
 */




class D_Node{

    D_Node [] node = new D_Node[26];

    public D_Node(){}

    public boolean contains(char ch){
        return node[ch-'a']!=null;
    }

    public void add(char ch,D_Node nnode){
        node[ch-'a']=nnode;
    }

    public D_Node get(char ch){
        return node[ch-'a'];
    }

}
public class Trie_DistinctString {

    private static D_Node root = new D_Node();

    public static int countDistinctSubstrings(String s)
    {
        root = new D_Node();

        int total =0; // empty substring

        for(int i=0;i<s.length();i++){  // for given string length
            D_Node node = root; // after completion of each char , get a new node for new substring

            for(int j=i;j<s.length();j++){ // again from i to get all the substrings till end
                char ch = s.charAt(j);

                // here we are doing both insertion and counting
                if(!node.contains(ch)){
                    total++;
                    node.add(ch, new D_Node());
                }
                node = node.get(ch);
            }
        }

        return total+1;
    }


    public static void main(String[] args) {
//        String ar[] = {"sds", "abc", "aa", "abab","naman"};
        String ar[] = {"naman"};
//        Trie_CompleteString t = new Trie_CompleteString();

        for(int i=0;i<ar.length;i++) {
            System.out.println(countDistinctSubstrings(ar[i]));
        }

    }



}
