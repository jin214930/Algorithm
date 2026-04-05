import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        List<int[]> list = new ArrayList<>();
        
        for (int[] i : data) {
            if (i[map.get(ext)] < val_ext)
                list.add(i);
        }
        
        Collections.sort(list, (o1, o2) -> o1[map.get(sort_by)] - o2[map.get(sort_by)]);
        
        int[][] ans = new int[list.size()][];
        int idx = 0;
        for (int[] i : list)
            ans[idx++] = i;
        
        return ans;
    }
}