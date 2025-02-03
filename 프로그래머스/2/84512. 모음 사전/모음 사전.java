class Solution {
    char[] vow = {'A', 'E', 'I', 'O', 'U'};
    int ans;
    boolean flag;
    
    void go(int idx, String s, String word) {
        if (s.equals(word)) {
            flag = true;
            return;
        }
        if (s.length() == 5)
            return;
        
        for (int i = idx; i < 5; i++) {
            if (flag)
            return;
            ans++;
            go(idx, s + vow[i], word);
        }
    }

    public int solution(String word) {
        go(0, "", word);
        
        return ans;
    }
}