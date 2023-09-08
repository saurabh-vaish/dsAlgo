package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */

public class Tree_CeilInBST {

    // O(logN)
    public  static int findCeil(TreeNode<Integer> node, int x) {

        int ans = -1;
        while(node!=null){
            if(node.data==x)return x;

            if(x<node.data){
                ans = node.data;  // as we need to look minimum so
                node = node.left; // going left
            }
            else{
                node = node.right;  // discarding right values as they are always greater
            }
        }

        return ans;
    }

}
