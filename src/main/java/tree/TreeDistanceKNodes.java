package tree;

import java.util.*;

/**
 * @Link = https://www.codingninjas.com/studio/problems/print-nodes-at-distance-k-from-a-given-node_842560
 *
 *  In a binary tree from a given node , print all nodes which are at distance k
 *
 * @Author saurabh vaish
 * @Date 02-07-2023
 */
public class TreeDistanceKNodes {


    // complexity == O(n) + O(n)
    // to find the k distance nodes from a given node , we need to look upwards and backwards both from that node, and count 1 on each traverse
    // to traverse upwards from node, we need to have info of parent node from that node , so for that will use map to store parent info
    // we will start looking for that node and once we reach on that ( or that node is already given ) , will store nodes in queue and will count distance
    // will use on visited node also so that we can not visit the same node
    public static ArrayList<Node<Integer>> printNodesAtDistanceK(Node<Integer> root, Node<Integer> target, int K) {
        // Write your code here.
        Map<Node<Integer>,Node<Integer>> parentMap = new HashMap();
        mapParent(parentMap,root);  // getting parent map of nodes

        Map<Node<Integer>,Boolean> visited = new HashMap<>();  // visited map

        Queue<Node<Integer>> queue = new LinkedList<>();  // queue to add element from target
        queue.offer(target);
        visited.put(target,true);

        int count = 0;
        while(!queue.isEmpty()){   //  bfs to get nodes at each distance

            if(count==K)break;  // distance matched , break and remaining nodes in queue will be at distance K from target
            count++;

            int size = queue.size();

            // iterating all nodes from queue that are added by previous node
            for(int i=0;i<size;i++){
                Node<Integer> node = queue.poll();

                // first check bottom nodes
                if(node.left!=null && visited.get(node.left)==null){
                    queue.offer(node.left);
                    visited.put(node.left,true);
                }
                if(node.right!=null && visited.get(node.right)==null){
                    queue.offer(node.right);
                    visited.put(node.right,true);
                }
                // check in parent
                if(parentMap.get(node)!=null && visited.get(parentMap.get(node))==null){
                    queue.offer(parentMap.get(node));
                    visited.put(parentMap.get(node),true);
                }
            }


        }

        ArrayList<Node<Integer>> list = new ArrayList<>();

        while(!queue.isEmpty()){
            list.add(queue.poll());
        }

        return list;

    }



    private static void mapParent(Map<Node<Integer>,Node<Integer>> map,Node<Integer> root){
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<Integer> node = queue.poll();

            if(node.left!=null){
                queue.add(node.left);
                map.put(node.left,node);
            }
            if(node.right!=null){
                queue.add(node.right);
                map.put(node.right,node);
            }
        }
    }

}
