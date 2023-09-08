package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Link = https://www.codingninjas.com/studio/problems/time-to-burn-tree_630563
 *
 * You have been given a binary tree of 'N' unique nodes and a Start node from where the tree will start to burn.
 * Given that the Start node will always exist in the tree, your task is to print the time (in minutes) that it will take to burn the whole tree.
 * It is given that it takes 1 minute for the fire to travel from the burning node to its adjacent node and burn down the adjacent node.
 *
 * @Author saurabh vaish
 * @Date 02-07-2023
 */
public class TreeMinimumTimeToBurn {


    // Comp == O(n) + O(n)
    // to find the minimum time to burn nodes from a given node is similar to finding all nodes from that node ,
    // we need to look upwards and backwards both from that node, and count 1 on each traverse
    // to traverse upwards from node, we need to have info of parent node from that node , so for that will use map to store parent info
    // we will start looking for that node and once we reach on that ( or that node is already given ) , will store nodes in queue and will count distance
    // will use on visited node also so that we can not visit the same node
    public static int timeToBurnTree(Node<Integer> root, int start)
    {
        // Write your code here.
        Map<Node<Integer>,Node<Integer>> parentMap = new HashMap<>();

        // mapping nodes parent node
        Node<Integer> startNode = mapParentAndGetStartNode(parentMap,root,start);

        // visited node
        Map<Node<Integer>,Boolean> visited = new HashMap<>();

        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(startNode);
        visited.put(startNode,true);

        int time = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isAnyNodeBurnt=false;

            // iterating all nodes from queue that are added by previous node
            for(int i=0;i<size;i++){
                Node<Integer> node = queue.poll();

                // first check bottom nodes
                if(node.left!=null && visited.get(node.left)==null){
                    isAnyNodeBurnt=true;
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    isAnyNodeBurnt=true;
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                // check in parent
                if(parentMap.get(node)!=null && visited.get(parentMap.get(node))==null){
                    isAnyNodeBurnt=true;
                    queue.offer(parentMap.get(node));
                    visited.put(parentMap.get(node),true);
                }
            }

            if(isAnyNodeBurnt)time++;

        }

        return time;

    }


    private static Node<Integer> mapParentAndGetStartNode(Map<Node<Integer>, Node<Integer>> pareantMap, Node<Integer> root, int start) {
        Queue<Node<Integer>> q = new LinkedList<>();
        q.offer(root);
        Node<Integer> startNode = null;
        while(!q.isEmpty()){
            Node<Integer> node = q.poll();
            if(node.value==start)startNode = node;
            if(node.left!=null){
                pareantMap.put(node.left,node);
                q.offer(node.left);
            }
            if(node.right!=null){
                pareantMap.put(node.right,node);
                q.offer(node.right);
            }
        }

        return startNode;
    }
}
