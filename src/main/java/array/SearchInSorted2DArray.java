package array;

/**
 * @Author saurabh vaish
 * @Date 28-08-2022
 */
public class SearchInSorted2DArray {
    public static void main(String[] args) {

//        int [][] ar = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int [][] ar = {{1}};
        int k=2;

        System.out.println(search(ar,k));
    }

    // complexity == O(M + log(N))
    static boolean search(int [][]ar, int k){
        if(ar.length==0)return false;
        int row= ar.length;
        int col=ar[0].length;
        int start=0;
        int end= (row * col)-1;  // end index in row * col matrix

        while (start<=end){
            int mid=start+(end-start)/2;

            int midRowIndex = mid/col;  // row index of mid
            int midColIndex = mid%col;  // col index of mid;

            if(k==ar[midRowIndex][midColIndex])return true;
            else if(k<ar[midRowIndex][midColIndex])end=end-1;
            else start=mid+1;
        }
        return false;

//        for(int i=0;i<ar.length;i++){
//            for(int j=ar[0].length-1;j>=0;j--){
//                if(ar[i][j]==target) return true;
//                if(ar[i][j]<target) break;
//            }
//        }
//        return false;
    }
}
