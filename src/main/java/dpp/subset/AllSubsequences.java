package dpp.subset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author saurabh vaish
 * @Date 29-05-2022
 */
public class AllSubsequences { // not working

    public static void main(String[] args) {
        int [] ar = new int[]{0,1,3,2,4};

        List<List<Integer>> list = new ArrayList<>();

        getAllSubsequencesMemoization(0,ar,new ArrayList<>(),list,new HashMap<>());

        list.forEach(l-> System.out.println(l));
    }

    // Time - O(2*n) , space- O(n)
    private static void getAllSubsequencesMemoization(int i, int[] ar, List<Integer>temp, List<List<Integer>> list, Map<String,List<Integer>>dp) {
        // base case
        if (i== ar.length){
            list.add(new ArrayList<>(temp));
            return;
        }

        String k=i+""+temp;
        if(dp.containsKey(k))
            list.add(new ArrayList<>(dp.get(k)));
        // taking that element
        temp.add(ar[i]);
        getAllSubsequencesMemoization(i+1,ar,temp,list,dp);

        dp.put(k,temp);
        // not taking that element
        temp.remove(temp.size()-1);
        getAllSubsequencesMemoization(i+1,ar,temp,list,dp);
    }

//    private static void getAllSubsequencesTabulation(int[] ar){
//        int [][] dp = new int[ar.length+1][];
//        List<List<Integer>> list = new ArrayList<>();
//
//        list.add(new ArrayList<>(ar[ar.length-1]));
//
//        dp[ar.length]=new int[ar.length];
//
//        for (int i = ar.length; i >=0; i--) {
//            int[] temp = dp[ar.length];
//            temp[i]=ar[i];
//            List<Integer> list1 = new ArrayList<>();
//            for (int j = 0; j < temp.length; j++) {
//                temp.add(ar[i]);
//                getAllSubsequencesMemoization(i+1,ar,temp,list,dp);
//
//                dp.put(k,temp);
//                // not taking that element
//                temp.remove(temp.size()-1);
//                getAllSubsequencesMemoization(i+1,ar,temp,list,dp);
//            }
//            list.add(list1);
//        }
//    }

}
