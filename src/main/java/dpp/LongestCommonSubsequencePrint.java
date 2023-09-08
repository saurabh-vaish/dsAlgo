package dpp;

import java.util.Arrays;

/**
 * https://www.codingninjas.com/studio/problems/longest-common-subsequence_624879
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class LongestCommonSubsequencePrint {

    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";

        System.out.println(lcsUsingDpTabulationPrint(s1,s2));
    }



    // using memoization
    // comp = O( N * M) , space =  O(N * M)
    public static String lcsUsingDpTabulationPrint(String s1,String s2) {

        // creating dp array for memoization
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n +1][m +1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        // initialize first row , col to 0
        for(int i=0;i<=n;i++){
            dp[i][0] = 0;
        }
        for(int i=0;i<=m;i++){
            dp[0][i] = 0;
        }


        for(int ind1 = 1; ind1<= n; ind1++){

            for (int ind2 = 1; ind2 <= m; ind2++) {

                if(s1.charAt(ind1-1)==s2.charAt(ind2-1)){
                    dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
                }else{
                    dp[ind1][ind2] = Math.max(dp[ind1 - 1][ind2], dp[ind1][ind2 - 1]);
                }
            }
        }


        int len = dp[n][m];

        int i=n;
        int j=m;

        int index = len-1;


        StringBuilder str1 = new StringBuilder(s1);
        StringBuilder str2 = new StringBuilder(""); // dummay string

        for(int k=0;k<len;k++)str2.append("$");

        while (i>0 && j>0){
            if(str1.charAt(i-1)==s2.charAt(j-1)){
                str2.setCharAt(index,str1.charAt(i-1));
                index--;
                i--;
                j--;
            } else if (str1.charAt(i-1)>s2.charAt(j-1)) {
                i--;
            }else {
                j--;
            }
        }

        return str2.toString();

    }


}
