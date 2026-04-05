import java.util.*;
class Solution {
    public String solution(String s) {
        String[] a = new String[s.length()];
        for(int i = 0 ;i < s.length();i++)
            a[i] = "" + s.charAt(i);
        Arrays.sort(a, Collections.reverseOrder());
        String ans = "";
        for(String i : a)
            ans += i;
        return ans;
    }
}