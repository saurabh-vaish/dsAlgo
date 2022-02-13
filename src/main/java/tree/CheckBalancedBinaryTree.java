package tree;


/***
 * Given a binary tree, determine if it is height-balanced.
 *
 * A tree is height-balanced if the left and right subtrees of every node differ in height by no more than 1.
 *  leftSubtreeHeight - rightSubtreeHeight is 0 or 1
 *
 * this soluton has time complexity of O(n)
 */

public class CheckBalancedBinaryTree {

    public boolean checkBalancedBinaryTree(Node<String> root) {
        return dfsHeight(root) != -1;
    }

    // first get height of the subtree and at any point of node if the height diff is greater than 1 means its not a balanced tree so return -1;
    private int dfsHeight(Node<String> root) {
        if(root == null) return 0;
        int leftHeight = dfsHeight(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = dfsHeight(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1)return -1;

        return Math.max(leftHeight,rightHeight) + 1 ;  // getting height of node
    }


    public static void main(String[] args) {

        CheckBalancedBinaryTree checkBalancedBinaryTree = new CheckBalancedBinaryTree();

//        Node<String> a = new Node<>("a");
//        Node<String> b = new Node<>("b");
//        Node<String> c = new Node<>("c");
//        Node<String> d = new Node<>("d");
//        Node<String> e = new Node<>("e");
//        Node<String> f = new Node<>("f");
//        Node<String> g = new Node<>("g");
//        Node<String> h = new Node<>("h");
//        Node<String> i = new Node<>("i");
//
//        //           a
//        //       b      c
//        //    d    e      f
//        //  g   h    i
//
//        a.left=b;
//        a.right=c;
//        b.left=d;
//        b.right=e;
//        c.left=f;
//        d.left=g;
//        d.right=h;
//        e.right=i;

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
//        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
//        Node<String> i = new Node<>("i");

        //           a
        //       b      c
        //    d    e      f
        //  g   h    i

        a.left=b;
        a.right=c;
        b.left=d;
//        b.right=e;
        c.left=f;
        d.left=g;
        d.right=h;
//        e.right=i;

        System.out.println(checkBalancedBinaryTree.checkBalancedBinaryTree(a));

    }

}
