import java.util.*;

class Solution {
    public int solution(String dirs) {
        int y = 0;
        int x = 0;
        
        Set<Path> set = new HashSet<>();
        for (char c : dirs.toCharArray()) {
            int ny = y;
            int nx = x;
            if (c == 'U') {
                ny += 1;
            } else if (c == 'D') {
                ny -= 1;
            } else if (c == 'L') {
                nx -= 1;
            } else if (c == 'R') {
                nx += 1;
            }
            
            if (ny < -5 || ny > 5 || nx < -5 || nx > 5) continue;
            
            set.add(new Path(y, x, ny, nx));
            y = ny;
            x = nx;
        }
        
        return set.size();
    }
    
    class Path {
        int sy, sx, ey, ex;
        
        public Path(int y1, int x1, int y2, int x2) {
            if (y1 < y2 || (y1 == y2 && x1 < x2)) {
                sy = y1;
                sx = x1;
                ey = y2;
                ex = x2;
            } else {
                sy = y2;
                sx = x2;
                ey = y1;
                ex = x1;
            }
        }
        
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Path path = (Path) o;
            return sy == path.sy && sx == path.sx && ey == path.ey && ex == path.ex;
        }

        @Override
        public int hashCode() {
            return Objects.hash(sy, sx, ey, ex);
        }
    }
}