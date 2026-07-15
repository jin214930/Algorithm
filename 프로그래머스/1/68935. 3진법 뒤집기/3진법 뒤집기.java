class Solution {
    public int solution(int n) {
        String s = Integer.toString(n, 3);
        StringBuilder sb = new StringBuilder(s);
        String r = sb.reverse().toString();
        return Integer.parseInt(r, 3);
    }
}