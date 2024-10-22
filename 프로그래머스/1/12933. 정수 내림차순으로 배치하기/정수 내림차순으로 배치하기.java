class Solution {
    public long solution(long n) {
        int[] cnt = new int[10];
        while(n != 0) {
            cnt[(int)(n % 10)]++;
            n /= 10;
        }
        long ans = 0;
        for(int i = 9; i >= 0; i--) {
            for(int j = 0; j < cnt[i];j++) {
                ans = ans * 10 + i;
            }
        }
        return ans;
    }
}