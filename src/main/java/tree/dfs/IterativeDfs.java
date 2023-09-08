package tree.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;

/**
 *
 * @Problem == Implementation of DFS in Tree
 *
 * @Solution == Using Stack -- add DNode , remove it as visited then add all its neighbours
 *              In Dfs we traverse one side of tree first till leaf DNode then traverse neighbours
 *
 *             In this solution PreOrder is used to traverse the tree [ root --> all left --> all right ]
 *
 * @Complexity  == O(n) both time and space
 *
 * @author Saurabh Vaish
 * @Date 28-07-2021
 */

class DNode<T>{
    public T value;
    DNode<T> left,right;

    public DNode(T value){
        this.value=value;
        this.left=this.right=null;
    }
}

public class IterativeDfs<T> {


    // iterative preorder traversal , using stack
    // Comp == O(n)  both
    public List<T> preorder(DNode<T> root){
        List<T> list = new ArrayList<>();
        Stack<DNode<T>> stack = new Stack<>();
        stack.push(root); // O(1)

        while (!stack.isEmpty()){
            DNode<T> visited = stack.pop();
//            System.out.print(visited.value+" ");
            list.add(visited.value);

            if (visited.right!=null){
                stack.push(visited.right);      // adding right child first then left as left will be on top and will pop first so that we can print tree left side DNodes then right
            }
            if (visited.left!=null){
                stack.push(visited.left);
            }
        }

        return list;
    }



    // iterative inorder traversal , using stack
    // Comp == O(n)  both
    public List<T> inorder(DNode<T> root){
        List<T> list = new ArrayList<>();
        Stack<DNode<T>> stack = new Stack<>();

        DNode<T> node = root;
        while (true){
            if(node!=null){         // if node is not empty , we will go all left
                stack.push(node);
                node = node.left;

            }else{
                if(stack.isEmpty()){
                    break;
                }
                node = stack.pop();   // get element from stack
                list.add(node.value);

                node = node.right;  // go all right
            }
        }

        return list;
    }


    // iterative postorder traversal , using 2 stack
    // Comp == Time= O(n)  , Space =O(2n)
    public List<T> postorderUsingTwoStack(DNode<T> root){
        List<T> list = new ArrayList<>();
        Stack<DNode<T>> st1 = new Stack<>(); // for normal store
        Stack<DNode<T>> st2 = new Stack<>();  // for postorder

        st1.add(root);
        while (!st1.isEmpty()){
            DNode<T> node = st1.pop();
            st2.add(node);
            if(node.left!=null)st1.add(node.left);
            if(node.right!=null)st1.add(node.right);
        }

        while(!st2.isEmpty()){
            list.add(st2.pop().value);
        }

        return list;
    }


    // iterative preorder ,inorder , postorder traversal , using stack
    // here we are taking help of a class in which we will store data and count on how many times node gets traversed
    // we wil take help of stack also in which we will first insert node and remove every time it gets travesed and will adding by adding count
    // count 1 will be added to pre , 2 to in and 3 will be in post order
    // Comp == O(3n)  both
    public List<List<T>> preorderInorderPostorder(DNode<T> root){
        List<List<T>> list = new ArrayList<>();
        class Pair<T>{
            DNode<T> node;
            int count;

            Pair(){}

            Pair(DNode no,int c){
                node=no;
                count=c;
            }
        }

        Stack<Pair<T>> st = new Stack<>();
        List<T> pre = new ArrayList<>();  // for inorder
        List<T> in = new ArrayList<>();  // for inorder
        List<T> post = new ArrayList<>();  // for inorder

        st.add(new Pair(root,1));

        while (!st.isEmpty()){
            Pair<T> pair = st.pop();

            if(pair.count==1){ // preorder
                pre.add(pair.node.value);
                pair.count++;
                st.push(pair);

                if(pair.node.left!=null)st.add(new Pair<>(pair.node.left,1)); // going all left as root node is already added
            }
            else if(pair.count==2){         // inorder
                in.add(pair.node.value);
                pair.count++;
                st.push(pair);

                if(pair.node.right!=null)st.add(new Pair<>(pair.node.right,1));

            }else{  // postorder
                post.add(pair.node.value);
            }
        }

        list.add(pre);
        list.add(in);
        list.add(post);
        return list;
    }



    // using single recursion
    public static void solve(DNode<Integer> root,List<Integer> in,List<Integer> pre,List<Integer> po){

        if(root==null)return;

        pre.add(root.value);

        solve(root.left,in,pre,po);

        in.add(root.value);

        solve(root.right,in,pre,po);

        po.add(root.value);

    }

    // using recursion with stack
    public void dfsRecursionWithStack(Stack<DNode<T>> stack){
        if(stack.isEmpty())return;
        DNode<T> visited = stack.pop();
        System.out.print(visited.value+" ");
        if(visited.right!=null) {
            stack.add(visited.right);
        }
        if(visited.left!=null) {
            stack.add(visited.left);
        }
        dfsRecursionWithStack(stack);
    }



    public static void main(String[] args) {
        IterativeDfs<String> dfs = new IterativeDfs<>();
        DNode<String> a = new DNode<>("a");
        DNode<String> b = new DNode<>("b");
        DNode<String> c = new DNode<>("c");
        DNode<String> d = new DNode<>("d");
        DNode<String> e = new DNode<>("e");
        DNode<String> f = new DNode<>("f");
        DNode<String> g = new DNode<>("g");
        DNode<String> h = new DNode<>("h");
        DNode<String> i = new DNode<>("i");

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

        System.out.print("Preorder == ");
        dfs.preorder(a).forEach(ee-> System.out.print(ee+" "));
        System.out.println();

        System.out.print("Inorder == ");
        dfs.inorder(a).forEach(ee-> System.out.print(ee+" "));
        System.out.println();

        System.out.print("Postorder using two stack == ");
        dfs.postorderUsingTwoStack(a).forEach(ee-> System.out.print(ee+" "));
        System.out.println();

        System.out.print("Preorder Inorder Postorder in one loop == ");
        dfs.preorderInorderPostorder(a).forEach(ee->{
            System.out.println();
            ee.forEach(it->System.out.print(it+" "));
        });

    }

}
