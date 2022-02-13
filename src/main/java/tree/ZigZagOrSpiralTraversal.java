package tree;


import java.util.*;

/**
 * @Problem : Given a binary tree, print the zigzag level order traversal or spiral traversal.
 *          i.e in one level it will move from left to right and in another it will move from right to left
 *
 * @Solution : we will use bfs traversal or level order traversal and will use boolean value to manage direction of traversal
 *
 * @Complexity : O(n)
 *
 */
public class ZigZagOrSpiralTraversal {

    // zig zag traversal or spiral traversal
    public List<List<String>> zigZagTraversal(Node<String> root) {
        if (root == null) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            String[] level = new String[size];
            for (int i = 0; i < size; i++) {
                Node<String> visited = queue.poll();

                int index = leftToRight?i:size-1-i;  // reverse the order of traversal by index

                level[index]=visited.value;

                if(visited.left!=null){
                    queue.offer(visited.left);
                }
                if(visited.right!=null){
                    queue.offer(visited.right);
                }
            }

            leftToRight=!leftToRight;  // changing the direction of traversal
            result.add(Arrays.asList(level));
        }

        return result;
    }

    public static void main(String[] args) {
        ZigZagOrSpiralTraversal zigZag = new ZigZagOrSpiralTraversal();

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

        List<List<String>> traversal = zigZag.zigZagTraversal(a);

        traversal.forEach(l->{
            l.forEach(s-> System.out.print(s+" "));
            System.out.println();
        });
    }

}
