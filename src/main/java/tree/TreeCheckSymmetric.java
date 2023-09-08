package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * @Author saurabh vaish
 * @Date 29-06-2023
 */
public class TreeCheckSymmetric {

    public static boolean isSymmetric(Node<Integer> root) {
        // Write your code here.
        // if(root==null || root.data==-1)return true;
        return root==null || symm(root.left,root.right);
    }

    /// traverse left and right sub tree same time ,using preorder
    // for from left sub tree root->left->right and same time from right sub tree, root->right->left
    public static boolean symm(Node<Integer> leftroot,Node<Integer> rightroot) {
        if(leftroot==null && rightroot==null)return true;
        else if(leftroot == null || rightroot==null) return false;

        if(!leftroot.value.equals(rightroot.value))return false;

        return symm(leftroot.left, rightroot.right)
                &&
                symm(leftroot.right, rightroot.left);
    }


    private static Node<Integer> root;

    public static void main(String[] args) {


        Stream.of("1 2 2 3 4 4 3 -1 -1 -1 -1 -1 -1 -1 -1".split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
            insert(root,ee);
        });

        System.out.println(isSymmetric(root));

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
