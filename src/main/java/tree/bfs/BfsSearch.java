package tree.bfs;

//import queue.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Problem == Find an element in tree using bfs in tree
 *
 * @Solution == Using linked list -- add node , remove it as visited then add all its neighbours
 *
 * @Complexity  == O(n)
 *
 * @author Saurabh Vaish
 * @Date 27-07-2021
 */

class Nodee<T> {
    public T value;
    Nodee<T> left,right;

    public Nodee(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class BfsSearch<T> {


    public boolean search(Nodee<String> root,String target){
        Queue<Nodee<String>> queue = new LinkedList<>();
        queue.add(root); // O(1)

        while (!queue.isEmpty()){
            Nodee<String> visited = queue.poll();  // similar to dequeue() in queue O(1)

            if(visited.value.equalsIgnoreCase(target))
                return true;

            if (visited.left!=null){
                queue.add(visited.left);
            }
            if (visited.right!=null){
                queue.add(visited.right);
            }
        }
        return false;
    }

    public boolean search(Queue<Nodee<String>> queue,String target){
        if(queue.isEmpty())return false;
        Nodee<String> visited = queue.poll();

        if(visited.value.equalsIgnoreCase(target))
            return true;

        if(visited.left!=null) {
            queue.add(visited.left);
        }
        if(visited.right!=null) {
            queue.add(visited.right);
        }
        return search(queue,target);
    }



    public static void main(String[] args) {
        BfsSearch<String> bfsSearch = new BfsSearch<>();
        Nodee<String> a = new Nodee<>("a");
        Nodee<String> b = new Nodee<>("b");
        Nodee<String> c = new Nodee<>("c");
        Nodee<String> d = new Nodee<>("d");
        Nodee<String> e = new Nodee<>("e");
        Nodee<String> f = new Nodee<>("f");

        //      a
        //   b      c
        // d    e   f

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;

        System.out.println("BFS == ");
        System.out.println(bfsSearch.search(a,"e"));
        System.out.println(bfsSearch.search(a,"z"));

        System.out.println("\nBFS using recursion == ");
        Queue<Nodee<String>> queue = new LinkedList<>();
        queue.add(a);
        System.out.println(bfsSearch.search(queue,"e"));
        System.out.println(bfsSearch.search(queue,"z"));


    }

}
