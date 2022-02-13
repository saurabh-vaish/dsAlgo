package tree;


/***
 * Given a binary tree, determine the diameter of the tree.
 *
 * the diameter of the tree is the distance between the two deepest nodes
 *
 * for the solution will get left height and right height of every node in tree and ad after that fine the max of them
 *  -- longest path between two nodes
 *  -- it may or may not pass root node
 *
 * this soluton has time complexity of O(n)
 */

public class DiameterOfTheTree {

    public int diameterOfTheTree(Node<String> root) {

        int dai[] = new int[1];          // here we are using this array to store the max height of the tree as recursion will return only one at a time
        this.heightOfTheTree(root,dai);
        return dai[0];

    }

    // first get height of the subtree and at any point of node if the height diff is greater than 1 means its not a balanced tree so return -1;
    private int heightOfTheTree(Node<String> root, int[] dai) {
        if(root == null) return 0;

        int leftHeight = heightOfTheTree(root.left,dai);
        int rightHeight = heightOfTheTree(root.right,dai);

        dai[0] = Math.max(dai[0],leftHeight+rightHeight);  // adding height of left and right subtree and finding the max of them

        return Math.max(leftHeight,rightHeight) + 1 ;  // getting height of node
    }


    public static void main(String[] args) {

        DiameterOfTheTree diameterOfTheTree = new DiameterOfTheTree();

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
        //    d          f
        //  g   h
        //        i

        a.left=b;
        a.right=c;
        b.left=d;
//        b.right=e;
        c.left=f;
        d.left=g;
        d.right=h;
        h.right=new Node<>("i");
//        e.right=i;

        System.out.println(diameterOfTheTree.diameterOfTheTree(a));

    }

}
