package tree;

import java.util.*;
import java.util.stream.Stream;

/**
 * @link = https://www.codingninjas.com/studio/problems/top-view-of-the-tree_799401?topList=striver-sde-sheet-problems&leftPanelTab=0
 *
 *
 *  In Tree top view we will look from top on tree and add node from left to right and only take first node if they are on same level , as bottom node will get hidden
 *  For this assume tree is in grid , so all left will be on negative coordinates and right will be on positive .
 *  So for this we can use TreeMap [ sorting ] map to store node on horizontal level and value as node data , will add in map only once as only first time nodes will get add if they are on same level
 *
 * @Author saurabh vaish
 * @Date 25-06-2023
 */


class TTuple<T>{
    Node<T> node;
    int x; // for horizontal leveling
    TTuple(){}

    public TTuple(Node node, int x) {
        this.node = node;
        this.x = x;
    }
}

public class TreeTopView {


    // complexity == O(N + M) , space - O(n)
    public static ArrayList<Integer> treeTopView(Node<Integer> root)
    {
        ArrayList<Integer> list = new ArrayList<>();

        TreeMap<Integer,Integer> map = new TreeMap<>();

        Queue<TTuple<Integer>> queue = new LinkedList<>();
        queue.add(new TTuple<>(root,0) );

        while(!queue.isEmpty()){
            TTuple<Integer> tup = queue.poll();
            Node<Integer> node = tup.node;
            int x = tup.x;

            if(!map.containsKey(x)){       // if any map is not present at particular level , then add node value
                map.put(x,node.value);
            }

            // adding left and right child to queue
            if(node.left!=null && node.left.value!=-1)queue.offer(new TTuple<>(node.left,x-1));   // x-1 as its in left , y+1 as we are going down
            if(node.right!=null && node.right.value!=-1)queue.offer(new TTuple<>(node.right,x+1)); // x+1 as its in right , y+1 as we are going down

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
        ArrayList<Integer> traversalAntiClockWise = treeTopView(a);

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
