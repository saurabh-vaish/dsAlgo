package stack;

/**
 * @Problem  == Implement a stack having constant time complexity
 *
 *
 * @author Saurabh Vaish
 * @Date 21-07-2021
 */


class StackNode<T>{
    public T value;
    public StackNode<T> next;

    StackNode(T value){
        this.value=value;
        this.next=null;
    }
}

public class Stack<T> {

    public StackNode<T> top;
    public int size;

    // O(1) both time and space
    public void push(T value){
        if(this.top==null){                     // if stack is empty
            this.top=new StackNode<>(value);
            this.size++;
            return;
        }
        StackNode<T> node=new StackNode<>(value);   // for rest of element
        node.next=this.top;
        this.top=node;
        this.size++;
    }

    // O(1)
    public T pop(){
        if(this.size==0 || this.top==null) return null;
        StackNode<T> node = this.top;
        this.top=this.top.next;  // making top node points out previous node
        this.size--;
        return node.value;
    }


    // O(n) in both approach , space - O(1) in iterative O(n) in recursive
    public void print(){
        if(this.size==0 || this.top==null) System.out.println("stack is empty");

        // iterative approach prints from last to first as top node is in last node of list
//        StackNode<T> node = this.top;
//        while (node!=null){
//            System.out.println(node.value);
//            node=node.next;
//        }

        // recursive approach
        this._print(this.top);
    }

    public void _print(StackNode<T> curr){
        if(curr==null) return;
        _print(curr.next);
        System.out.print(curr.value+" ");
    }

    // O(n) in both approach
    public boolean search(T element){
        if(this.size==0 || this.top==null) System.out.println("stack is empty");
        StackNode<T> node = this.top;
        // iterative
//        while (node!=null){
//            if(node.value==element)return true;
//            node=node.next;
//        }
//        return false;

        // recursive
        return this._search(node,element);
    }

    private boolean _search(StackNode<T> node, T element) {
        if(node==null)return false;
        return node.value == element || _search(node.next, element);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        System.out.println("\nsize ="+stack.size);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        stack.print();
        System.out.println("\nsize ="+stack.size);

        System.out.println(stack.search(2));
        System.out.println(stack.search(4));
    }

}
