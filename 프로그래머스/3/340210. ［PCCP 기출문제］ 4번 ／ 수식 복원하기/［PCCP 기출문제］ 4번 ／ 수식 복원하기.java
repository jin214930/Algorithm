import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        List<String> known = new ArrayList<>();
        List<String> unknown = new ArrayList<>();
        
        int max = 0;
        for (String s : expressions) {
            boolean flag = true;
            for (char c : s.toCharArray()) {
                if (c >= '0' && c <= '9')
                    max = Math.max(max, c - '0');
                if (c == 'X')
                    flag = false;
            }
            
            if (flag) known.add(s);
            else unknown.add(s);
        }
        
        List<Integer> bases = new ArrayList<>();
        for (int i = max + 1; i <= 9; i++) {
            boolean flag = true;
            for (String s : known) {
                if (!check(s, i)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                bases.add(i);
        }
        
        String[] ans = new String[unknown.size()];
        int idx = 0;
        for (String s : unknown)
            ans[idx++] = cal(s, bases);
        
        return ans;
    }
    
    boolean check(String s, int base) {
        String[] tmp = s.split(" ");
        int a = Integer.parseInt(tmp[0], base);
        int b = Integer.parseInt(tmp[2], base);
        int c = Integer.parseInt(tmp[4], base);
        
        if (tmp[1].equals("+"))
            return a + b == c;
        else
            return a - b == c;
    }
    
    String cal(String s, List<Integer> bases) {
        String[] tmp = s.split(" ");
        String op = tmp[1];
        
        Set<String> set = new HashSet<>();
        for (int base : bases) {
            int a = Integer.parseInt(tmp[0], base);
            int b = Integer.parseInt(tmp[2], base);
            
            int ret = op.equals("+") ? a + b : a - b;
            set.add(Integer.toString(ret, base));
        }
        
        String finalResult = set.size() == 1 ? set.iterator().next() : "?";
        
        return s.substring(0, s.length() - 1) + finalResult;
    }
}