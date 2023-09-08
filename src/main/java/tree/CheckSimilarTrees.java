package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/***
 * Given two binary tree, determine if they are the same or not.
 *
 * The two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 *
 * we will traverse both of the tree same time and check for same
 *
 * this soluton has time complexity of O(n)
 */

public class CheckSimilarTrees {

    private static Node<Integer> node1;
    private static Node<Integer> node2;
    
    // pre order traversal of both the tree and check for same
    public boolean checkForSimilarTrees(Node<Integer> node,Node<Integer> node1) {
        if(node == null || node1 == null) return node==null && node1==null;
        boolean ans = (node.value.equals(node1.value));
        boolean ans2 = checkForSimilarTrees(node.left,node1.left);
        boolean ans3 = checkForSimilarTrees(node.right,node1.right);
        return ans && ans2 && ans3;
    }


    public static void main(String[] args) {
        
        

        CheckSimilarTrees similarTrees = new CheckSimilarTrees();

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
        Node<String> i = new Node<>("i");
//
        //           a
        //       b      c
        //    d    e      f
        //  g   h    i
//
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        d.left=g;
        d.right=h;
        e.right=i;

        Node<String> a1 = new Node<>("a");
        Node<String> b1 = new Node<>("b");
        Node<String> c1 = new Node<>("c");
        Node<String> d1 = new Node<>("d");
        Node<String> e1 = new Node<>("e");
        Node<String> f1 = new Node<>("f");
        Node<String> g1 = new Node<>("g");
        Node<String> h1 = new Node<>("h");
        Node<String> i1 = new Node<>("i");

        //           a
        //       b      c
        //    d    e      f
        //  g   h    i

        a1.left=b1;
        a1.right=c1;
        b1.left=d1;
        b1.right=e1;
        c1.left=f1;
        d1.left=g1;
        d1.right=h1;
        e1.right=i1;

//        System.out.println(similarTrees.checkForSimilarTrees(a,a1));

        int n = 10;
        String [][] ar = {
                {"58 24 67 0 34 62 69 -1 -1 -1 41 -1 64 -1 78 -1 -1 -1 -1 -1 -1"},
                {"58 24 67 0 34 62 69 -1 -1 -1 41 -1 64 -1 78 -1 -1 -1 -1 -1 -1"},
                {"36 61 92 45 95 4 16 5 81 91 42 91 2 82 18 -1 -1 -1 27 -1 -1 -1 27 -1 -1 -1 53 -1 21 -1 95 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1"},
                {"36 61 92 45 95 4 16 5 81 91 42 91 2 82 98 -1 -1 -1 27 -1 -1 -1 27 -1 -1 -1 53 -1 21 -1 95 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1"},
                {"68 60 71 57 -1 -1 72 51 -1 -1 81 35 -1 -1 87 33 -1 -1 89 18 -1 -1 94 7 -1 -1 95 -1 -1 -1 -1"},
                {"68 60 71 57 -1 -1 72 51 -1 -1 81 35 -1 -1 87 33 -1 -1 89 18 -1 -1 94 7 -1 -1 95 -1 -1 -1 -1"},
                {"68 53 147 111 -1 -1 44 141 -1 -1 62 64 -1 -1 157 -1 -1 -1 -1"},
                {"68 53 147 111 -1 -1 44 141 -1 -1 62 64 -1 -1 157 -1 -1 -1 -1"},
    {"68 53 147 111 -1 -1 44 141 -1 -1 62 64 -1 -1 157 -1 -1 -1 -1"},
        {"68 53 147 111 -1 -1 44 141 -1 -1 62 -1 64 -1 157 -1 -1 -1 -1"},
        {"17 -1 19 -1 3 -1 1 -1 9 -1 18 -1 16 -1 15 -1 10 -1 2 -1 8 -1 6 -1 0 -1 2 -1 4 -1 8 -1 6 -1 5 -1 -1"},
        {"17 -1 19 -1 3 -1 1 -1 9 -1 18 -1 16 -1 15 -1 10 -1 2 -1 8 -1 6 -1 0 -1 2 -1 4 -1 8 -1 6 -1 5 -1 -1"},
        {"23 -1 38 -1 73 -1 81 -1 102 -1 143 -1 147 -1 164 -1 -1"},
        {"23 -1 38 -1 73 -1 81 -1 102 -1 143 147 -1 -1 164 -1 -1"},
        {"13 10 15 10 -1 -1 17 9 -1 -1 19 6 -1 -1 23 3 -1 -1 25 2 -1 -1 26 2 -1 -1 28 1 -1 -1 31 0 -1 -1 33 -1 -1 -1 33 -1 -1"},
        {"13 10 15 10 -1 -1 17 9 -1 -1 19 6 -1 -1 23 3 -1 -1 25 2 -1 -1 26 2 -1 -1 28 1 -1 -1 31 0 -1 -1 33 -1 -1 -1 33 -1 -1"},
        {"68 88 -1 137 -1 73 -1 26 -1 39 -1 144 -1 58 -1 131 -1 26 -1 16 -1 140 -1 6 -1 4 -1 84 -1 23 -1 129 -1 98 -1 93 -1 51 -1 6 -1 50 -1 70 -1 129 -1 140 -1 -1 -1"},
        {"68 88 -1 137 -1 73 -1 26 -1 39 -1 144 -1 58 -1 131 -1 26 -1 16 -1 140 -1 6 -1 4 -1 84 -1 23 -1 129 -1 98 -1 93 -1 51 -1 6 -1 50 -1 70 -1 129 -1 140 -1 -1 -1"},
        {"27 20 33 6 22 29 39 4 8 21 23 29 30 36 41 -1 -1 -1 15 -1 -1 -1 24 -1 -1 -1 32 -1 -1 -1 45 -1 -1 -1 -1 -1 -1 -1 -1"},
        {"27 20 33 6 22 29 39 4 8 21 23 29 30 36 41 -1 -1 -1 15 -1 -1 -1 24 -1 -1 -1 32 -1 -1 45 -1 -1 -1 -1 -1 -1 -1 -1 -1"}};

        for(int ii=0;ii<ar.length;ii=ii+2){
//            node1=null;
//            node2=null;
            String arr1 = ar[ii][0];
            String arr2 = ar[ii+1][0];
            node1 = new Node(-1);
            node2 = new Node(-1);
            Stream.of( arr1.split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
                insert(node1,ee,node1);
            });
            Stream.of( arr2.split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
                insert(node2,ee,node2);
            });

            System.out.println(similarTrees.checkForSimilarTrees(node1,node2));
        }




    }


    static void insert(Node temp, int key,Node root)
    {

//        if (temp == null) {
//            root = new Node(key);
//            return;
//        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }


}
