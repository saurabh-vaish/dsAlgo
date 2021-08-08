package tree.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

/**
 *
 * @Problem == Implementation of BFS in Tree
 *
 * @Solution == Using linked list -- add node , remove it as visited then add all its neighbours
 *
 * @Complexity  == O(n)
 *
 * @author Saurabh Vaish
 * @Date 27-07-2021
 */

class Node<T>{
    public T value;
    Node<T> left,right;

    public Node(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class Bfs<T> {


    public void bfs(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root); // O(1)

        while (!queue.isEmpty()){
            Node<T> visited = queue.poll();  // similar to dequeue() in queue O(1)
            System.out.print(visited.value+" ");
            if (visited.left!=null){
                queue.add(visited.left);
            }
            if (visited.right!=null){
                queue.add(visited.right);
            }
        }
    }

    public void bfs(Queue<Node<T>> queue){
        if(queue.isEmpty())return;
        Node<T> visited = queue.poll();
        System.out.print(visited.value+" ");
        if(visited.left!=null) {
            queue.add(visited.left);
        }
        if(visited.right!=null) {
            queue.add(visited.right);
        }
        bfs(queue);
    }

    public List<T> bfsReturningList(Node<T> root){
        List<T> list = new ArrayList<>();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            Node<T> visited = queue.poll();

            list.add(visited.value);
            if (visited.left!=null){
                queue.add(visited.left);
            }
            if (visited.right!=null){
                queue.add(visited.right);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Bfs<String> bfs = new Bfs<>();
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");

        //      a
        //   b      c
        // d    e   f

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;

        System.out.println("BFS == ");
        bfs.bfs(a);

        System.out.println("\nBFS returning list== ");
        Consumer<String> consumer = (s)-> System.out.print(s+" ");
        bfs.bfsReturningList(a).forEach(consumer);

        System.out.println("\nBFS using recursion == ");
        Queue<Node<String>> queue = new LinkedList<>();
        queue.add(a);
        bfs.bfs(queue);


    }

}
