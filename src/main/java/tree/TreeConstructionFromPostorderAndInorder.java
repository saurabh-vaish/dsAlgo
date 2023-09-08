package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Link = https://www.codingninjas.com/studio/problems/construct-a-binary-tree-from-preorder-and-inorder-traversal_920539?topList=striver-sde-sheet-problems
 *
 *
 * @Author saurabh vaish
 * @Date 02-07-2023
 */


class TreeNodee<T>
{
    T data;
    TreeNodee<T> left;
    TreeNodee<T> right;

    TreeNodee(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeConstructionFromPostorderAndInorder {


    // to construct tree from preorder and inorder , we will use properties of these traversal , as in preorder there will be always root on start
    // so first we will map the index of inroder into map
    // then on first get root from preordr , then get index from inorder , before that root in inorder all will be on left and after ones on right
    // so will so same in inorder also
    public static TreeNode<Integer> getTreeFromPostorderAndInorder(int[] postOrder, int[] inOrder) {
        //    Write your code here.
        if (inOrder == null || postOrder == null || inOrder.length !=
                postOrder.length)
            return null;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<inOrder.length;i++){
            map.put(inOrder[i],i);
        }

        TreeNode<Integer> tree = buildTree(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1,map);

        return tree;
    }

    private static TreeNode<Integer> buildTree(int [] inorder, int inStart, int inEnd, int[] postorder,int postStart, int postEnd, Map<Integer, Integer> map) {
        if(postStart>postEnd || inStart>inEnd)return null;

        TreeNode treeNode = new TreeNode(postorder[postEnd]); // root

        int rootIndexInInorder = map.get(treeNode.data);
        int numsLeft = rootIndexInInorder - inStart; // left part size in inroder

        treeNode.left = buildTree(inorder,inStart,rootIndexInInorder-1,  // inorder with left part before  root
                postorder,postStart,postStart+numsLeft-1,map);  // postorder with nodes size equal in inorder

        treeNode.right = buildTree(inorder,rootIndexInInorder+1,inEnd,  // inorder with right part after  root
                postorder,postStart+numsLeft,postEnd-1,map);  // postorder with nodes size equal in inorder

        return treeNode;
    }

    public static void main(String[] args) {
        int[] post = {4,5,2,6,7,3,1};
        int[] in = {4, 2, 5, 1, 6, 3, 7};

        TreeNode<Integer> integerTreeNodee = getTreeFromPostorderAndInorder(post,in);

    }

}
