import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        Queue<String> q = new LinkedList<>();
        int ans = 0;
        
        if (cacheSize == 0)
            return cities.length * 5;
        
        for (String city : cities) {
            city = city.toLowerCase();
            if (q.contains(city)) {
                q.remove(city);
                q.add(city);
                ans += 1;
            } else {
                if (q.size() == cacheSize) 
                    q.poll();
                q.add(city); 
                ans += 5;
            }
        }
        
        return ans;        
    }
}