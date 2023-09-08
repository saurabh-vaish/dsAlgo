package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/ceil-from-bst_920464?topList=striver-sde-sheet-problems
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */

public class Tree_FloorInBST {

    // for floor , we need value greater value in all which is nearby to x, so only look for greater values
    // O(logN)
    public static int floorInBST(TreeNode<Integer> node, int x) {
        //    Write your code here.
        int ans = -1;
        while(node!=null){
            if(node.data==x)return x;

            if(x>node.data){
                ans = node.data;  // need to take greater only
                node = node.right;
            }
            else{
                node = node.left;  // as in left less value will be there so discarding them
            }
        }

        return ans;
    }

}
