class Solution {
    public int[] solution(String s) {
        int turn = 0;
        int cnt0 = 0;
        
        while(!s.equals("1")) {
            int len = s.length();
            int cnt1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') cnt1++;
            }
            cnt0 += len - cnt1;
            s = Integer.toBinaryString(cnt1);
            turn++;
        }
        
        return new int[]{turn, cnt0};
    }
}