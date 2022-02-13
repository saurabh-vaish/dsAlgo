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
                queue.offer(visited.left);  // offer used bcs it will not throw exception if insertion is failed
            }
            if (visited.right!=null){
                queue.offer(visited.right);
            }
        }
    }

    public void bfs(Queue<Node<T>> queue){
        if(queue.isEmpty())return;
        Node<T> visited = queue.poll();
        System.out.print(visited.value+" ");
        if(visited.left!=null) {
            queue.offer(visited.left);
        }
        if(visited.right!=null) {
            queue.offer(visited.right);
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
                queue.offer(visited.left);
            }
            if (visited.right!=null){
                queue.offer(visited.right);
            }
        }
        return list;
    }

    // bfs level order traversal
    public void bfsLevelWise(Node<T> root,List<List<T>> list){
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root); // O(1)

        while (!queue.isEmpty()){
            List<T> levelList = new LinkedList<>();
            int level = queue.size();
            for(int i=0;i< level;i++) {
                Node<T> visited = queue.peek();  // similar to dequeue() in queue O(1)
                if (visited.left != null) {
                    queue.offer(visited.left);
                }
                if (visited.right != null) {
                    queue.offer(visited.right);
                }
                levelList.add(queue.poll().value);
            }
            list.add(levelList);
        }
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

        System.out.println("\nlevel wise bfs ===");
        List<List<String>> list =new LinkedList<>();
        bfs.bfsLevelWise(a,list);

        list.forEach(l->{
            l.forEach(s-> System.out.print(s+" "));
            System.out.println();
        });

    }

}
