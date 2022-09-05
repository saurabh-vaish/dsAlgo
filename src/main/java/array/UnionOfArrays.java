package array;

import java.util.*;

/**
 * @Author saurabh vaish
 * @Date 25-08-2022
 */
public class UnionOfArrays {


    // program to find union of two sorted arrays
    // union must be in ascending order
    public static void main(String[] args) {

        int ar1[] = {1,2,3,4,5,7};
        int ar2[] = {2,3,4,4,5,6,8};

//        int ar1[] = {2,3,1,6,5,7};
//        int ar2[] = {1,2,3,7,4,4,2,8};

        System.out.println(Arrays.toString(usingSet(ar1,ar2)));
        System.out.println(Arrays.toString(usingMap(ar1,ar2)));

        System.out.println(Arrays.toString(usingTwoPointers(ar1,ar2)));


    }

    // only works when array are sorted
    // O(m+n)
    // space O(1) , if we ignore arraylist size
    static Integer[] usingTwoPointers(int ar1[],int ar2[]){
        int i=0,j=0;
        int m= ar1.length,n= ar2.length;
        List<Integer> list = new ArrayList<>();

        while (i<m && j<n){
            if (ar1[i]<=ar2[j]){
                if(!list.contains(ar1[i])){
                    list.add(ar1[i]);
                }
                i++;
            }else {
                if (!list.contains(ar2[j])) {
                    list.add(ar2[j]);
                }
                j++;
            }
        }

        while (i<m){
            if(!list.contains(ar1[i]))
            list.add(ar1[i]);
            i++;
        }
        while (j<n){
            if(!list.contains(ar2[j]))
            list.add(ar2[j]);
            j++;
        }

        return list.toArray(new Integer[0]);
    }

    // complexity == O( (m+n)log(m+n))  ,  m = ar1.length , n = ar2.length , as insertion in set is logN
    // space == O(max(m,n))
    static Integer [] usingSet(int []ar1,int [] ar2){
        Set<Integer> set = new HashSet<>();
        int l= Math.min(ar1.length, ar2.length);
        for (int i = 0; i < l; i++) {
            set.add(ar1[i]);
            set.add(ar2[i]);
        }
        int i=l;
        while (i<ar1.length){
            set.add(ar1[i++]);
        }
        int j=l;
        while (j<ar2.length){
            set.add(ar2[j++]);
        }
        return set.toArray(new Integer[0]);
    }

    // complexity == O( (m+n)log(m+n))  ,  m = ar1.length , n = ar2.length , as insertion in set is logN
    // space == O(max(m,n))
    static Integer [] usingMap(int []ar1,int [] ar2){
        Map<Integer,Integer> map = new HashMap<>();
        int l= Math.min(ar1.length, ar2.length);
        for (int i = 0; i < l; i++) {
            map.put(ar1[i],0);
            map.put(ar2[i],0);
        }
        int i=l;
        while (i<ar1.length){
            map.put(ar1[i++],0);
        }
        int j=l;
        while (j<ar2.length){
            map.put(ar2[j++],0);
        }
        return map.keySet().toArray(new Integer[0]);
    }

}
