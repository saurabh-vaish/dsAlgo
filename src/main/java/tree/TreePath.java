package tree;


import java.util.*;
import java.util.stream.Stream;

/**
 * @Link = https://www.codingninjas.com/studio/problems/path-in-a-tree_3843990?topList=striver-sde-sheet-problems&leftPanelTab=0
 *
 * You are given a binary tree with ‘N’ number of nodes and a node ‘X’. Your task is to print the path from the root node to the given node ‘X’.
 *
 * print the path from root to the matching node
 *
 * @Author saurabh vaish
 * @Date 24-06-2023
 */

class PNode {
    int val;
    PNode left;
    PNode right;

    PNode(){

    }

    PNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class TreePath {

    private static PNode root = null;
    public static List<Integer> getPath(PNode root, int x) {

        List<Integer> list = new ArrayList<>();
        dfs(root,x,list);

        return list;
    }

    // O(n + v)
    static boolean dfs(PNode node,int x,List<Integer> list){
        if(node==null || node.val==-1)return false;

        list.add(node.val);        // adding data to list
        if(node.val==x)return true;    // if matched return

        boolean left = dfs(node.left,x,list); // traverse left
        if(left)return true; // if already found then return no need to go further

        boolean right = dfs(node.right,x,list); // traverse right
        if(right)return true; // if found return

        list.remove(list.size()-1); // value not mathced in subtree , remove element

        return false; // return false as value not matched
    }

    // insert in tree using level order
    static void insert(PNode temp, int key)
    {

        if (temp == null) {
            root = new PNode(key);
            return;
        }
        Queue<PNode> q = new LinkedList<>();
        q.add(temp);

        // Do level order traversal until we find
        // an empty place.
        while (!q.isEmpty()) {
            temp = q.peek();
            q.remove();

            if (temp.left == null) {
                temp.left = new PNode(key);
                break;
            }
            else
                q.add(temp.left);

            if (temp.right == null) {
                temp.right = new PNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {

        Stream.of( "1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1".split(" ")).mapToInt(Integer::valueOf).forEach(e->{
            insert(root,e);
        });

        getPath(root,7).stream().forEach(e-> System.out.print(e+" "));
    }
}
