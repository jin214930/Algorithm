import java.util.*;

class Solution {
    public boolean solution(String[] a) {
        Arrays.sort(a);
        for(int i = 0; i < a.length - 1;i++) {
            if(a[i].length() <= a[i+1].length() && a[i+1].substring(0, a[i].length()).equals(a[i]))
                return false;
            if(a[i+1].length() <= a[i].length() && a[i].substring(0, a[i+1].length()).equals(a[i + 1]))
                return false;
        }
        return true;
    }
}