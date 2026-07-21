class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        int x = 0;
        while (sb.length() < t * m) {
            sb.append(Integer.toString(x, n));
            x++;
        }
        
        String fullStr = sb.toString().toUpperCase();
        sb.setLength(0);
        for (int i = 0; i < t; i++) {
            sb.append(fullStr.charAt(p - 1 + i * m));
        }
        
        return sb.toString();
    }
}