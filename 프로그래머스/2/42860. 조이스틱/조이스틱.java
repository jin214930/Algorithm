class Solution {
    public int solution(String name) {
        int ans = 0;
        int len = name.length();
        int move = name.length() - 1;
        
        for (int i = 0; i < len; i++) {
            ans += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            int idx = i + 1;
            while (idx < len && name.charAt(idx) == 'A') idx++;
            move = Math.min(move, Math.min(2 * i + len - idx, i + 2 * (len - idx)));
        }
        
        return ans + move;
    }
}