package tree;

public class Node<T>{
    public T value;
    Node<T> left,right;

    public Node(T value){
        this.value=value;
        this.left=this.right=null;
    }
}