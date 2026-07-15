class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumOdd = 0;
        int sumEven = 0;
        for(int i=0; i<=n*2; i++){
            if(i % 2 != 0){
                sumOdd += i;
            }else{
                sumEven += i;
            }
        }
        int GCD = 0;
        for(int i=1; i<=sumOdd; i++){
            if(sumOdd % i == 0 && sumEven % i == 0){
                GCD = i;
            }
        }
        return GCD;
    }
}