package dpp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * https://www.codingninjas.com/studio/problems/longest-common-subsequence_624879
 *
 * @Author saurabh vaish
 * @Date 08-09-2023
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "adebc";
        String s2 = "dcadb";

        System.out.println(lcsUsingRecursion(s1,s2,s1.length()-1,s2.length()-1));

        // creating dp array for memoization
        int dp[][] = new int[s1.length()][s2.length()];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }

        System.out.println(lcsUsingRecursionWithDp(s1,s2,s1.length()-1,s2.length()-1,dp));

        System.out.println(lcsUsingDpTabulation(s1,s2));
    }

    // comp == O(2 ^ N) + O( 2 ^ M) , space = O(1)
    public static int lcsUsingRecursion(String s1,String s2,int ind1, int ind2) {

        if(ind1 <0 || ind2 < 0)return 0;

        if(s1.charAt(ind1)==s2.charAt(ind2)){ // chars matched
            return 1 + lcsUsingRecursion(s1,s2,ind1-1,ind2-1);
        }
        // chars not matched so reduce index

        return Math.max(lcsUsingRecursion(s1,s2,ind1-1,ind2)  // reduced first string index and matching with rest of s2
                , lcsUsingRecursion(s1,s2,ind1,ind2-1));  // reduced second string index and matching with rest of s1

    }

    // using memoization
    // comp = O( N * M) , space = O(N*M) + O(N + M)
    public static int lcsUsingRecursionWithDp(String s1,String s2,int ind1, int ind2,int dp[][]) {

        if(ind1 <0 || ind2 < 0)return 0;

        if(dp[ind1][ind2]!=-1)return dp[ind1][ind2];

        if(s1.charAt(ind1)==s2.charAt(ind2)){ // chars matched
            return dp[ind1][ind2]= 1 + lcsUsingRecursionWithDp(s1,s2,ind1-1,ind2-1,dp);
        }
        // chars not matched so reduce index

         dp[ind1][ind2] = Math.max(lcsUsingRecursionWithDp(s1,s2,ind1-1,ind2,dp)  // reduced first string index and matching with rest of s2
                , lcsUsingRecursionWithDp(s1,s2,ind1,ind2-1,dp));  // reduced second string index and matching with rest of s1

        return dp[ind1][ind2];
    }

    // using memoization
    // comp = O( N * M) , space =  O(N * M)
    public static int lcsUsingDpTabulation(String s1,String s2) {

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

        return dp[n][m];
    }


}
