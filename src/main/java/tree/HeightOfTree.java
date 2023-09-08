package tree;


import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Problem == Program to find the height of a binary tree / Find the maximum depth of a binary tree
 *
 * @Solution ==  
 * 
 * 
 * @Complexity  == O(n) both time and space
 *
 * @author Saurabh Vaish
 * @Date 28-07-2021
 */



public class HeightOfTree {

    // better solution
    public int heightUsingRecursion(Node<String> root){
        if(root==null)return 0;
//        int leftHeight = heightUsingRecursion(root.left);
//        int rightHeight = heightUsingRecursion(root.right);
//        System.out.println(leftHeight+" "+rightHeight);
//        int height = Math.max(leftHeight,rightHeight);
//        System.out.println(height);
//        return height+1;
        return 1+Math.max(heightUsingRecursion(root.left),heightUsingRecursion(root.right));
    }


    // using BFS
    public int heightUsingIteration(Node<String> root){
        int height=0;
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root); // O(1)

        // loop till queue is empty
        while (!queue.isEmpty())
        {
            // calculate the total number of nodes at the current level
            int size = queue.size();

            // process each node of the current level and enqueue their
            // non-empty left and right child
            while (size-- > 0)
            {
               Node<String> front = queue.poll();

                if (front.left != null) {
                    queue.add(front.left);
                }

                if (front.right != null) {
                    queue.add(front.right);
                }
            }

            // increment height by 1 for each level
            height++;
        }

        return height;

    }

    public static void main(String[] args) {

        HeightOfTree tree = new HeightOfTree();

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

       int height = tree.heightUsingRecursion(a);

        System.out.println(height);

       int heightUsingIteration = tree.heightUsingIteration(a);

        System.out.println(heightUsingIteration);

    }
}
