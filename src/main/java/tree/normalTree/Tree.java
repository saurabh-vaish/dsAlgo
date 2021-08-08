package tree.normalTree;

/**
 *  This is a normal implementation of Tree
 *
 *
 *
 * @author Saurabh Vaish
 * @Date 27-06-2021
 */
public class Tree {
    private int item;   // any data structure like string , double , int or any object
    private Tree left;  // left child
    private Tree right;  // right child

    private boolean isRoot; // to identify its root node

    public Tree(){
        this.item=0;
        this.left=null;
        this.right=null;
    }

    public Tree(int item){
        this();
        this.item=item;
    }

    // gen a random tree based on values provided
    public Tree insert(){
        Tree root = new Tree(1);
        root.isRoot=true;
        root.left=new Tree(12);
        root.right=new Tree(9);
        root.left.left=new Tree(5);
        root.left.right=new Tree(6);

        return root;
    }

    public void display(Tree node){
        if(node.isRoot){
            System.out.print("root ");
        }
        System.out.print(node.item+"-->");
    }


    // inorder traversal all left -> root node -> all right
    public void inOrderTraversal(Tree node){
        if(node==null)return;
        inOrderTraversal(node.left); // traverse left
        display(node); // traverse root
        inOrderTraversal(node.right);  // traverse right
    }

    // preorder traversal root --> all left  -> all right
    public void preOrderTraversal(Tree node){
        if(node==null)return;
        display(node); // traverse root
        preOrderTraversal(node.left); // traverse left
        preOrderTraversal(node.right);  // traverse right
    }

    // postorder traversal   all left  -> all right --> root
    public void postOrderTraversal(Tree node){
        if(node==null)return;
        postOrderTraversal(node.left); // traverse left
        postOrderTraversal(node.right);  // traverse right
        display(node); // traverse root
    }


}

class Test{
    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree root = tree.insert();

        System.out.println("Inorder traversal [ all left --> root --> all right]");
        tree.inOrderTraversal(root);

        System.out.println("\nPreorder traversal [ root --> all left --> all right ]");
        tree.preOrderTraversal(root);

        System.out.println("\nPostorder traversal [ all left --> all right --> root ]");
        tree.postOrderTraversal(root);
    }
}
