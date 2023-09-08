package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @link = https://www.codingninjas.com/studio/problems/bottom-view-of-binary-tree_893110?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 *
 *  In Tree bottom view we will look from bottom on tree and add node from left to right and only take last node if they are on same level , as top node will get hidden
 *  For this assume tree is in grid , so all left will be on negative coordinates and right will be on positive .
 *  So for this we can use TreeMap [ sorting ] map to store node on horizontal level and value as node data , will add in map will store latest nodes will get add if they are on same level
 *
 * @Author saurabh vaish
 * @Date 27-06-2023
 */


class BTuple<T>{
    Node<T> node;
    int x; // for horizontal leveling
    BTuple(){}

    public BTuple(Node node, int x) {
        this.node = node;
        this.x = x;
    }
}

public class TreeBottomView {


    // complexity == O(N + M) , space - O(n)
    public static ArrayList<Integer> treeBottomView(Node<Integer> root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<BTuple<Integer>> queue = new LinkedList<>();
        queue.add(new BTuple<>(root,0) );

        while(!queue.isEmpty()){
            BTuple<Integer> tup = queue.poll();
            Node<Integer> node = tup.node;
            int x = tup.x;

            map.put(x,node.value);  // always storing latest value if nodes are on same level as need to show last node when we will start from top

            // adding left and right child to queue
            if(node.left!=null && node.left.value!=-1)queue.offer(new BTuple<>(node.left,x-1));   // x-1 as its in left , y+1 as we are going down
            if(node.right!=null && node.right.value!=-1)queue.offer(new BTuple<>(node.right,x+1)); // x+1 as its in right , y+1 as we are going down

        }

            for(Integer p:map.values()){
                    list.add(p);
        }


        return list;
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


        System.out.print("Tree top view == ");
        ArrayList<Integer> traversalAntiClockWise = treeBottomView(a);

        traversalAntiClockWise.forEach(s-> System.out.print(s+" "));

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
