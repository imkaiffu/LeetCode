class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int m = image[0].length;

        for(int[] x:image ){
            int st=0;
            int end=m-1;
            while(st<=end){
                int temp = x[st];
                if(x[end] != 1){
                    x[st]=1;
                }else{
                    x[st]=0;
                }
                if(temp != 1){
                    x[end]=1;
                }else{
                    x[end]=0;
                }
                st++;
                end--;
            }
        }
        return image;
    }
}