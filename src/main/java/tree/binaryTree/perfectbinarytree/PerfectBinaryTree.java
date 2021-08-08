package tree.binaryTree.perfectbinarytree;

/**
 *  Perfect Binary Tree :- A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.
 *                          A perfect binary tree could be full binary tree but not the vice versa
 *                          1. All the internal nodes have a degree of 2. [2 branches of each node]
 *                          2. If a single node has no children, it is a perfect binary tree of height h = 0, [ i.e. only root]
 *                          3. If a node has h > 0, it is a perfect binary tree if both of its subtrees are of height h - 1 and are non-overlapping.
 *
 * @author Saurabh Vaish
 * @Date 30-06-2021
 */
public class PerfectBinaryTree {

    private int item;   // any data structure like string , double , int or any object
    private PerfectBinaryTree left;  // left child
    private PerfectBinaryTree right;  // right child

    private boolean isRoot; // to identify its root node

    public PerfectBinaryTree(){
        this.item=0;
        this.left=null;
        this.right=null;
    }

    public PerfectBinaryTree(int item){
        this();
        this.item=item;
    }

    // gen a random tree based on values provided
    public PerfectBinaryTree insert(){
        PerfectBinaryTree root = new PerfectBinaryTree(1);
        root.isRoot=true;
        root.left=new PerfectBinaryTree(12);
        root.right=new PerfectBinaryTree(9);
        root.left.left=new PerfectBinaryTree(5);
        root.left.right=new PerfectBinaryTree(6);
        root.right.left=new PerfectBinaryTree(8);
        root.right.right=new PerfectBinaryTree(3);
//        root.right.right.left=new PerfectBinaryTree(2);

        return root;
    }

    public void display(PerfectBinaryTree node){
        if(node.isRoot){
            System.out.print("root ");
        }
        System.out.print(node.item+"-->");
    }


    // inorder traversal all left -> root node -> all right
    public void inOrderTraversal(PerfectBinaryTree node){
        if(node==null)return;
        inOrderTraversal(node.left); // traverse left
        display(node); // traverse root
        inOrderTraversal(node.right);  // traverse right
    }

    // preorder traversal root --> all left  -> all right
    public void preOrderTraversal(PerfectBinaryTree node){
        if(node==null)return;
        display(node); // traverse root
        preOrderTraversal(node.left); // traverse left
        preOrderTraversal(node.right);  // traverse right
    }

    // postorder traversal   all left  -> all right --> root
    public void postOrderTraversal(PerfectBinaryTree node){
        if(node==null)return;
        postOrderTraversal(node.left); // traverse left
        postOrderTraversal(node.right);  // traverse right
        display(node); // traverse root
    }

    public int heightOfTree(PerfectBinaryTree root){
        int h=0;
        while (root!=null){
            ++h;
            root=root.left;  // only checking left as we are getting for perfect binary tree so all the subtree height is same
        }
        return h;
    }

    public boolean isPerfectBinaryTree(PerfectBinaryTree root,int h,int level){
        if(root==null)return true;

        if(root.left==null && root.right==null)return h==level+1; // level+1 bcs if only root is present then height is 1

        if((root.left==null && root.right!=null ) || (root.right==null && root.left!=null)) return false;  // if any node is having only one child then return false;

        return isPerfectBinaryTree(root.left,h,level+1) && isPerfectBinaryTree(root.right,h,level+1);
    }


}

class Test{
    public static void main(String[] args) {
        PerfectBinaryTree tree = new PerfectBinaryTree();
        PerfectBinaryTree root = tree.insert();

        System.out.println("Inorder traversal [ all left --> root --> all right]");
        tree.inOrderTraversal(root);

        System.out.println("\nPreorder traversal [ root --> all left --> all right ]");
        tree.preOrderTraversal(root);

        System.out.println("\nPostorder traversal [ all left --> all right --> root ]");
        tree.postOrderTraversal(root);

        System.out.println();
        int height = tree.heightOfTree(root);
        System.out.println("height of the tree = "+height);

        System.out.println("is perfect binary tree = "+tree.isPerfectBinaryTree(root,height,0));
    }
}

