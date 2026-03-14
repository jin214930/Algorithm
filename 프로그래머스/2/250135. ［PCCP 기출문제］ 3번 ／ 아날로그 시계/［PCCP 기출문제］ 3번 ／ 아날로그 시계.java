class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int ans = 0;
        
        int st = h1 * 3600 + m1 * 60 + s1;
        int et = h2 * 3600 + m2 * 60 + s2;
        
        int max = 43200;
        
        int h0 = st % max;
        int m0 = (st * 12) % max;
        int s0 = (st * 720) % max;
        
        if (s0 == m0 || s0 == h0)
            ans++;
        
        for (int t = st; t < et; t++) {
            int _h1 = t % max;
            int _m1 = (t * 12) % max;
            int _s1 = (t * 720) % max;
            
            int _h2 = (t + 1) % max;
            int _m2 = ((t + 1) * 12) % max;
            int _s2 = ((t + 1) * 720) % max;
            
            if (_h2 == 0) _h2 = max;
            if (_m2 == 0) _m2 = max;
            if (_s2 == 0) _s2 = max;
            
            boolean hMatch = false;
            boolean mMatch = false;
            
            if (_s1 < _h1 && _s2 >= _h2) hMatch = true;
            if (_s1 < _m1 && _s2 >= _m2) mMatch = true;
            
            if (hMatch && mMatch) {
                if (_h2 == _m2)
                    ans++;
                else
                    ans += 2;
            } else if (hMatch || mMatch)
                ans++;
        }
        
        return ans;
    }
}