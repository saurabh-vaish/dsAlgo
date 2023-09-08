package binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Link = https://www.codingninjas.com/studio/problems/allocate-books_1090540
 *  In an array ar with consists ar[i] pages of books and there are m students . Allocate all the books in such a way that -
 *  Each student gets at-least one book
 *  Each book should be allocated to only one student.
 *  Book allocation should be in contiguous manner .
 *
 *  Have to allocate the books to m student such that maximum no of pages assigned to student is minimum
 *
 * @Author saurabh vaish
 * @Date 08-07-2023
 */
public class AllocateBooks {


    // we have to allocate books like that the all the students gets book
    // and all the possibilities will allocate the minimum no of pages
    static int allocateBrute(int [] ar,int m){
        if(m>ar.length)return -1;

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for(int a:ar){
            min = Math.min(min,a);
            sum +=a;
        }

        for(int i=min;i<sum;i++){
            int countStu = maxAllocation(ar,i);
            if(countStu==m)return i;
        }

        return -1;
    }

    private static int maxAllocation(int[] ar, int m) {
        int stu=1; long pages = 0;

        // will start allocating books in array and will check how many contiguous books we can give to one student
        for(int i=0;i<ar.length;i++){
            long total = pages + ar[i];

            if(total<=m){  // total is less than allowed , keep adding
                pages = pages+ ar[i];
            }else{
                stu++;  // after allocation of one slot increase student
                pages = ar[i];
            }
            if(pages>m)break;

        }

        return stu;
    }

    private static boolean maxAllocation(ArrayList<Integer> ar, int pages,int students) {
        int stu=0; long sum = 0;

        // will start allocating books in array and will check how many contiguous books we can give to one student
        for(int i=0;i<ar.size();i++){
            long total = sum + ar.get(i);

            if(total<=pages){  // total is less than allowed , keep adding
                sum = sum+ ar.get(i);
            }else{
                stu++;  // after allocation of one slot increase student
                sum = ar.get(i);
                if(sum>pages)return false; // if total pages are greater than apprxed then not possible further
            }
        }

        if (stu < students) return true;
        return false;
    }



    static int findPages(ArrayList<Integer> ar, int n, int m) {
        // Write your code here.
        if(m>ar.size())return -1;

        int min = Integer.MAX_VALUE;
        int sum = 0;

        // get min pages and total pages
        for(int a:ar){
            min = Math.min(min,a);
            sum +=a;
        }

        int low = min;
        int high = sum;

        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;

            // check on each approx pages how many students can get books
            boolean possible = maxAllocation(ar,mid,m);
            if(possible){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;    // no of students are more so increase pages
            }

        }
        return ans;

    }


    public static void main(String[] args) {
//        int [] ar = {12,34,67,90};
        int [] ar = {1,17,14,9,15,9,14};

        int m =7;

        System.out.println(allocateBrute(ar,m));

        ArrayList<Integer> list = new ArrayList<>();
        for(int a:ar){
            list.add(a);
        }

        System.out.println(findPages(list,list.size(),m));
    }


}
