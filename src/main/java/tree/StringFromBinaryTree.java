package tree;

import tree.normalTree.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author saurabh vaish
 * @Date 07-09-2022
 */
public class StringFromBinaryTree {
   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left=new TreeNode(2);
        root.right=new TreeNode(3);
        root.left.right=new TreeNode(4);
//        root.left.right=new TreeNode(6);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue);

        System.out.println(queue);

        inOrderTraversal(root,0);
    }

    static void bfs(Queue<TreeNode> queue){
        if(queue.isEmpty())return;
        TreeNode visited = queue.poll();
        System.out.print("("+visited.val+" ");
        if(visited.left!=null) {
            queue.offer(visited.left);
        }
        if(visited.right!=null) {
            queue.offer(visited.right);
        }
        bfs(queue);
        System.out.print(")");
    }

    public  static void inOrderTraversal(TreeNode node,int i){
        if(node==null)return;
        if (i!=0) {
            System.out.print("(");
        }
        System.out.print(node.val);
        inOrderTraversal(node.left,++i); // traverse left
        if(i!=1) {
            System.out.print(")");
        }
        inOrderTraversal(node.right,++i);  // traverse right
    }
}
