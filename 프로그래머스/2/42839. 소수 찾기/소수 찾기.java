class Solution {
    int ans = 0;
    boolean[] p = new boolean[10000000];
    boolean[] visited = new boolean[10000000];
    boolean[] used;
    
    public void go(String s, String numbers) {
        if (!s.equals("")) {
            int tmp = Integer.parseInt(s);
            if (!p[tmp] && !visited[tmp] && tmp != 0) {
                ans++;
                visited[tmp] = true;
            }
        }
        for (int i = 0; i < numbers.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                go(s + numbers.charAt(i), numbers);
                used[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        used = new boolean[numbers.length()];
        p[1] = true;
        for (int i = 2; i < 10000000; i++) {
            if (!p[i]) {
                for (int j = i * 2; j < 10000000; j += i)
                    p[j] = true;
            }
        }
        go("", numbers);
        return ans;
    }
}