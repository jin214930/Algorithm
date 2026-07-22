class Solution {
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        String[] tmp = s.split("0");
        int ans = 0;
        for (String t : tmp) {
            if (t.length() > 0) {
                long x = Long.parseLong(t);
                if (isPrime(x)) ans++;
            }
        }
        
        return ans;
    }
    
    boolean isPrime(long x) {
        if (x == 1) return false;
        for (long i = 2; i * i <= x; i++) {
            if (x % i == 0) return false;
        }
        return true;
    }
}