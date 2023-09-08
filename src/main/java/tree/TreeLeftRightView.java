package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @link = https://www.codingninjas.com/studio/problems/left-view-of-a-binary-tree_920519?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 *
 *  In Tree left/right view we will look from on side on tree and other side node will get hidden. For this we will use recursion using Preorder not iterative with level order
 *  as we need only one element on a horizontal level .
 *  for left view will traverse from left to right and only take first node if they are on same level , as other size node will get hidden
 *  For this assume tree is in grid , so all left will be on negative coordinates and right will be on positive .
 *
 *
 * @Author saurabh vaish
 * @Date 27-06-2023
 */


public class TreeLeftRightView {


    // complexity == O(N + M) , space - O(n)
    public static void treeLeftView(Node<Integer> node,ArrayList<Integer> list,int depth)
    {
        if(node==null)return;

        if(depth==list.size())list.add(node.value); // we are matching list size based on depth , as on each level need to add only one element

        treeLeftView(node.left,list,depth+1);  // for left view will traverse left first
        treeLeftView(node.right,list,depth+1);
    }

    public static void treeRightView(Node<Integer> node,ArrayList<Integer> list,int depth)
    {
        if(node==null)return;

        if(depth==list.size())list.add(node.value); // we are matching list size based on depth , as on each level need to add only one element

        treeRightView(node.right,list,depth+1);  // for right view will traverse right first
        treeRightView(node.left,list,depth+1);
    }

    private static Node root;

    public static void main(String[] args) {
        Node<Integer> a = new Node<>(1);
        Node<Integer> b = new Node<>(2);
        Node<Integer> c = new Node<>(3);
        Node<Integer> d = new Node<>(4);
        Node<Integer> e = new Node<>(5);
        Node<Integer> f = new Node<>(6);
        Node<Integer> g = new Node<>(7);
        Node<Integer> h = new Node<>(8);
        Node<Integer> i = new Node<>(9);

        //          1
        //       2      3
        //    4    (5 5)   6
        //  7   8            9

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=e;
        c.right=f;
        d.left=g;
        d.right=h;
        f.right=i;

//            0
//        1        2
//     4     5   3    6
//         7
//


        System.out.print("Tree left view == ");
        ArrayList<Integer> leftView = getLeftView(a);
        leftView.forEach(s-> System.out.print(s+" "));

        System.out.print("Tree right view == ");
        ArrayList<Integer> rightView = getRightView(a);
        rightView.forEach(s-> System.out.print(s+" "));


    }

    public static ArrayList<Integer> getLeftView(Node<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        treeLeftView(root,list,0);
        return list;
    }

    public static ArrayList<Integer> getRightView(Node<Integer> root)
    {
        //    Write your code here.
        ArrayList<Integer> list = new ArrayList<>();
        treeRightView(root,list,0);
        return list;
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
