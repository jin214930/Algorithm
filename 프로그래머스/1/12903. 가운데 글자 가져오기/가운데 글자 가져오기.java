class Solution {
    public String solution(String s) {
        String ans = "";
        if(s.length() % 2 == 0) 
            ans += s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        else
            ans += s.charAt(s.length() / 2);
        return ans;
    }
}