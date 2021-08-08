package tree.binaryTree.completebinarytree;

/**
 *  Complete Binary Tree :- A complete binary tree is a binary tree in which all the levels are completely filled except possibly the lowest one, which is filled from the left.
 *                          A complete binary tree is just like a full binary tree, but with two major differences
 *                              1. All the leaf elements must lean towards the left.
 *                              2. The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.
 *              Imp --->
 *                          If the index of any element in the array is i, the element in the index 2i+1 will become the left child and element in 2i+2 index will become the right child.
 *                          Also, the parent of any element at index i is given by the lower bound of (i-1)/2.
 *
 * @author Saurabh Vaish
 * @Date 30-06-2021
 */
public class CompleteBinaryTree {

    private int item;   // any data structure like string , double , int or any object
    private CompleteBinaryTree left;  // left child
    private CompleteBinaryTree right;  // right child

    private boolean isRoot; // to identify its root node

    public CompleteBinaryTree(){
        this.item=0;
        this.left=null;
        this.right=null;
    }

    public CompleteBinaryTree(int item){
        this();
        this.item=item;
    }

    // gen a random tree based on values provided
    public CompleteBinaryTree insert(){
        CompleteBinaryTree root = new CompleteBinaryTree(1);
        root.isRoot=true;
        root.left=new CompleteBinaryTree(12);
        root.right=new CompleteBinaryTree(9);
        root.left.left=new CompleteBinaryTree(5);
        root.left.right=new CompleteBinaryTree(6);
        root.right.left=new CompleteBinaryTree(8);
//        root.right.right=new CompleteBinaryTree(3);
//        root.right.right.left=new CompleteBinaryTree(2);

        return root;
    }

    public void display(CompleteBinaryTree node){
        if(node.isRoot){
            System.out.print("root ");
        }
        System.out.print(node.item+"-->");
    }


    // inorder traversal all left -> root node -> all right
    public void inOrderTraversal(CompleteBinaryTree node){
        if(node==null)return;
        inOrderTraversal(node.left); // traverse left
        display(node); // traverse root
        inOrderTraversal(node.right);  // traverse right
    }

    // preorder traversal root --> all left  -> all right
    public void preOrderTraversal(CompleteBinaryTree node){
        if(node==null)return;
        display(node); // traverse root
        preOrderTraversal(node.left); // traverse left
        preOrderTraversal(node.right);  // traverse right
    }

    // postorder traversal   all left  -> all right --> root
    public void postOrderTraversal(CompleteBinaryTree node){
        if(node==null)return;
        postOrderTraversal(node.left); // traverse left
        postOrderTraversal(node.right);  // traverse right
        display(node); // traverse root
    }

    public int countNumNodes(CompleteBinaryTree root){
        if(root==null)return 0;
        return (1+ countNumNodes(root.left) + countNumNodes(root.right));  // here 1 for node count
    }

    public boolean isCompleteBinaryTree(CompleteBinaryTree root, int index, int numNodes){
        if(root==null)return true;

        if(index>=numNodes)return false;

        int leftIndexNumber = 2*index+1;   // index no for left children
        int rightIndexNumber = 2*index+2;   // index no for right children

        return isCompleteBinaryTree(root.left,leftIndexNumber,numNodes) && isCompleteBinaryTree(root.right,rightIndexNumber,numNodes);
    }


}

class Test{
    public static void main(String[] args) {
        CompleteBinaryTree tree = new CompleteBinaryTree();
        CompleteBinaryTree root = tree.insert();

        System.out.println("Inorder traversal [ all left --> root --> all right]");
        tree.inOrderTraversal(root);

        System.out.println("\nPreorder traversal [ root --> all left --> all right ]");
        tree.preOrderTraversal(root);

        System.out.println("\nPostorder traversal [ all left --> all right --> root ]");
        tree.postOrderTraversal(root);

        System.out.println();
        int height = tree.countNumNodes(root);
        System.out.println("no of nodes = "+height);

        System.out.println("is Complete binary tree = "+tree.isCompleteBinaryTree(root,height,0));
    }
}

