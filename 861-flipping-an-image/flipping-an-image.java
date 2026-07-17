class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int m = image[0].length;
        int ans[][] = new int[n][m];
        int row = 0;
        
        for(int []x: image){
            int st = 0;
            int end = m-1;
            while(st<=end){
                int temp = x[st];
                x[st] = x[end];
                x[end] = temp;
                st++;
                end--;
            }
            for(int j=0; j<m; j++){
                ans[row][j]=x[j];
            }
            row++;
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(ans[i][j] != 1){
                    ans[i][j]=1;
                }else {
                    ans[i][j]=0;
                }
            }
        }
        return ans;
    }
}