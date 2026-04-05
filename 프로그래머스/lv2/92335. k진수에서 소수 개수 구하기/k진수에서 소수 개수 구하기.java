class Solution {
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        String[] a = s.split("0");
        int ans = 0;
        for (String t : a) {
            if (t.length() != 0 && isPrime(t))
                ans++;
        }
        
        return ans;
    }
    
    public boolean isPrime(String s) {
        long x = Long.parseLong(s);
        if (x == 1) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0)
                return false;
        }
        
        return true;
    }
}