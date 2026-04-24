import java.util.*;

class Solution {
    public int solution(int[] elements) {
        List<Integer> list = new ArrayList<>();
        int n = elements.length;
        for (int i = 0; i < n; i++) {
            list.add(elements[i]);
        }
        for (int i = 0; i < n - 1; i++) {
            list.add(elements[i]);
        }
        
        Set<Integer> set = new HashSet<>();
        
        for (int i = 0; i <= list.size() - n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += list.get(i + j);
                set.add(sum);
            }
        }
        
        return set.size();
        
    }
}