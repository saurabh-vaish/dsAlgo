package array;

/**
 * @Author saurabh vaish
 * @Date 18-08-2022
 */
public class DiagonalSumDiff {

    public static void main(String[] args) {

        int [][] ar = {{1,2,3},{4,5,6},{9,8,9}};

        System.out.println("difference in sum === "+sumDiff(ar));

        System.out.println("difference in sum === "+sumDiffOptimized(ar));
    }

    // O(N)
    private static int sumDiffOptimized(int [][] ar){
        int s1=0;
        int s2=0;
        for (int i = 0; i < ar.length; i++) {
            s1+=ar[i][i];
            s2+=ar[i][ar.length-i-1];
        }
        return Math.abs(s1-s2);
    }


    // O(n*n) , O(1)
    private static int sumDiff(int [][] ar){
        int s1=0;
        int s2=0;
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < ar[0].length; j++) {
                if(i==j){
                    s1+=ar[i][j];
                }
                if(i+j==(ar.length-1)) {
                    s2 += ar[i][j];
                }
            }
        }
        return Math.abs(s1-s2);
    }

}
