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
public class BoundaryTraversal {

    // for anti clockwise traversal first left subtree then leaf nodes then right subtree [ reversed ]
    public List<String> boundaryTraversalAntiClockWise(Node<String> root) {
        if (root == null) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);

        result.add(root.value);
        leftBoundaryTraversal(root.left, result);

        leafNodes(root, result);

        rightSubTree(root.right, result);


        return result;
    }

    // using preorder traversal excluding leaf nodes
    private void leftBoundaryTraversal(Node<String> root, List<String> result) {
        if(isLeaf(root)) return;
        result.add(root.value);
        if(root.left != null) leftBoundaryTraversal(root.left, result);
        else leftBoundaryTraversal(root.right,result);
    }

    // using preorder traversal excluding leaf nodes
    private void leafNodes(Node<String> root, List<String> result) {
        if(isLeaf(root)){
            result.add(root.value);
        }else {
            if(root.left != null) leafNodes(root.left, result);
            if(root.right !=null) leafNodes(root.right, result);
        }
    }

    // preorder traversal going right and then reverse
    private void rightSubTree(Node<String> root, List<String> result) {
        if(isLeaf(root)) return;
        if(root.right != null) rightSubTree(root.right, result);
        result.add(root.value);
    }


    private boolean isLeaf(Node<String> node) {
        return node.left == null && node.right == null;

    }

//    ================================================================================================


    // for anti clockwise traversal first left subtree then leaf nodes then right subtree [ reversed ]
    public List<String> boundaryTraversalClockWise(Node<String> root) {
        if (root == null) return new ArrayList<>();
        List<String> result = new ArrayList<>();
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(root);

        result.add(root.value);

        rightSubTreeClockWise(root.right, result);

        leafNodesClockWise(root, result);

        leftBoundaryTraversalClockWise(root.left, result);


        return result;
    }

    private void leafNodesClockWise(Node<String> root, List<String> result) {
        if(isLeaf(root)){
            result.add(root.value);
        }else {
            if(root.right !=null) leafNodesClockWise(root.right, result);
            if(root.left != null) leafNodesClockWise(root.left, result);
        }
    }

    // preorder traversal going right
    private void rightSubTreeClockWise(Node<String> root, List<String> result) {
        if(isLeaf(root)) return;
        result.add(root.value);
        if(root.right != null) rightSubTreeClockWise(root.right, result);
        else rightSubTreeClockWise(root.left, result);
    }



    // using preorder traversal excluding leaf nodes
    private void leftBoundaryTraversalClockWise(Node<String> root, List<String> result) {
        if(isLeaf(root)) return;
        if(root.left != null) leftBoundaryTraversalClockWise(root.left, result);
        result.add(root.value);
    }


    public static void main(String[] args) {
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();

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
        List<String> traversalAntiClockWise = boundaryTraversal.boundaryTraversalAntiClockWise(a);

        traversalAntiClockWise.forEach(s-> System.out.print(s+" "));

        System.out.print("\n boundary traversal clock wise == ");

        List<String> traversalClockWise = boundaryTraversal.boundaryTraversalClockWise(a);

        traversalClockWise.forEach(s-> System.out.print(s+" "));
    }

}
