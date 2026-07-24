class Solution {
    public long[] solution(long[] numbers) {
        long[] ans = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            String s = Long.toBinaryString(numbers[i]);
            if (s.charAt(s.length() - 1) == '0') {
                ans[i] = Long.parseLong(s.substring(0, s.length() - 1) + "1", 2);
            } else {
                int idx = s.lastIndexOf('0');
                if (idx == -1) {
                    ans[i] = Long.parseLong("10" + s.substring(1), 2);
                } else {
                    ans[i] = Long.parseLong(s.substring(0, idx) + "10" + s.substring(idx + 2), 2);
                }
            }            
        }
        
        return ans;
    }
}