package tree;

import java.util.*;
import java.util.stream.Stream;

/**
 * @link = https://www.codingninjas.com/studio/problems/vertical-order-traversal_920533?topList=striver-sde-sheet-problems&leftPanelTab=0
 *
 *  In verticle order traversal we will traverse from left to right and will add node which are on same level[ verticle ] .
 *  For this assume tree is in grid , so all left will be on negative coordinates and right will be on positive . and going down will increase verticle level
 *  So for this we can use TreeMap [ sorting ] map to store node on horizontal level and again another map for verticle level
 *  Will traverse in level order from left to right and in the end will from list from map
 *
 * @Author saurabh vaish
 * @Date 25-06-2023
 */


class Tuple<T>{
    Node<T> node;
    int x; // for horizontal positioning
    int y; // for vertical positioning

    Tuple(){}

    public Tuple(Node node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}

public class TreeVerticleTraversal {


    // complexity == O(N + M)
    public static ArrayList<Integer> verticalOrderTraversal(Node<Integer> root)
    {
        ArrayList<Integer> list = new ArrayList<>();

//        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
// first map key is of vertex , second map is the level , ArrayList for elements for ordering at same points
        TreeMap<Integer,TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        Queue<Tuple<Integer>> queue = new LinkedList<>();
        queue.add(new Tuple<>(root,0,0) );

        while(!queue.isEmpty()){
            Tuple<Integer> tup = queue.poll();
            Node<Integer> node = tup.node;
            int x = tup.x;
            int y = tup.y;

            if(!map.containsKey(x)){            // if any map is not present at particular verex , then add new map
                map.put(x,new TreeMap<>());
            }

            // check for level , vertical position at particular vertex x
            if(!map.get(x).containsKey(y)){
                map.get(x).put(y,new ArrayList<>());
            }

            map.get(x).get(y).add(node.value); // now add value to that node at x and y position

            // adding left and right child to queue
            if(node.left!=null && node.left.value!=-1)queue.offer(new Tuple<>(node.left,x-1,y+1));   // x-1 as its in left , y+1 as we are going down
            if(node.right!=null && node.right.value!=-1)queue.offer(new Tuple<>(node.right,x+1,y+1)); // x+1 as its in right , y+1 as we are going down

        }

        for(Map<Integer, ArrayList<Integer>> m: map.values()){
            for(ArrayList<Integer> p:m.values()){
                    list.addAll(p);
            }
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



        Stream.of("52339 83345 90332 37943 99712 79113 80584 90598 15122 1919 8874 25058 56505 38126 99654 83171 45265 52404 85680 72702 24626 24896 74425 66560 71632 67970 7676 26895 84108 4068 42008 48444 96170 50807 929 23542 88012 93638 28262 51133 73715 71624 82079 89479 21785 83905 81257 35769 42908 251 16552 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1".split(" ")).mapToInt(Integer::valueOf).forEach(ee->{
            insert(root,ee);
        });

        System.out.print("boundary traversal anti clock wise == ");
        ArrayList<Integer> traversalAntiClockWise = verticalOrderTraversal(root);

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
