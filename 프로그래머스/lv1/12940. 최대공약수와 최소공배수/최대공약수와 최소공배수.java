class Solution {
    static long gcd(long a, long b) {
        if(b == 0)
            return a;
        return gcd(b, a % b);
    }
    public int[] solution(int n, int m) {
        long a = n;
        long b = m;
        long g;
        if(a > b)
            g = gcd(a, b);
        else
            g = gcd(b, a);
        long l = a * b / g;
        int[] ans = {(int)g, (int)l};
        return ans;
        
    }
}