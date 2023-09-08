package Trie.series;

/**
 * @Link =
 *
 *  Find the maximum XOR in a given array .
 *   XOR ==> Changed the bit , if bits are same return 0 else 1
 *
 *  In a 32 bit system , the binary represents are 32 bit long in length ,
 *  In Trie we will store a numbers binary and then will match bith given no binary
 *
 * @Author saurabh vaish
 * @Date 19-06-2023
 */


class B_Node{
    B_Node[] root = new B_Node[2]; // 2 , i for 0 and another for 1
    public void set(int bit,B_Node node){
        root[bit]=node;
    }

    public B_Node get(int bit){
        return root[bit];
    }

    public boolean contains(int bit){
        return root[bit]!=null;
    }

}

public class Trie_Maxium_XOR_1 {

    private static B_Node root = new B_Node();

    public Trie_Maxium_XOR_1(){
        root = new B_Node();
    }


    public static void insert(int num){
        B_Node node = root;
        for(int i=31;i>=0;i--){ // loop to 32 as bits are 32 in length
            int bit = ( num>>i ) & 1;  // right shifting till i to get right most bits one by one and check if its set or not
            if(!node.contains(bit)){
                node.set(bit,new B_Node());
            }
            node = node.get(bit);

        }
    }

    public static int findMax(int x){
        B_Node node = root;
        int max = 0;
        for(int i=31;i>=0;i--){
            int bit = (x>>i) & 1; // getting the rightmose bit one by one and checking if its set bit (1) or not
            if(node.contains(1-bit)){  // checking if its containing opposite of this bit , by removing from 1 , so that we have maximum XOR
                max = max | (1<<i) ;  // shifting 1 to right to form number , and then getting OR with max ;
                node = node.get(1-bit); // get the opposite bit
            }else{
                node = node.get(bit);
            }
        }

        return max;

    }


    public static void main(String[] args) {
        int [] ar= {9,8,7,5,4};

        for(int a:ar){
            insert(a);
        }

        int max = findMax(8);

        System.out.println("Maximum XOR"+max);

    }



}
