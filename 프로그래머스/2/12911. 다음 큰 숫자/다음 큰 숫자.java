class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') {
                cnt++;
            }
        }
        
        int ans = n + 1;
        while(true) {
            int cnt2 = 0;
            for (char c : Integer.toBinaryString(ans).toCharArray()) {
                if (c == '1') {
                    cnt2++;
                }
            }
            
            if (cnt == cnt2) {
                break;
            }
            
            ans++;
        }
        
        return ans;
    }
}