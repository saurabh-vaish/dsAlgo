package graph;

import CtCILibrary.AssortedMethods;

/**
 *  https://www.codingninjas.com/studio/problems/flood-fill-algorithm_1089687?topList=striver-sde-sheet-problems&leftPanelTab=1
 *
 * The image is represented in the form of a 2D array of size M * N. Each pixel in the image is a positive integer. Ninja has given you the coordinates (row and column) of a certain pixel and the new color value. You need to replace the color of the given pixel and all adjacent same-colored pixels with the new color.
 *
 *  Fill the image with the provided color , the color that we will replace is available on sr and sc coordinates
 *
 * @Author saurabh vaish
 * @Date 16-07-2023
 */
public class Graph5_FloodFill {


    // time = O(n + m) + O(4 * x) ,
    // space == O(n + m)
    // to flood fill the image , first we will create new ans array and will get initial color from sr and sc
    // will do dfs and start filling will fill only those in which init color will match
    // and during traversal can go only 4 directions
    public static int [][] floodFill(int [][] image,int sr,int sc,int newColor){

        int ans [][] = image; // ans array

        int initColor = image[sr][sc];  // initial color that we need to replace

        boolean [][] visited = new boolean[image.length][image[0].length]; // visited array

        int [] delRow = {-1,0,1,0}; // upper , right, down, left
        int [] delCol = {0,1,0,-1}; // upper , right, down, left
        // using these two arrays we pic coordinates from both arrays and will get neighbours

        dfs(sr,sc,ans,image,initColor,newColor,visited,delRow,delCol);

        return ans;
    }

    // O(n+m) + O(4 * x)
    private static void dfs(int sr, int sc, int[][] ans,int[][] image, int initColor, int newColor, boolean[][] visited, int[] delRow, int[] delCol) {
        // replace initColor with newColor
        ans[sr][sc] = newColor;

        visited[sr][sc]=true;

        int row = ans.length;
        int col = ans[0].length;

        for(int i=0;i<4;i++){ // as we have only 4 possible neighbours
            int nRow = sr + delRow[i];
            int nCol = sc + delCol[i];

            if(nRow>=0 && nRow <row && nCol>=0 && nCol < col && !visited[nRow][nCol]
                    && image[nRow][nCol]==initColor && ans[nRow][nCol]!=newColor){  // image has initColor to replace and ans array is not having newColor in sr sc
                dfs(nRow,nCol,ans,image,initColor,newColor,visited,delRow,delCol);
            }
        }

    }

    public static void main(String[] args) {
        int m = 4, n=4;
        int g[][] = {{1,1,7, 5},{1, 3, 3, 3} ,{6, 5, 5, 3},{2, 2, 3, 3}};
        int sr = 1 , sc = 2 , newColor = 8;

        int[][] floodFill = floodFill(g, sr, sc, newColor);

        AssortedMethods.printMatrix(floodFill);
    }

}
