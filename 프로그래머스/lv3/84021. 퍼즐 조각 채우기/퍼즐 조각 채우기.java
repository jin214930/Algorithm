import java.util.*;

class Point {
    int y, x;
    
    Point(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Solution {
    int n;
    int[] dy = {0, 0, -1, 1};
    int[] dx = {1, -1, 0, 0};
    
    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;
        
        List<List<Point>> empties = get(game_board, 0);
        List<List<Point>> pieces = get(table, 1);
        
        boolean[] used = new boolean[pieces.size()];
        int ans = 0;
        
        for (List<Point> empty : empties) {
            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                
                List<Point> piece = pieces.get(i);
                
                if (empty.size() != piece.size()) continue;
                
                if (isMatch(empty, piece)) {
                    used[i] = true;
                    ans += piece.size();
                    break;
                }
            }
        }
        
        return ans;
    }
    
    List<List<Point>> get(int[][] board, int target) {
        List<List<Point>> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == target && !visited[i][j]) {
                    List<Point> shape = new ArrayList<>();
                    Queue<Point> q = new LinkedList<>();
                    
                    q.add(new Point(i, j));
                    visited[i][j] = true;

                    while (!q.isEmpty()) {
                        Point p = q.poll();
                        shape.add(p);
                        
                        for (int d = 0; d < 4; d++) {
                            int ny = p.y + dy[d];
                            int nx = p.x + dx[d];
                            
                            if (ny >= 0 && nx >= 0 && ny < n && nx < n) {
                                if (board[ny][nx] == target && !visited[ny][nx]) {
                                    visited[ny][nx] = true;
                                    q.add(new Point(ny, nx));
                                }
                            }
                        }
                    }
    
                    res.add(normalize(shape));
                }
            }
        }
        return res;
    }

    List<Point> normalize(List<Point> shape) {
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        
        for (Point p : shape) {
            minY = Math.min(minY, p.y);
            minX = Math.min(minX, p.x);
        }
        
        List<Point> res = new ArrayList<>();
        for (Point p : shape) {
            res.add(new Point(p.y - minY, p.x - minX));
        }
        
        Collections.sort(res, (p1, p2) -> {
            if (p1.y == p2.y)
                return p1.x - p2.x;
            return p1.y - p2.y;
        });
        return res;
    }

    List<Point> rotate(List<Point> shape) {
        List<Point> res = new ArrayList<>();
        for (Point p : shape) {
            res.add(new Point(p.x, -p.y));
        }
        return normalize(res);
    }

    boolean isMatch(List<Point> empty, List<Point> piece) {
        List<Point> curr = piece;
        
        for (int i = 0; i < 4; i++) {
            boolean match = true;
            for (int j = 0; j < empty.size(); j++) {
                Point tmp1 = empty.get(j);
                Point tmp2 = curr.get(j);
                if (!(tmp1.y == tmp2.y && tmp1.x == tmp2.x)) {
                    match = false;
                    break;
                }
            }
            if (match) return true;
            
            curr = rotate(curr);
        }
        
        return false;
    }
}