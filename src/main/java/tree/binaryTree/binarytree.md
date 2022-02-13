**Binary Tree** == A binary tree is a tree data structure in which each parent node can have at most two children. Each node of a binary tree consists of three items:

                    1. data item
                    2. address of left child
                    3. address of right child

**Types of Binary Tree ===**

                    1. Full Binary Tree   
                    2. Perfect Binary Tree      
                    3. Complete Binary Tree 
                    4. Degenerate or Pathological Tree 
                    5. Skewed Binary Tree 
                    6. Balanced Binary Tree


**1. Full Binary Tree :==**

    A full Binary tree is a special type of binary tree in which every parent node/internal node has either two or no children.


**2. Perfect Binary Tree**

    A perfect binary tree is a type of binary tree in which every internal node has exactly two child nodes and all the leaf nodes are at the same level.
    A perfect binary tree could be full binary tree but not the vice versa
    *  All the internal nodes have a degree of 2. [2 branches of each node]
    *  If a single node has no children, it is a perfect binary tree of height h = 0, [ i.e. only root]
    *  If a node has h > 0, it is a perfect binary tree if both of its subtrees are of height h - 1 and are non-overlapping.


**3. Complete Binary Tree**

    A complete binary tree is just like a full binary tree, but with two major differences
            1. Every level must be completely filled
            2. All the leaf elements must lean towards the left.
            3. The last leaf element might not have a right sibling i.e. a complete binary tree doesn't have to be a full binary tree.


**4. Degenerate or Pathological Tree**

    A degenerate or pathological tree is the tree having a single child either left or right.


**5. Skewed Binary Tree**

    A skewed binary tree is a pathological/degenerate tree in which the tree is either dominated by the left nodes or the right nodes. Thus, there are two types of skewed binary tree: left-skewed binary tree and right-skewed binary tree.


**6. Balanced Binary Tree**

    It is a type of binary tree in which the difference between the height of the left and the right subtree for each node is either 0 or 1.
    Hieght of tree at max log(n)


#### Terminologies #####

**Root**
            
    It is the topmost node of a tree.


**Height of a Node**

    The height of a node is the number of edges from the node to the deepest leaf (ie. the longest path from the node to a leaf node).

**Depth of a Node**

    The depth of a node is the number of edges from the root to the node.

**Height of a Tree**

    The height of a Tree is the height of the root node or the depth of the deepest node.

**Degree of a Node**

    The degree of a node is the total number of branches of that node.

**Forest**

    A collection of disjoint trees is called a forest. You can create a forest by cutting the root of a tree.

**Tree Applications**

    1. Binary Search Trees(BSTs) are used to quickly check whether an element is present in a set or not.
    2. Heap is a kind of tree that is used for heap sort.
    3. A modified version of a tree called Tries is used in modern routers to store routing information.
    4. Most popular databases use B-Trees and T-Trees, which are variants of the tree structure we learned above to store their data
    5. Compilers use a syntax tree to validate the syntax of every program you write.

**Binary Tree Implementation** 
    `// Binary Tree in Java 
    // Node creation
    
    class Node {
    int key;
    Node left, right;
    
    public Node(int item) {
    key = item;
    left = right = null;
    }
    }
    
    class BinaryTree {
    Node root;
    
    BinaryTree(int key) {
    root = new Node(key);
    }
    
    BinaryTree() {
    root = null;
    }
    
    // Traverse Inorder
    public void traverseInOrder(Node node) {
    if (node != null) {
    traverseInOrder(node.left);
    System.out.print(" " + node.key);
    traverseInOrder(node.right);
    }
    }
    
    // Traverse Postorder
    public void traversePostOrder(Node node) {
    if (node != null) {
    traversePostOrder(node.left);
    traversePostOrder(node.right);
    System.out.print(" " + node.key);
    }
    }
    
    // Traverse Preorder
    public void traversePreOrder(Node node) {
    if (node != null) {
    System.out.print(" " + node.key);
    traversePreOrder(node.left);
    traversePreOrder(node.right);
    }
    }
    
    public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    
    tree.root = new Node(1);
    tree.root.left = new Node(2);
    tree.root.right = new Node(3);
    tree.root.left.left = new Node(4);
    
    System.out.print("Pre order Traversal: ");
    tree.traversePreOrder(tree.root);
    System.out.print("\nIn order Traversal: ");
    tree.traverseInOrder(tree.root);
    System.out.print("\nPost order Traversal: ");
    tree.traversePostOrder(tree.root);
    }
    }`
