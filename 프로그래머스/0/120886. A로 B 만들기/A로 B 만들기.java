class Solution {
    public int solution(String before, String after) {
        int[] cnt = new int[26];
        
        for (char c : before.toCharArray()) {
            cnt[c - 'a']++;
        }
        
        for (char c : after.toCharArray()) {
            if (cnt[c - 'a'] == 0)
                return 0;
            cnt[c - 'a']--;
        }
        
        return 1;
    }
}