class Solution {
    public String solution(String s, String skip, int index) {
        boolean[] alpha = new boolean[26];
        StringBuilder sb = new StringBuilder();
        
        for (char c : skip.toCharArray()) 
            alpha[c - 'a'] = true;
        
        for (char c : s.toCharArray()) {
            int tmp = index;
            
            while(tmp > 0) {
                c++;
                if (c > 'z')
                    c -= 26;
                if (alpha[c - 'a'])
                    continue;
                tmp--;
                
            }
            sb.append(c);
        }
        
        return sb.toString();
    }
}