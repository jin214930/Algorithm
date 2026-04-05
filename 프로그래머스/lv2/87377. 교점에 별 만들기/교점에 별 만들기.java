import java.util.*;

class Solution {
    class Point {
        long x, y;
        
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    List<Point> list = new ArrayList<>();
    
    public String[] solution(int[][] line) {
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++)
                getPoint(line[i], line[j]);
        }
        
        long minX = Long.MAX_VALUE, minY = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE, maxY = Long.MIN_VALUE;
        
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
            int y = (int) (maxY - p.y);
            int x = (int) (p.x - minX);
            map[y][x] = '*';
        }
        
        String[] ans = new String[h];
        for (int i = 0; i < h; i++)
            ans[i] = new String(map[i]);
        
        return ans;
    }
    
    void getPoint(int[] l1, int[] l2) {
        long a1 = l1[0], b1 = l1[1], c1 = l1[2];
        long a2 = l2[0], b2 = l2[1], c2 = l2[2];
        
        long denom = a2 * b1 - a1 * b2;
        if(denom == 0) return;
        
        long numX = b1 * c2 - b2 * c1;
        long numY = a1 * c2 - a2 * c1;

        if (numX % denom == 0 && numY % denom == 0)
            list.add(new Point(numX / -denom, numY / denom));
    }
}