class Solution {
    public void rotate(int[][] matrix) {
         int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int[] x: matrix){
            int st = 0;
            int end = n-1;
            while(st<end){
                int temp = x[st];
                x[st]=x[end];
                x[end]=temp;
                st++;
                end--;
            }
        }
    }
}