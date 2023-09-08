package tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @Author saurabh vaish
 * @Date 24-06-2023
 */

class TreeNodeW {
    int val;
    TreeNodeW left;
    TreeNodeW right;

    TreeNodeW(){

    }

    TreeNodeW(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class TreeMaximumWidth {

    private static TreeNodeW root = new TreeNodeW();
    public static int getMaxWidth(TreeNodeW root) {
        // Write your code here.
        int max = Integer.MIN_VALUE;
        if(root==null || root.val==-1)return 0;

        Queue<TreeNodeW> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            // List<TreeNode> list = new ArrayList<>();
            max = Math.max(max,queue.size());
            TreeNodeW node = queue.poll();

            if(node.left!=null && node.left.val!=-1)queue.add(node.left);
            if(node.right!=null && node.right.val!=-1)queue.add(node.right);
        }

        return max;

    }

    private static boolean isLeft =true;
    private static int count =0;
    public static void insert(TreeNodeW node){
        if(isLeft)root.left=node;
        else root.right=node;

        isLeft=!isLeft;
        count++;
        if(count==2){
            root = node;
            count=0;
        }
    }

    public static void main(String[] args) {
        TreeNodeW head = root;
        Stream.of( "1 2 3 4 -1 5 6 -1 7 -1 -1 -1 -1 -1 -1".split(" ")).skip(1).mapToInt(Integer::valueOf).forEach(e->{
            insert(new TreeNodeW(e));
        });

        head = head;
        System.out.println(getMaxWidth(head.left));
    }
}
