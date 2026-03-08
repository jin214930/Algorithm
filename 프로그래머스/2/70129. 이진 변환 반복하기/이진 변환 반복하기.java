class Solution {
    String toBinary(int n) {
        StringBuilder sb = new StringBuilder();
        
        while(n != 0) {
            sb.insert(0, n % 2);
            n /= 2;
        }
        
        return sb.toString();
    }
    
    public int[] solution(String s) {
        int[] ans = new int[2];
        
        while(!s.equals("1")) {
            int len = s.length();
            int cnt = 0;
            for (char c : s.toCharArray()) {
                if (c == '0')
                    cnt++;
            }
            
            ans[0]++;
            ans[1] += cnt;
            
            s = toBinary(s.length() - cnt);
        }
        
        return ans;
    }
}