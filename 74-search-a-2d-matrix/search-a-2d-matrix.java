class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[]arr : matrix){
            int n = arr.length;
            int left = 0;
            int right = n-1;
            while(left <= right){
                int mid = left + (right - left)/2;
                if(arr[mid] == target){
                    return true;
                }else if(arr[mid] > target){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
        }
        return false;
    }
}