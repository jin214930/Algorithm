class Solution {
    public int[] solution(int n, long left, long right) {
        int[] ans = new int[(int)(right - left + 1)];
        
        int idx = 0;
        long i = left;
        while (i <= right) {
            int a = (int)(i / n);
            int b = (int)(i % n);
            if (b < a)
                b = a;
            ans[idx++] = b + 1;
            i++;
        }
        
        return ans;
    }
}