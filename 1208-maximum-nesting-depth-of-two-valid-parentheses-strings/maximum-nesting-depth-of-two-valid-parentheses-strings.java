class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                answer[i] = i % 2;
            } else {
                answer[i] = (i + 1) % 2;
            }
        }
        return answer;
    }
}