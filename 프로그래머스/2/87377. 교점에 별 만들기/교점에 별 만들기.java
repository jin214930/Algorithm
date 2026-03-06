/*
1. 모든 직선의 교점을 담는다.
2. 교점 중 x, y의 최대 최소를 구함
3. result로 표현
*/

import java.util.*;

class Solution {
    class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    Point get(int[] l1, int[] l2) {
        long a1 = l1[0], b1 = l1[1], c1 = l1[2];
        long a2 = l2[0], b2 = l2[1], c2 = l2[2];
        
        long denom = a2 * b1 - a1 * b2;
        
        if (denom == 0)
            return null;
        
        long xNum = b1 * c2 - b2 * c1;
        long yNum = a1 * c2 - a2 * c1;
        
        if (xNum % denom != 0 || yNum % denom != 0)
            return null;
        
        return new Point(xNum / -denom, yNum / denom);
    }
    
    public String[] solution(int[][] line) {
        int n = line.length;
        
        List<Point> list = new ArrayList<>();
        
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                Point p = get(line[i], line[j]);
                if (p != null)
                    list.add(p);
            }
        }
        
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        
        for (Point p : list) {
            minX = Math.min(minX, p.x);
            maxX = Math.max(maxX, p.x);
            minY = Math.min(minY, p.y);
            maxY = Math.max(maxY, p.y);
        }
        
        int w = (int) (maxX - minX + 1);
        int h = (int) (maxY - minY + 1);
        
        char[][] map = new char[h][w];
        for (int i = 0; i < h; i++)
            Arrays.fill(map[i], '.');
        
        for (Point p : list) {
            int x = (int) (p.x - minX);
            int y = (int) (maxY - p.y);
            map[y][x] = '*';
        }
        
        String[] ans = new String[h];
        for (int i = 0; i < h; i++)
            ans[i] = new String(map[i]);
        
        return ans;
        
    }
}