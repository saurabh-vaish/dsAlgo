package tree.bfs;

//import queue.Queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @Problem == Find sum of the tree using bfs
 *
 * @Solution == Using linked list -- add node , remove it as visited then add all its neighbours
 *
 * @Complexity  == O(n)
 *
 * @author Saurabh Vaish
 * @Date 27-07-2021
 */

class Nodes<T> {
    public T value;
    Nodes<T> left,right;

    public Nodes(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class BfsSum {


    public int sum(Nodes<Integer> root){
        Queue<Nodes<Integer>> queue = new LinkedList<>();
        queue.add(root); // O(1)
        int sum=0;
        while (!queue.isEmpty()){
            Nodes<Integer> visited = queue.poll();  // similar to dequeue() in queue O(1)

            sum+=visited.value;
            if (visited.left!=null){
                queue.add(visited.left);
            }
            if (visited.right!=null){
                queue.add(visited.right);
            }
        }
        return sum;
    }

    public int sum(Queue<Nodes<Integer>> queue,int sum){
        if(queue.isEmpty())return sum;
        Nodes<Integer> visited = queue.poll();

        sum+=visited.value;

        if(visited.left!=null) {
            queue.add(visited.left);
        }
        if(visited.right!=null) {
            queue.add(visited.right);
        }
        return sum(queue,sum);
    }



    public static void main(String[] args) {
        BfsSum bfsSum = new BfsSum();
        Nodes<Integer> a = new Nodes<>(1);
        Nodes<Integer> b = new Nodes<>(2);
        Nodes<Integer> c = new Nodes<>(3);
        Nodes<Integer> d = new Nodes<>(4);
        Nodes<Integer> e = new Nodes<>(5);
        Nodes<Integer> f = new Nodes<>(6);

        //      a
        //   b      c
        // d    e   f

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;

        System.out.println("BFS == ");
        System.out.println(bfsSum.sum(a));

        System.out.println("\nBFS using recursion == ");
        Queue<Nodes<Integer>> queue = new LinkedList<>();
        queue.add(a);
        System.out.println(bfsSum.sum(queue,0));


    }

}
