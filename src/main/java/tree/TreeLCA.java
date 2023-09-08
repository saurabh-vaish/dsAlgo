package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * https://www.codingninjas.com/studio/problems/lca-of-binary-tree_920541?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 * find least common ancestor of two nodes, 
 *
 * @Author saurabh vaish
 * @Date 29-06-2023
 */
public class TreeLCA {

    public static int lowestCommonAncestor(Node<Integer> root, int x, int y)
    {
        //    Write your code here.
        if(root==null)return root.value;
        return dfs(root,x,y).value;

    }


    private static Node<Integer> dfs(Node<Integer> root, int x, int y){
        if(root==null || root.value==x || root.value==y)return root; // if node is null or value matched then return

        Node<Integer> left = dfs(root.left,x,y);

        Node<Integer> right = dfs(root.right,x,y);

        // after traversal if left part is null consider right one , if right is null take left
        // if both are not null then we found the common node;
        if(left==null)return right;
        else if(right==null)return left;
        else return root;

    }

    private static Node<Integer> root;
    public static void main(String[] args) {


        Stream.of("1 2 3 4 7 -1 -1 -1 -1 -1 -1".split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
            insert(root,ee);
        });

        System.out.println(lowestCommonAncestor(root,4,7));

    }



    static void insert(Node temp, int key)
    {

        if (temp == null) {
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new Node(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new Node(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }



}
