class Solution {
    public int[] solution(String s) {
        int turn = 0;
        int cnt0 = 0;
        
        while(!s.equals("1")) {
            int tmp = s.length();
            s = s.replaceAll("0", "");
            cnt0 += tmp - s.length();
            s = Integer.toBinaryString(s.length());
            turn++;
        }
        
        return new int[]{turn, cnt0};
    }
}