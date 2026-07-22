class Solution {
    public boolean isHappy(int n) {
        HashSet <Integer> set = new HashSet<>();
        while(n != 1){
            if(!set.add(n)) return false;
            int sum = 0;
            while(n > 0){
                int r = n%10;
                sum += r*r;
                n /= 10;
            }
            n = sum;
        }
        return true;
    }
}