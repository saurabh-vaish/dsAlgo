package tree;

/**
 * @Link = https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 *
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 *
 * Design an algorithm that runs in less than O(n) time complexity.
 *
 * @Author saurabh vaish
 * @Date 02-07-2023
 */
public class TreeTotalNodesInCompleteTree {

    // complexity - O(N) , both
    private static int countNodesSimpleSolution(Node<Integer> root){
        if(root==null)return 0;

        int lh = countNodesSimpleSolution(root.left);
        int rh = countNodesSimpleSolution(root.right);

        return lh + rh +1; // 1 for root
    }


    // complexity == O ( (logN + logN) * logN ) == (logN)^2  , space == O(n)
    // since we need to count node in complete tree . so there could be possibility all levels are completely filled , and some levels are not
    // for the levels which are completely filled we can get check height of left and right subtree and compare , if both are same then subtree is completely filled
    // in that we can count node as 2^N - 1
    // but if the subtree is not completely filled then we need to check for each node and count them
    private static int countNodeOptimized(Node<Integer> root){
        if(root==null) return 0;

        int lh = getLeftHeight(root.left);
        int rh = getRightHeight(root.right);

        // subtree is completely filled
        if(lh == rh) return (2<<lh) - 1;  // 2^N +1

        // count for each node
        return 1 + countNodeOptimized(root.left) + countNodeOptimized(root.right);

    }

    // O(log N) as we will go only left
    private static int getLeftHeight(Node<Integer> left) {
        int count=0;
        while(left!=null){
            count++;
            left = left.left;
        }
        return count;
    }

    // O(log N) as we will go only right
    private static int getRightHeight(Node<Integer> right) {
        int count=0;
        while(right!=null){
            count++;
            right = right.right;
        }
        return count;
    }


    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);
        Node<Integer> g = new Node<>(7);
        Node<Integer> h = new Node<>(8);
        Node<Integer> i = new Node<>(9);

        //          1
        //       2      3
        //    4    5   6   9
        //  7   8

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        c.right=i;
        d.left=g;
        d.right=h;

        System.out.println(countNodesSimpleSolution(a));


        System.out.println(countNodeOptimized(a));

    }

}
