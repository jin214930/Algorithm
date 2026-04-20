class Solution {
    public long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            long x = numbers[i];
            
            if (x % 2 == 0) {
                ans[i] = x + 1;
            } else {
                long bit = 1;
                
                while ((x & bit) != 0) {
                    bit <<= 1;
                }
                
                ans[i] = (x | bit) & ~(bit >> 1);
            }
        }
        
        return ans;
    }
}