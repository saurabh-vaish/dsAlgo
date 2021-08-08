package dpp;

import java.util.HashMap;
import java.util.Map;

/**
 * @Problem == In a given grid [ row , col] find no of ways we can travel from top to bottom last element by going only down or right.
 *
 *              e.g. in a grid [3,3] starting from 0,0 we have to reach 3,3 by going eight down or rightwards .
 *
 * @Solution  == we will try to reach by reducing row , col one by one
 *              if any row or col is zero means grid is not possible .
 *              if we reached at 1,1 means there is a valid path .
 *
 * @Complexity  == Height of tree is row + col
 *                 bruteforce = time - O(2^(row+col)) , space - O(row+col)
 *                 memoized = time - O(row * col) , space - O(row+col)
 *
 *
 * @author Saurabh Vaish
 * @Date 31-07-2021
 */
public class GridTraveller {
    private static Map<String,Integer> map = new HashMap<>();
    private static Map<String,Integer> map2 = new HashMap<>();

    public static void main(String[] args) {
        int row = 3; // 30
        int col = 3; // 30
//        int ways = gridTravell(row,col);
//        System.out.println("no of ways = "+ways);
        int waysOp = gridTravellOptimize(row,col, map);
        System.out.println("no of ways optimize = "+waysOp);
        int waysOp2 = gridTravellOptimize2(row,col, map2);
        System.out.println("no of ways optimize2 = "+waysOp2);
    }

    private static int gridTravell(int row, int col) {
        if(row==0 || col==0)return 0; // grid not possible
        if(row==1 && col==1)return 1; // means we have reached to end
        return gridTravell(row-1, col)+gridTravell(row, col-1);  // going down + going right
    }


    private static int gridTravellOptimize(int row, int col, Map<String, Integer> map) {
        if(row==0 || col==0)return 0;
        if(row==1 && col==1)return 1;
        if(map.containsKey(row+","+col))return map.get(row+","+col);
        else {
            int w = gridTravellOptimize(row-1, col, map)+gridTravellOptimize(row, col-1, map); // down + right
            map.put(row+","+col, w);
            return w;
        }
    }

    // here we are storing row,col and col,row both in map as result of 2,1 and 1,2 is same
    private static int gridTravellOptimize2(int row, int col, Map<String, Integer> map2) {
        if(row==0 || col==0)return 0;
        if(row==1 && col==1)return 1;
        if(map2.containsKey(row+","+col))return map2.get(row+","+col);
        if(map2.containsKey(col+","+row))return map2.get(col+","+row);
        else {
            int w = gridTravellOptimize(row-1, col, map2)+gridTravellOptimize(row, col-1, map2); // down + right
            map2.put(row+","+col, w);
            map2.put(col+","+row, w);
            return w;
        }
    }
}
