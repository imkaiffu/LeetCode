class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int temp = n;
        while(n > 0){
            int digit = n % 10;
            sum = digit+sum;
            pro = pro*digit;
            n/=10;
        }
        int sum1 = sum+pro;
        if(temp % sum1 != 0){
            return false;
        }else{
            return true;
        }
    }
}