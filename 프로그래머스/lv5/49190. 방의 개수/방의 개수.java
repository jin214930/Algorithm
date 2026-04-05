import java.util.*;

class Point {
    int y, x;
    
    public Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        Point p = (Point) o;
        return y == p.y && x == p.x;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(y, x);
    }
}

class Solution {
    int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    
    public int solution(int[] arrows) {
        int ans = 0;
        
        Point p = new Point(0, 0);
        HashSet<Point> set = new HashSet<>();
        HashMap<Point, HashSet<Point>> map = new HashMap<>();
        
        set.add(p);
        map.put(p, new HashSet<>());
        
        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Point np = new Point(p.y + dy[arrow], p.x + dx[arrow]);
                
                if (!set.contains(np)) {
                    set.add(np);
                    map.put(np, new HashSet<>());
                } else if (!map.get(p).contains(np)) 
                    ans++;
                
                map.get(p).add(np);
                map.get(np).add(p);
                
                p = np;
            }
        }
        
        return ans;
    }
}