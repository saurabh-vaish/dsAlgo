package tree.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @Problem == Implementation of DFS in Tree
 *
 * @Solution == Using Stack -- add node , remove it as visited then add all its neighbours
 *              In Dfs we traverse one side of tree first till leaf node then traverse neighbours
 *
 * @Complexity  == O(n) both time and space
 *
 * @author Saurabh Vaish
 * @Date 28-07-2021
 */

class Nodee<T>{
    public T value;
    Nodee<T> left,right;

    public Nodee(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class DfsOrder<T> {


    // preorder using dfs === root , left , right ==> root first then left sub tree then right subtree
    public void dfsPreOrder(Nodee<T> node){
        if(node==null)return;
        System.out.print(node.value+" ");
        dfsPreOrder(node.left);
        dfsPreOrder(node.right);
    }

    // postorder using dfs ===  left , right ,root ==> left sub tree first then right subtree then root
    public void dfsPostOrder(Nodee<T> node){
        if(node==null)return;
        dfsPostOrder(node.left);
        dfsPostOrder(node.right);
        System.out.print(node.value+" ");
    }

    // inorder using dfs ===  left ,root , right ==> left sub tree first then root then right subtree
    public void dfsInOrder(Nodee<T> node){
        if(node==null)return;
        dfsInOrder(node.left);
        System.out.print(node.value+" ");
        dfsInOrder(node.right);
    }



    public List<T> dfsPreorderIteration(Nodee<T> root){

        List<T> list= new LinkedList<>();
        Stack<Nodee<T>> stack = new Stack<>();
        stack.push(root); // O(1)

        while (!stack.isEmpty()){
            Nodee<T> visited = stack.pop();

            list.add(visited.value);

            if (visited.right!=null){
                stack.push(visited.right);      // adding right child first then left then left will be on top and will pop first so that we can print tree left side nodes then right
            }
            if (visited.left!=null){
                stack.push(visited.left);
            }
        }

        return list;
    }


    public List<T> dfsInOrderIteration(Nodee<T> root){
        List<T> list = new LinkedList<>();
        Stack<Nodee<T>> stack = new Stack<>();

        Nodee<T> visited = root;
        while (true){
            if(visited!=null){   // first going to left part of tree till leaf node
                stack.push(visited);
                visited=visited.left;
            }else{
                if(stack.isEmpty()){
                    break;
                }
                visited=stack.pop();
                list.add(visited.value);
                visited=visited.right;
            }

        }

        return list;
    }

    public List<T> dfsPostOrderIteration(Nodee<T> root) {
        List<T> list = new LinkedList<>();
        Stack<Nodee> stack = new Stack<>();
        while (true) {
            while (root != null) {
                stack.push(root);
                stack.push(root);
                root = root.left;
            }

            // Check for empty stack
            if (stack.empty()) break;
            root = stack.pop();
            if (!stack.empty() && stack.peek() == root) root = root.right;
            else {
//                System.out.print(root.value + " ");
                list.add(root.value);
                root = null;
            }
        }

        return list;
    }

    public static void main(String[] args) {
        DfsOrder<String> dfs = new DfsOrder<>();
        Nodee<String> a = new Nodee<>("a");
        Nodee<String> b = new Nodee<>("b");
        Nodee<String> c = new Nodee<>("c");
        Nodee<String> d = new Nodee<>("d");
        Nodee<String> e = new Nodee<>("e");
        Nodee<String> f = new Nodee<>("f");
        Nodee<String> g = new Nodee<>("g");
        Nodee<String> h = new Nodee<>("h");
        Nodee<String> i = new Nodee<>("i");

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

        System.out.print("Dfs pre order  == ");
        dfs.dfsPreOrder(a);

        System.out.print("\nDFS post order == ");
        dfs.dfsPostOrder(a);

        System.out.print("\nDFS in order == ");
        dfs.dfsInOrder(a);

        System.out.print("\nDfs pre order using iteration  == ");
        dfs.dfsPreorderIteration(a).forEach(s-> System.out.print(s+" "));

        System.out.print("\nDFS post order == ");
        dfs.dfsPostOrderIteration(a).forEach(s-> System.out.print(s+" "));;

        System.out.print("\nDFS in order using iteration == ");
        dfs.dfsInOrderIteration(a).forEach(s-> System.out.print(s+" "));


    }

}
