import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        
        for (int n : numbers) 
            list.add(n + "");
        
        Collections.sort(list, (s1, s2) -> {
            String tmp1 = s1 + s2;
            String tmp2 = s2 + s1;
            return tmp2.compareTo(tmp1);
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s);
        
        String ans = sb.toString();
        if (ans.startsWith("0"))
            return "0";
        return ans;
            
            
    }
}