class Solution {
    int cnt = 0, ans = 0;
    char[] vowel = {'A', 'E', 'I', 'O', 'U'};
    void go(String s, int depth, String word) {
        if (!s.equals("")) {
            cnt++;
            if(s.equals(word))
                ans = cnt;
        }
        if (depth == 5)
            return;
        for (int i = 0; i < 5;i++)
            go(s + vowel[i], depth + 1, word);
    }
    
    public int solution(String word) {
        go("", 0, word);
        return ans;
    }
}