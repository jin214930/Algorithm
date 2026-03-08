class Solution {    
    public int solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            sb.append(n % 3);
            n /= 3;
        }
        
        String s = sb.toString();
        int tmp = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            ans += tmp * (s.charAt(i) - '0');
            tmp *= 3;
        }
        
        return ans;
    }
}