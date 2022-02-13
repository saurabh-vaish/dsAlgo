package tree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @Problem == Implementation of DFS in Tree
 *
 * @Solution == Using Stack -- add node , remove it as visited then add all its neighbours
 *              In DfsSum we traverse one side of tree first till leaf node then traverse neighbours
 *
 * @Complexity  == O(n) both time and space
 *
 * @author Saurabh Vaish
 * @Date 28-07-2021
 */

class Nodes<T>{
    public T value;
    Nodes<T> left,right;

    public Nodes(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class DfsSum<T> {


    public int dfsSum(Nodes<Integer> root){
        Stack<Nodes<Integer>> stack = new Stack<>();
        stack.push(root); // O(1)
        
        int sum=0;
        while (!stack.isEmpty()){
            Nodes<Integer> visited = stack.pop();

            sum+=visited.value;
            
            if (visited.right!=null){
                stack.push(visited.right);      // adding right child first then left then left will be on top and will pop first so that we can print tree left side nodes then right
            }
            if (visited.left!=null){
                stack.push(visited.left);
            }
        }
        return sum;
    }

    // using recursion with stack
    public int dfsSumRecursionWithStack(Stack<Nodes<Integer>> stack,int sum){
        if(stack.isEmpty())return sum;
        Nodes<Integer> visited = stack.pop();
        
        sum+=visited.value;
        
        if(visited.right!=null) {
            stack.add(visited.right);
        }
        if(visited.left!=null) {
            stack.add(visited.left);
        }
        return dfsSumRecursionWithStack(stack,sum);
    }

    // recursion without stack , using in order
    public int dfsSumRecursiveWithoutStack(Nodes<Integer> node){
        if(node==null)return 0;
        return dfsSumRecursiveWithoutStack(node.left) + node.value + dfsSumRecursiveWithoutStack(node.right);
    }





    public static void main(String[] args) {
        DfsSum<Integer> dfs = new DfsSum<>();
        Nodes<Integer> a = new Nodes<>(1);
        Nodes<Integer> b = new Nodes<>(2);
        Nodes<Integer> c = new Nodes<>(3);
        Nodes<Integer> d = new Nodes<>(4);
        Nodes<Integer> e = new Nodes<>(5);
        Nodes<Integer> f = new Nodes<>(6);
        Nodes<Integer> g = new Nodes<>(7);
        Nodes<Integer> h = new Nodes<>(8);
        Nodes<Integer> i = new Nodes<>(9);

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

        System.out.print("DFS  sum iterative == ");
        System.out.println(dfs.dfsSum(a));

        System.out.print("\nDFS sum using recursion with stack == ");
        Stack<Nodes<Integer>> stack = new Stack<>();
        stack.push(a);
        System.out.println(dfs.dfsSumRecursionWithStack(stack,0));

        System.out.print("\nDFS sum using recursion without stack == ");
        System.out.println(dfs.dfsSumRecursiveWithoutStack(a));


    }

}
