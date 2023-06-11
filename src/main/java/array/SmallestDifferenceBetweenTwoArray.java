package array;

import java.util.Arrays;

/**
 * @Author saurabh vaish
 * @Date 07-09-2022
 */
public class SmallestDifferenceBetweenTwoArray {

    public static void main(String[] args) {
        int [] ar1 = {3,6,7,4};

        int [] ar2 = {2,8,9,3};

        System.out.println(smallestDifference(ar1,ar2));

        System.out.println(Arrays.toString(smallestDifferencePair(ar1,ar2)));
    }


    // O(longN) + O(logM) + O(n*logN) === O(n * logN)
    static int [] smallestDifferencePair(int [] ar1,int [] ar2){

        if (ar1.length==0 && ar2.length==0)return new int[]{};
        if (ar1.length==1 && ar2.length==1)return new int[]{ar1[0],ar2[0]};

        // first sort both arrays
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        int smallest=Integer.MAX_VALUE;
        int[] ar = new int[2];

        int i=0; int j=0;

        while (i<ar1.length && j<ar2.length){
            // current array index diff of element
            int current = Math.abs(ar1[i]-ar2[j]);

            // if its lesser then replace with smallest and update pair
            if(current<smallest){
                smallest=current;
                ar[0]=ar1[i];
                ar[1]=ar2[j];
            }

            if (ar1[i]==ar2[j])return new int[]{ar1[i],ar2[j]};
            else if (ar1[i]<ar2[j]) {
                i++;
            }else {
                j++;
            }
        }

        return ar;
    }


    // O(longN) + O(logM) + O(n*logN) === O(n * logN)
    static int smallestDifference(int [] ar1,int [] ar2){

        if (ar1.length==0 && ar2.length==0)return 0;
        if (ar1.length==1 && ar2.length==1)return Math.abs(ar1[0]-ar2[0]);

        // first sort both arrays
        Arrays.sort(ar1);
        Arrays.sort(ar2);

        int min=Integer.MAX_VALUE;

        int i=0; int j=0;

        /// iterate array
        while (i<ar1.length && j<ar2.length){

            // find min between diff of element and min
            min = Math.min(Math.abs(ar1[i]-ar2[j]),min);

            //since array are sorted . if first array value is less means we need to increase first array index , else second array index
            // if equal return 0

            if(ar1[i]==ar2[j])return 0;
            else if (ar1[i]<ar2[j]) {
                i++;
            }else {
                j++;
            }
        }

        return min;
    }
}
