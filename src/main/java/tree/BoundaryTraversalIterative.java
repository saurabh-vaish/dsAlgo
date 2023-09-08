package tree;


import java.util.*;

/**
 * @Problem : Given a binary tree, print the boundary traversal in clock or anti-clockwise direction.
 *
 * @Solution : for this first we will traverse the left subtree [ preorder ] and then the root [ inorder ] and then the right subtree [ preorder ] and will reverse the right subtree.
 *              while doing left and right traversal exclude the leaf nodes.
 *
 * @Complexity : O(n) + o(n) + o(n) = O(n)
 *
 */
public class BoundaryTraversalIterative {



    private static boolean isLeaf(Node<String> node){
        return node.left==null && node.right==null;
    }

    private static void leftBoundry(ArrayList<String> list,Node<String> root){
        Node<String> node = root.left;
        while(node!=null){
            if(!isLeaf(node))list.add(node.value);
            if(node.left!=null)node=node.left;
            else node=node.right;
        }
    }

    private static void rightBoundry(ArrayList<String> list,Node<String> root){
        Node<String> node = root.right;
        Stack<String> st = new Stack<>(); // using stack as need nodes in reverse order , so in stack last nodes will get poped first
        while(node!=null){
            if(!isLeaf(node))st.add(node.value);
            if(node.right!=null)node=node.right;
            else node=node.left;
        }

        while(!st.isEmpty()){
            list.add(st.pop());
        }
    }

    private static void leafNodes(ArrayList<String> list,Node<String> node){
        if(isLeaf(node)){
            list.add(node.value);
            return;
        }
        if(node.left!=null)leafNodes(list, node.left);
        if(node.right!=null)leafNodes(list, node.right);
    }

    private static void boundry(ArrayList<String> list,Node<String> root){
        leftBoundry(list,root);
        leafNodes(list,root);
        rightBoundry(list,root);
    }

    public static ArrayList<String> traverseBoundary(Node<String> root){
        // Write your code here.

        // first left boundry , then leaf nodes , then right boundry in reverse
        // if in left on any node left is not found take right , similar in right
        ArrayList<String> list = new ArrayList<>();
        list.add(root.value);
        if(isLeaf(root)){
            return list;
        }


        boundry(list,root);
        return list;
    }


    public static void main(String[] args) {

        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
        Node<String> i = new Node<>("i");

        //           a
        //       b      c
        //    d    e      f
        //  g   h    i

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        d.left=g;
        d.right=h;
        e.right=i;

        System.out.print("boundary traversal anti clock wise == ");
        ArrayList<String> traversalAntiClockWise = traverseBoundary(a);

        traversalAntiClockWise.forEach(s-> System.out.print(s+" "));

    }

}
