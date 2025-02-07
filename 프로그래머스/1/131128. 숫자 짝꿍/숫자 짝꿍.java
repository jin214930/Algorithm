import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] cntx = new int[10];
        int[] cnty = new int[10];
        
        for (char c : X.toCharArray())
            cntx[c - '0']++;
        for (char c : Y.toCharArray())
            cnty[c - '0']++;
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < Math.min(cntx[i], cnty[i]); j++)
                list.add(i);
        }
        
        if (list.isEmpty())
            return "-1";
        
        Collections.sort(list, Collections.reverseOrder());
        if (list.get(0) == 0)
            return "0";
        
        StringBuilder sb = new StringBuilder();
        for(int i : list)
            sb.append(i);
        return sb.toString();
    }
}