package tree;


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

    // pre order traversal of both the tree and check for same
    public boolean checkForSimilarTrees(Node<String> node,Node<String> node1) {
        if(node == null && node1 == null) return node==node1;

        return (node.value== node1.value) && checkForSimilarTrees(node.left,node1.left) && checkForSimilarTrees(node.right,node1.right);
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

        System.out.println(similarTrees.checkForSimilarTrees(a,a1));

    }

}
