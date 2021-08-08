package tree.binaryTree.fullbinarytree;

/**
 *  Full Binary FullBinaryTree :- In this type of binary tree this every parent or internal node has either 0 or 2 child nodes   
 *
 * @author Saurabh Vaish
 * @Date 29-06-2021
 */
public class FullBinaryTree {

    private int item;   // any data structure like string , double , int or any object
    private FullBinaryTree left;  // left child
    private FullBinaryTree right;  // right child

    private boolean isRoot; // to identify its root node

    public FullBinaryTree(){
        this.item=0;
        this.left=null;
        this.right=null;
    }

    public FullBinaryTree(int item){
        this();
        this.item=item;
    }

    // gen a random tree based on values provided
    public FullBinaryTree insert(){
        FullBinaryTree root = new FullBinaryTree(1);
        root.isRoot=true;
        root.left=new FullBinaryTree(12);
        root.right=new FullBinaryTree(9);
        root.left.left=new FullBinaryTree(5);
        root.left.right=new FullBinaryTree(6);
//        root.right.left=new FullBinaryTree(8);
//        root.right.right=new FullBinaryTree(3);
//        root.right.right.left=new FullBinaryTree(2);

        return root;
    }

    public void display(FullBinaryTree node){
        if(node.isRoot){
            System.out.print("root ");
        }
        System.out.print(node.item+"-->");
    }


    // inorder traversal all left -> root node -> all right
    public void inOrderTraversal(FullBinaryTree node){
        if(node==null)return;
        inOrderTraversal(node.left); // traverse left
        display(node); // traverse root
        inOrderTraversal(node.right);  // traverse right
    }

    // preorder traversal root --> all left  -> all right
    public void preOrderTraversal(FullBinaryTree node){
        if(node==null)return;
        display(node); // traverse root
        preOrderTraversal(node.left); // traverse left
        preOrderTraversal(node.right);  // traverse right
    }

    // postorder traversal   all left  -> all right --> root
    public void postOrderTraversal(FullBinaryTree node){
        if(node==null)return;
        postOrderTraversal(node.left); // traverse left
        postOrderTraversal(node.right);  // traverse right
        display(node); // traverse root
    }


    public boolean isFullBinaryTree(FullBinaryTree root){
        if(root==null || (root.left==null && root.right==null))return true;

        if( root.left!=null && root.right!=null){
            return isFullBinaryTree(root.left) && isFullBinaryTree(root.right);
        }
        return false;
    }


}

class Test{
    public static void main(String[] args) {
        FullBinaryTree tree = new FullBinaryTree();
        FullBinaryTree root = tree.insert();

        System.out.println("Inorder traversal [ all left --> root --> all right]");
        tree.inOrderTraversal(root);

        System.out.println("\nPreorder traversal [ root --> all left --> all right ]");
        tree.preOrderTraversal(root);

        System.out.println("\nPostorder traversal [ all left --> all right --> root ]");
        tree.postOrderTraversal(root);

        System.out.println();
        System.out.println("is binary tree = "+tree.isFullBinaryTree(root));
    }
}

