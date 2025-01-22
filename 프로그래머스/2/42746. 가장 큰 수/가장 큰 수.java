import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        
        for (int number : numbers)
            list.add(number + "");
        
        Collections.sort(list, (s1, s2) -> {
            String tmp1 = s1 + s2;
            String tmp2 = s2 + s1;
            return tmp2.compareTo(tmp1);
        });
        
        for (String s : list)
            sb.append(s);
        
        String ans = sb.toString();
        if (ans.startsWith("0"))
            ans = "0";
        
        return ans;
            
            
    }
}