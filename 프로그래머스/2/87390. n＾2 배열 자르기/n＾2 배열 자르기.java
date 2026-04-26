class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ans = new int[(int)(right - left + 1)];

        for (long i = left; i <= right; i++) {
            long y = i / n;
            long x = i % n;
            ans[(int)(i - left)] = (int)(Math.max(y, x) + 1);
        }
        
        return ans;
    }
}