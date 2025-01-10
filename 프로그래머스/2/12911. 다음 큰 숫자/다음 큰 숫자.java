class Solution {
    public int go(int n) {
        int cnt = 0;
        for(char c : Integer.toBinaryString(n).toCharArray()) {
            if(c == '1')
                cnt++;
        }
        return cnt;
    }
    public int solution(int n) {
        int cnt = go(n);
        
        while(true) {
            n++;
            if (go(n) == cnt)
                return n;
            
        }
        
        
    }
}