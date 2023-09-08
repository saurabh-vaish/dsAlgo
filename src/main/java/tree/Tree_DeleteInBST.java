package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/bst-delete_973001
 *
 * @Author saurabh vaish
 * @Date 09-07-2023
 */
public class Tree_DeleteInBST {


    // O(logN)
    // deletion of the node , takes place in 3 steps - search , delete and restructure
    public static BinaryTreeNode<Integer> bstDelete(BinaryTreeNode<Integer> root, int key)
    {
        // Write your code here.
        if(root==null)return root;

        if(root.data==key)return rearrange(root);

        BinaryTreeNode<Integer> node = root;

        while(root!=null){
            if(key<root.data){
                if(root.left!=null && root.left.data==key){
                    root.left = rearrange(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else{
                if(root.right!=null && root.right.data==key){
                    root.right = rearrange(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }
        }

        return node;

    }

    private static BinaryTreeNode<Integer> rearrange(BinaryTreeNode<Integer> root) {
        if(root.left==null)return root.right;
        else if(root.right==null)return root.left;
        else {
            // get rightmost node in left subtree
            BinaryTreeNode<Integer> rightChild = root.right;
            BinaryTreeNode<Integer> lastRightInLeftSubTree = getRightMost(root.left);
            lastRightInLeftSubTree.right = rightChild;
            return root.left;
        }
    }

    private static BinaryTreeNode<Integer> getRightMost(BinaryTreeNode<Integer> root) {
        if(root.right==null)return root;
        return getRightMost(root.right);
    }


}
