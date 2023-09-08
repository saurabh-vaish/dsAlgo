package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */

public class Tree_InsertInBST {

    // we will search for the proper position and then insert node
    // O(logN)
    public static TreeNode<Integer> insertionInBST(TreeNode<Integer> root, int val) {
        //    Write your code here
        if(root==null)return new TreeNode(val);

        TreeNode<Integer> node = root;
        while(true){
            if(val>node.data){  // value is greater than node then moving right
                if(node.right==null){
                    node.right=new TreeNode(val);
                    break;
                }
                node=node.right;
            }else{
                if(node.left==null){
                    node.left=new TreeNode(val);
                    break;
                }
                node=node.left;
            }
        }

        return root;
    }


}
