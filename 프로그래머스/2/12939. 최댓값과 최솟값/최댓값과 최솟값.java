class Solution {
    public String solution(String s) {
        String[] nums = s.split(" ");
        
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        
        for (String num : nums) {
            int n = Integer.parseInt(num);
            max = Math.max(max, n);
            min = Math.min(min, n);
        }
        
        return min + " " + max;
    }
}