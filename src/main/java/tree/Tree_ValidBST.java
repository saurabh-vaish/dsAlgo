package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/validate-bst_981275
 *
 * @Author saurabh vaish
 * @Date 09-07-2023
 */
public class Tree_ValidBST {

    // O(N) , O(1)
    public static boolean validateBST(BinaryTreeNode<Integer> root)
    {
        if(root==null)return false;
        // Write your code here.
        return validate(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private static boolean validate(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
        if(root==null)return true;
        if(root.data <= minValue || root.data>=maxValue)return false;
        return validate(root.left,minValue,root.data)  // for left subtree every element should be lesser than root value
                && validate(root.right,root.data,maxValue); // for right sub tree every element should be greater than root value
    }
}
