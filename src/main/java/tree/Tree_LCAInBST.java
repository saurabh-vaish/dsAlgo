package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 *
 * @Link = https://www.codingninjas.com/studio/problems/lca-in-a-bst_981280?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 09-07-2023
 */
public class Tree_LCAInBST {

    // O(H) , LCA is the common parent node , from which both  other node will go
    // in bst as values are placed as left and right
    // so it both nodes are coming as one side then we have to traverse until we found that where to place both nodes
    // in left or in right means one is one left and other is on right means we got the root
    public static TreeNode<Integer> LCAinaBST(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q)
    {
        // Write your code here
        if(root==null)return root;

        int val = root.data;
        // if both nodes are in greater than root value , go right
        if( p.data > val && q.data > val){
            return LCAinaBST(root.right,p,q);
        }

        // if both nodes are in less than root value , go left
        if(p.data< val && q.data <val){
            return LCAinaBST(root.left,p,q);
        }

        // if nodes are in left and right or root , then its the common node
        return root;
    }

    private static TreeNode<Integer> root;
    public static void main(String[] args) {


        Stream.of("10 4 13 3 8 11 15 1 2 6 9 5 7".split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
            insert(root,ee);
        });

        System.out.println(LCAinaBST(root,new TreeNode<>(1),new TreeNode<>(2)).data);

    }



    static void insert(TreeNode temp, int key)
    {

        if (temp == null) {
            root = new TreeNode(key);
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new TreeNode(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

}
