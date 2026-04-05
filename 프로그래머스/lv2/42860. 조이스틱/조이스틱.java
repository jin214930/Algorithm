class Solution {
    public int solution(String name) {
        int ans = 0;
        int n = name.length();
        int move = name.length() - 1;
        
        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            ans += Math.min(c - 'A', 26 - c + 'A');
            int idx = i + 1;
            while (idx < n && name.charAt(idx) == 'A') idx++;
            move = Math.min(move, Math.min(2 * i + n - idx, i + 2 * (n - idx)));
        }
        
        return ans + move;
    }
}