package Trie.series;

/**
 * @Link = https://www.codingninjas.com/codestudio/problems/implement-trie_1387095
 *
 * program to count how many time the string is present
 *
 * @Author saurabh vaish
 * @Date 14-06-2023
 */


class TrieCountNode{
    TrieCountNode[] countNode = new TrieCountNode[26]; // as max 26 chars allowed
    int endCount=0;  // how many strings are inserted , when they are ending increase end , used in string count
    int prefixCount=0; // on each successful insertion of a char , increase prefix , used in prefix count

    public TrieCountNode(){

    }

    public void insert(char ch,TrieCountNode node){
        countNode[ch-'a']=node;
    }

    public boolean contains(char ch){
        return countNode[ch-'a']!=null;
    }

    public TrieCountNode get(char ch){
        return countNode[ch-'a'];
    }

    public void increasePrefix(){prefixCount++;}

    public void increaseEnd(){endCount++;}

    public void decreasePrefix(){prefixCount--;}

    public void decreaseEnd(){endCount--;}

    public int getPrefix(){return prefixCount;}

    public int getEnd(){return endCount;}



}

public class Trie2_CountingWords {

    private TrieCountNode root = null;

    public Trie2_CountingWords(){
        root = new TrieCountNode();
    }

    public void insert(String word) {
        TrieCountNode node = root;
        for(char ch :word.toCharArray()){
            if(!node.contains(ch)){
                node.insert(ch,new TrieCountNode());
            }
            node = node.get(ch);
            node.increasePrefix(); // on successful insertion increase prefix , to know how many time same char is inserted as in trie every char inserted only once
        }
        node.increaseEnd(); // after insertion increase end count
    }

    public int countWordsEqualTo(String word) {
        TrieCountNode node = root;
        for(char ch :word.toCharArray()){
            if(node.contains(ch)){
                node=node.get(ch);
            }
            else{
                return 0;  // if any char not matched then not exist
            }
        }
        return node.getEnd();  // to check whole string we need end count
    }

    public int countWordsStartingWith(String word) {
        TrieCountNode node = root;
        for(char ch :word.toCharArray()){
            if(node.contains(ch)){
                node=node.get(ch);
            }
            else{
                return 0;  // if any char not matched then not exist
            }
        }
        return node.getPrefix();  // for start with we need prefix count
    }

    public void erase(String word) {
        TrieCountNode node = root;
        for(char ch :word.toCharArray()){
            if(node.contains(ch)){
                node=node.get(ch);
                node.decreasePrefix();  // on removal of each char remove prefix
            }
        }
        node.decreaseEnd(); // on removal of each string decrease end
    }

    public static void main(String args[])
    {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};

        Trie2_CountingWords T=new Trie2_CountingWords();
        T.insert("apple");
        T.insert("apple");
        T.insert("apps");
        T.insert("apps");

        String word1 = "apps";
        System.out.println("Count Words Equal to "+word1+" "+T.countWordsEqualTo(word1));

        String word2 = "abc";
        System.out.println("Count Words Equal to "+word2+" "+T.countWordsEqualTo(word2));

        String word3 = "ap";
        System.out.println("Count Words Starting With "+word3+" "+T.countWordsStartingWith(word3));

        String word4 = "appl";
        System.out.println("Count Words Starting With "+word4+" "+T.countWordsStartingWith(word4));

        T.erase(word1);
        System.out.println("Count Words equal to "+word1+" "+T.countWordsEqualTo(word1));
    }

}
