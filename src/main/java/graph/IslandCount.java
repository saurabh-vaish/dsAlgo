package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * @Problem == In a given matrix containing Ws and Ls. W represents water and L represents land. The function should return the number of islands on the grid.
 *              An island is a vertically or horizontally connected region of land.
 *
 * @Solution  === Loop through each cell and do dfs if having any land then count no of lands
 *              NOte :- marks land as visited to overcome cyclic calls
 *
 * @Complexity -- O(r*c)   , r=row ,c = cols
 *
 *
 * @author Saurabh Vaish
 * @Date 08-08-2021
 */
public class IslandCount {


    public static void main(String[] args) {


//        String [][] island = {  {"W", "L", "W", "W", "W"},
//                                {"W", "L", "W", "W", "W"},
//                                {"W", "W", "W", "L", "W"},
//                                {"W", "W", "L", "L", "W"},
//                                {"L", "W", "W", "L", "L"},
//                                {"L", "L", "W", "W", "W"} };
        String [][] island = {  {"L", "W", "W", "L", "W"},
                                {"L", "W", "W", "L", "L"},
                                {"W", "L", "W", "L", "W"},
                                {"W", "W", "W", "W", "W"},
                                {"W", "W", "L", "L", "L"} };

        int count = getIslandCount(island);
        System.out.println("total islands = "+count);
    }

    private static int getIslandCount(String[][] island) {
        Set<String> visited = new HashSet<>();
        int count = 0;
        // looping thoough matrix
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if(island[r][c].equals("L")){   // each each cell and do dfs only on land cell
                    boolean isLandComponent = exploreGraph(island,r,c,visited);
                    if(isLandComponent)count++;   // if traversal returns land then increase count
                }
            }
        }
        return count;
    }

    private static boolean exploreGraph(String[][] island, int r, int c, Set<String> visited) {
        boolean rowBound = 0 <=r && r< island.length;           // checking row inbound condition
        boolean colBound = 0 <=c && c< island[0].length;        // checking col inbound condition

        if(!rowBound || !colBound)return false;

        if(island[r][c].equals("W"))return false;       // if any water cell means no land , need to traverse only land cells

        String val= r+","+c;
        if(visited.contains(val))return false;          // checking cell as visited
        visited.add(val);                               // marking cell as visited

        exploreGraph(island, r+1, c, visited);      // traverse on upper cell
        exploreGraph(island, r-1, c, visited);     // traverse on lower cell
        exploreGraph(island, r, c+1, visited);     // traverse on left cell
        exploreGraph(island, r, c-1, visited);     // traverse on right cell

        return true;                                // if all base conditions passes return true
    }

}
