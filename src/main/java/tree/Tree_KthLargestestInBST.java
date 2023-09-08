package tree;

/**
 *
 * @Link = https://www.codingninjas.com/studio/problems/kth-smallest-node-in-bst_920441?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 09-07-2023
 */
public class Tree_KthLargestestInBST {

    // O(min(K,N)
    public static int kthLargest(TreeNode<Integer> root, int k)
    {
        TreeNode<Integer> node = kLargest(root, k,new int[]{0});  // arr to hold value
        if(node==null)return 0;
        return node.data;
    }

    // using inorder traversal , as in inorder travesal , BST result is sorted
    static TreeNode<Integer> kLargest(TreeNode<Integer> root, int k, int [] ar)
    {
        if(root==null)
            return null;

        // going all right
        TreeNode<Integer> right= kLargest(root.right,k,ar);
        if(right!=null) return right;

        ar[0]++;  // increase each count , when recursion is coming back after left
        if(ar[0]==k) return root;  // as it matches with k means we have found the kth

        return kLargest(root.left,k,ar);
    }
}
