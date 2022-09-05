package array;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author saurabh vaish
 * @Date 25-08-2022
 */
public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int a[]={1,2,3,3,4,5,6,7};
        int b[]= {3,3,4,4,5,8};

        System.out.println(Arrays.toString(usingTwoPointersForSortedArrays(a,b)));

        System.out.println(Arrays.toString(usingSetForUnsortedArrays(a,b)));

        System.out.println(Arrays.toString(usingSetForUnsortedArraysOptimized(a,b)));
    }

    // O(min(m,n)) , O(1) if we ignore axulary space
    // using two pointers
    // we will take an empty array and match elements from second array to first
    // if elements matches then add it to this array
    static Integer[] usingTwoPointersForSortedArrays(int [] ar1,int [] ar2){
        int i=0,j=0;
        int m= ar1.length,n= ar2.length;
        List<Integer> list = new ArrayList<>();

        while (i<m && j<n){
            if(ar1[i]<ar2[j]){  // as first array elem is small than second then skip it increase first array index
                i++;
            }
            else if (ar1[i]>ar2[j]) { // as first element is greater than second then increase second array index
                j++;
            }else { // both elem are same
                list.add(ar2[j]);
                i++;
                j++;
            }
        }

        return list.toArray(new Integer[0]);
    }


    // @link == https://leetcode.com/problems/intersection-of-two-arrays
    // O(m+n+intersect.length)
    static int [] usingSetForUnsortedArrays(int [] ar1,int [] ar2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();

        for (int i = 0; i < ar1.length; i++) {
            set.add(ar1[i]); // adding all elements of first array
        }

        for (int i = 0; i < ar2.length; i++) {
            if (set.contains(ar2[i])) // if returns true means present
            {
                intersect.add(ar2[i]); // adding elements of second array who are present in set
            }
        }

        int [] ar = new int[intersect.size()];
        int i=0;
        for (Integer s:intersect) {
            ar[i++]=s;
        }
        return ar;
    }

    // O(m + n) , O(n) space
    static int [] usingSetForUnsortedArraysOptimized(int [] ar1,int [] ar2){
        int [] count = new int[1001]; // as 1000 is the upper bound
        int [] result = new int[1001]; // result array will store common elem

        for (int i = 0; i < ar1.length; i++) {
            count[ar1[i]]++;        // adding all elements of first array as index in count ar
        }

        int index=0; // creating index to count how many common elem are
        for (int i = 0; i < ar2.length; i++) {
            if (count[ar2[i]]!=0)       // taking element which are non-zero means elem from first array
            {
                result[index++]=ar2[i]; // adding elements of second array in result
                count[ar2[i]]=0;  // making that elem to zero to prevent duplicates
            }
        }

        return Arrays.copyOf(result,index); // creating new array from result
    }



}
