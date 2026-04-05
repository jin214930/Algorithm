class Solution {
    public int[] solution(String s) {
        int[] tmp = new int[26];
        for(int i = 0; i < 26; i++)
            tmp[i] = -1;
        
        int[] ans = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (tmp[c - 'a'] == -1)
                ans[i] = -1;
            else
                ans[i] = i - tmp[c - 'a'];
            tmp[c - 'a'] = i;
        }
        
        return ans;
    }
}