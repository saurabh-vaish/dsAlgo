package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @Author saurabh vaish
 * @Date 08-07-2023
 */
public class TreeHeightFromInOrderAndLevelOrder {

    public static int heightOfTheTree(int[] inorder, int[] levelOrder, int N){
        // Write your code here.

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();

        build(inorder,0,inorder.length,inorder,0,inorder.length,left,right,levelOrder,0,map);

        return Math.max(left.size(), right.size())-1;
    }

    static void build(int [] leftin,int is,int ie,int [] rightin,int ps ,int pe,Queue<Integer> left,
                      Queue<Integer> right,int [] level,int ind, Map<Integer,Integer> map){

        if(ind>level.length-1)return;

        Integer lroot = map.get(level[ind]);
        if(leftin[lroot]!=-1)return;
        if(lroot!=null && lroot>=is && lroot<=ie && leftin[lroot]!=-1){
            left.add(leftin[lroot]);
            leftin[lroot]=-1;
        }
        Integer rroot = map.get(level[ind]);
        if(leftin[rroot]!=-1)return;
        if(rroot!=null && rroot>=ps && rroot<=pe && leftin[rroot]!=-1){
            right.add(leftin[rroot]);
            leftin[rroot]=-1;
        }

        build(leftin, is, lroot-1, rightin, rroot+1, pe, left, right,level,++ind,map);

    }


    public static void main(String[] args) {
        int [] in = {4,2,5,1,6, 3,7};
        int [] l = {1, 2, 3, 4, 5,6,7};

        System.out.println(heightOfTheTree(in,l,5));
    }

}
