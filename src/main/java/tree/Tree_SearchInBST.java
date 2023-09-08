package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/search-in-bst_1402878?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */


class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class Tree_SearchInBST {

    // O(logN)
    public static Boolean searchInBST(BinaryTreeNode<Integer> root, int x) {
        // Write your code here.

        while(root!=null){
            if(root.data==x)return true;
            if(x>root.data)root=root.right;
            else root = root.left;
        }

        return false;
    }

}
