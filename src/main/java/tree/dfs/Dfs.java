package tree.dfs;

import java.util.*;
import java.util.function.Consumer;

/**
 *
 * @Problem == Implementation of DFS in Tree
 *
 * @Solution == Using Stack -- add node , remove it as visited then add all its neighbours
 *              In Dfs we traverse one side of tree first till leaf node then traverse neighbours
 *
 *             In this solution PreOrder is used to traverse the tree [ root --> all left --> all right ]
 *
 * @Complexity  == O(n) both time and space
 *
 * @author Saurabh Vaish
 * @Date 28-07-2021
 */

class Node<T>{
    public T value;
    Node<T> left,right;

    public Node(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class Dfs<T> {


    public void dfs(Node<T> root){
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root); // O(1)

        while (!stack.isEmpty()){
            Node<T> visited = stack.pop();
            System.out.print(visited.value+" ");

            if (visited.right!=null){
                stack.push(visited.right);      // adding right child first then left then left will be on top and will pop first so that we can print tree left side nodes then right
            }
            if (visited.left!=null){
                stack.push(visited.left);
            }
        }
    }

    // using recursion with stack
    public void dfsRecursionWithStack(Stack<Node<T>> stack){
        if(stack.isEmpty())return;
        Node<T> visited = stack.pop();
        System.out.print(visited.value+" ");
        if(visited.right!=null) {
            stack.add(visited.right);
        }
        if(visited.left!=null) {
            stack.add(visited.left);
        }
        dfsRecursionWithStack(stack);
    }

    // recursion without stack
    public void dfsRecursionWithoutStack(Node<T> node){
        if(node==null)return;
        System.out.print(node.value+" ");
        dfsRecursionWithoutStack(node.left);
        dfsRecursionWithoutStack(node.right);
    }

    public List<T> bfsReturningList(Node<T> root){
        List<T> list = new ArrayList<>();
        Stack<Node<T>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            Node<T> visited = stack.pop();

            list.add(visited.value);

            if (visited.right!=null){
                stack.push(visited.right);
            }
            if (visited.left!=null){
                stack.push(visited.left);
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Dfs<String> dfs = new Dfs<>();
        Node<String> a = new Node<>("a");
        Node<String> b = new Node<>("b");
        Node<String> c = new Node<>("c");
        Node<String> d = new Node<>("d");
        Node<String> e = new Node<>("e");
        Node<String> f = new Node<>("f");
        Node<String> g = new Node<>("g");
        Node<String> h = new Node<>("h");
        Node<String> i = new Node<>("i");

        //           a
        //       b      c
        //    d    e      f
        //  g   h    i

        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.left=f;
        d.left=g;
        d.right=h;
        e.right=i;

        System.out.print("DFS == ");
        dfs.dfs(a);

        System.out.print("\nDFS returning list== ");
        Consumer<String> consumer = (s)-> System.out.print(s+" ");
        dfs.bfsReturningList(a).forEach(consumer);

        System.out.print("\nDFS using recursion with stack == ");
        Stack<Node<String>> stack = new Stack<>();
        stack.push(a);
        dfs.dfsRecursionWithStack(stack);

        System.out.print("\nDFS using recursion without stack == ");
        dfs.dfsRecursionWithoutStack(a);


    }

}
