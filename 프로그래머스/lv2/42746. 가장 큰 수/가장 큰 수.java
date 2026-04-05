import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        for (int i : numbers)
            list.add(i + "");
        
        Collections.sort(list, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        if (list.get(0).equals("0"))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(s);
        
        return sb.toString();
    }
}