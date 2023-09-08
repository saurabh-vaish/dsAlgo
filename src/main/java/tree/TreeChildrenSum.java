package tree;

/**
 * @Link = https://www.codingninjas.com/studio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&leftPanelTab=1
 *  Given a binary tree of nodes 'N', you need to modify the value of its nodes, such that the tree holds the Children sum property.
 *  A binary tree is said to follow the children sum property if, for every node of that tree, the value of that node is equal to the sum of the value(s) of all of its children nodes( left child and the right child).
 *
 * @Author saurabh vaish
 * @Date 02-07-2023
 */
public class TreeChildrenSum {


    // taking help of preorder
    // complexity - O(n)
    private static void childrenSum(Node<Integer> node){
        if(node==null)return;
        int childSum =0;
        if(node.left!=null) childSum+=node.left.value;
        if(node.right!=null) childSum+=node.right.value;

        // if left and right sub tree value is less than root value then replace root value with left and right sub tree value
        // if greater than replace root value with childsum
        if(childSum>=node.value){
            node.value=childSum;
        }else{
            if(node.left!=null)node.left.value=node.value;
            if(node.right!=null) node.right.value=node.value;
        }

        // traverse
        childrenSum(node.left);
        childrenSum(node.right);

        // getting sum of sub tree
        int total =0;
        if(node.left!=null)total += node.left.value;
        if(node.right!=null)total += node.right.value;

        // replace root value with subtree sum
        if(node.left!=null || node.right!=null) node.value = total;
    }
}
