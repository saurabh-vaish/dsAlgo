package array;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author saurabh vaish
 * @Date 09-08-2022
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1 [] = new int[]{1, 3, 4, 5};
        int arr2 [] = new int[]{2, 6, 7, 8};

        int res[] =mergeArrays(arr1,arr2);
        System.out.println(Arrays.toString(res));

        System.out.println(Arrays.toString(mergeArraysUsingMap(arr1,arr2)));
    }

//    using two pointers
    // complexity - O(l1+l2) (both)
    public static int[] mergeArrays(int[] arr1, int[] arr2)
    {
        // write your code here
        int res[] = new int[arr1.length+arr2.length];
        int l1 = arr1.length;
        int l2=arr2.length;
        int l = l1>l2?l2:l1;
        int i=0,j=0,k=0;
        while(i<l1 && j<l2){
            if(arr1[i]<arr2[j]){
                res[k++]=arr1[i++];
            }else{
                res[k++]=arr2[j++];
            }
        }

        while(i<l1){
            res[k++]=arr1[i++];
        }
        while(j<l2){
            res[k++]=arr2[j++];
        }

        return res; // make a new resultant array and return your results in that
    }


    // (O(nlog(n) + mlog(m)) Time and O(N) Extra Space)
    static int[] mergeArraysUsingMap(int a[], int b[])
    {
        int res[] = new int[a.length+b.length];
        // Declaring a map.
        // using map as a inbuilt tool
        // to store elements in sorted order.
        Map<Integer,Boolean> mp = new TreeMap<Integer,Boolean>();

        // Inserting values to a map.
        for(int i = 0; i < a.length; i++)
        {
            mp.put(a[i], true);
        }
        for(int i = 0;i < b.length;i++)
        {
            mp.put(b[i], true);
        }

        int i=0;
        for(Integer s:mp.keySet()){
            res[i++]=s;
        }
        return res;
    }
}
