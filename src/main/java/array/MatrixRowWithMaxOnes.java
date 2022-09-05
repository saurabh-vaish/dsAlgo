package array;

/**
 * @Author saurabh vaish
 * @Date 04-09-2022
 */
public class MatrixRowWithMaxOnes {
    public static void main(String[] args) {

//        int [][] ar =  {{0, 1, 1, 1},{0, 0, 1, 1},{1, 1, 1, 1},{0, 0, 0, 0}};
        int [][] ar =  {{0,0},{0,1},{0,0},{0,0},{0, 1},{0, 1}};
//        int [][] ar =  {{0,0},{ 1, 1}};

        System.out.println(optimal(ar));
    }

    static int optimal(int [][]ar){
        int row = ar.length;
        int col = ar[0].length;
        int i=0;
        int j=col-1;
        int maxRow = -1;

        while (i<row && j>=0){
            if(ar[i][j]==1){
                j--;
                maxRow=i;
            }else { // if any 0 then change row
                i++;
            }
        }

        return maxRow;
    }
}
