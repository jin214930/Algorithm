import java.util.*;

class Solution {
    class Path {
        int y1, x1, y2, x2;
        Path(int y1, int x1, int y2, int x2) {
            this.y1 = y1;
            this.x1 = x1;
            this.y2 = y2;
            this.x2 = x2;
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Path path)) return false;
            
            return (y1 == path.y1 && x1 == path.x1 && y2 == path.y2 && x2 == path.x2)
                || (y1 == path.y2 && x1 == path.x2 && y2 == path.y1 && x2 == path.x1);
        }
        
        @Override
        public int hashCode() {
            int hash1 = Objects.hash(y1, x1);
            int hash2 = Objects.hash(y2, x2);
            return hash1 + hash2;
        }
    }
    
    public int solution(String dirs) {
        int y = 0, x = 0;
        Set<Path> set = new HashSet<>();
        for (char c : dirs.toCharArray()) {
            int ny = y, nx = x;
            if (c == 'U') {
                ny = y + 1;
            } else if (c == 'D') {
                ny = y - 1;
            } else if (c == 'R') {
                nx = x + 1;
            } else {
                nx = x - 1;
            }
            
            if (ny < -5 || ny > 5 || nx < -5 || nx > 5) continue;
            set.add(new Path(y, x, ny, nx));
            y = ny;
            x = nx;
        }
        
        return set.size();
    }
}