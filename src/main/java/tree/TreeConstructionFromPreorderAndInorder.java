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


class TreeNode<T>
{
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeConstructionFromPreorderAndInorder {


    // to construct tree from preorder and inorder , we will use properties of these traversal , as in preorder there will be always root on start
    // so first we will map the index of inroder into map
    // then on first get root from preordr , then get index from inorder , before that root in inorder all will be on left and after ones on right
    // so will so same in inorder also
    public static TreeNode<Integer> buildBinaryTree(ArrayList<Integer> inorder, ArrayList<Integer>  preorder) {
        //    Write your code here.

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<preorder.size();i++){
            map.put(inorder.get(i),i);
        }

        TreeNode tree = buildTree(inorder,0,inorder.size()-1,preorder,0,preorder.size()-1,map);

        return tree;
    }

    private static TreeNode buildTree(ArrayList<Integer> inorder, int inStart, int inEnd, ArrayList<Integer> preorder,int preStart, int preEnd, Map<Integer, Integer> map) {
        if(preStart>preEnd || inStart>inEnd)return null;

        TreeNode treeNode = new TreeNode(preorder.get(preStart)); // root

        int rootIndexInInorder = map.get(treeNode.data);
        int numsLeft = rootIndexInInorder - inStart; // left part size in inroder

        treeNode.left = buildTree(inorder,inStart,rootIndexInInorder-1,  // inorder with left part before  root
                preorder,preStart+1,preStart+numsLeft,map);  // preorder with nodes size equal in inorder

        treeNode.right = buildTree(inorder,rootIndexInInorder+1,inEnd,  // inorder with right part after  root
                preorder,preStart+numsLeft+1,preEnd,map);  // preorder with nodes size equal in inorder

        return treeNode;
    }

    public static void main(String[] args) {
        ArrayList<Integer> pre = new ArrayList<>(List.of(1,2,4,7,3));
        ArrayList<Integer> in = new ArrayList<>(List.of(4,2,7,1,3));

        TreeNode<Integer> integerTreeNode = buildBinaryTree(in, pre);

    }

}
