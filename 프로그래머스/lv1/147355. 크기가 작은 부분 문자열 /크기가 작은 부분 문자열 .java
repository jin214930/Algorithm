class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        for(int i = 0; i < t.length(); i++) {
            if(i + p.length() > t.length())
                break;
            long pl = Long.parseLong(p);
            long tmp = Long.parseLong(t.substring(i, i + p.length()));
            if(pl >= tmp)
                cnt++;
        }
        return cnt;
    }
}