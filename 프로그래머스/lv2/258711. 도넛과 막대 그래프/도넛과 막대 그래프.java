import java.util.*;

class Solution {
    
    public int[] solution(int[][] edges) {
        int[] ans = new int[4];
        HashMap<Integer, Integer> in = new HashMap<>();
        HashMap<Integer, Integer> out = new HashMap<>();
        
        for (int[] i : edges) {
            if (out.containsKey(i[0])) 
                out.put(i[0], out.get(i[0]) + 1);
            else 
                out.put(i[0], 1);
            if (in.containsKey(i[1]))
                in.put(i[1], in.get(i[1]) + 1);
            else
                in.put(i[1], 1);
        }
        
        for (int i : out.keySet()) {
            if (out.get(i) >= 2) {
                if(!in.containsKey(i))
                    ans[0] = i;
                else
                    ans[3] += 1;
            }   
        }
        
        for(int i : in.keySet()) {
            if(!out.containsKey(i))
                ans[2] += 1;
        }
        
        ans[1] = out.get(ans[0]) - ans[2] - ans[3];
        return ans;
    }
}