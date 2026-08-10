class Solution {
    public String mergeAlternately(String word1, String word2) {
        String ans = "";
        int m = word1.length();
        int n = word2.length();
        for(int i=0; i<n && i<m; i++){
            ans += word1.charAt(i);
            ans += word2.charAt(i);
        }
        if(m<n){
            ans += word2.substring(m,n);
        }else{
            ans += word1.substring(n,m);
        }
        return ans;
    }
}