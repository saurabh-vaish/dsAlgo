package tree;


/***
 * Given a binary tree, determine the maximum path sum of the tree.
 *
 * the maximum path sum of the tree is the max sum between the two deepest nodes
 *
 * for the solution will get left sum and right sum of every node in tree and ad after that fine the max of them
 *  -- longest sum between two nodes
 *
 * this soluton has time complexity of O(n)
 */

public class MaxPathSumInTree {

    public int maxHeightSumInTree(Node<Integer> root) {

        int dai[] = new int[1];          // here we are using this array to store the max sum of the tree as recursion will return only one at a time
        this.heightOfTheTreeWithSum(root,dai);
        return dai[0];

    }

    // first get sum of the subtree and at any point of node if the sum  is less than 0 means then return 0
    private int heightOfTheTreeWithSum(Node<Integer> node, int[] maxVal) {
        if(node == null) return 0;

        int leftSum = Math.max(0,heightOfTheTreeWithSum(node.left,maxVal)); // getting height if -ve then return 0
        int rightSum = Math.max(0,heightOfTheTreeWithSum(node.right,maxVal));

        maxVal[0] = Math.max(maxVal[0],leftSum+rightSum+node.value);  // adding sum of left and right subtree and finding the max of them

        return Math.max(leftSum,rightSum) + node.value  ;  // getting sum of node
    }


    public static void main(String[] args) {

        MaxPathSumInTree diameterOfTheTree = new MaxPathSumInTree();

        Node<Integer> a = new Node<>(-10);
        Node<Integer> b = new Node<>(20);
        Node<Integer> c = new Node<>(9);
        Node<Integer> d = new Node<>(-15);
//        Node<String> e = new Node<>("e");
        Node<Integer> f = new Node<>(7);
//        Node<Integer> g = new Node<>(7);
//        Node<Integer> h = new Node<>(8);
//        Node<String> i = new Node<>("i");

        //          -10
        //    20          9
        //  -15   7

        a.left=b;
        a.right=c;
        b.left=d;
//        b.right=e;
        b.right=f;
//        d.left=g;
//        d.right=h;
//        e.right=i;

        System.out.println(diameterOfTheTree.maxHeightSumInTree(a));

    }

}
