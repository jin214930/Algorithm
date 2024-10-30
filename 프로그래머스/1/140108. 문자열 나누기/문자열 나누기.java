class Solution {
    public int solution(String s) {
        int ans = 0;
        int cntx = 0, cntnx = 0;
        char x = '0';
        for(int i = 0; i < s.length();i++) {
            if(x == '0')
                x = s.charAt(i);
            if(s.charAt(i) == x) 
                cntx++;
            else 
                cntnx++;
            if (cntx == cntnx) {
                ans++;
                cntx = 0;
                cntnx = 0;
                x = '0';
            }
        }
        if(cntx != 0 || cntnx != 0)
            ans++;
        return ans;        
    }
}