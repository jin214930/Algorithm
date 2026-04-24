class Solution {
    public int solution(int[] arr) {
        int max = 0;
        for (int n : arr) {
            max = Math.max(max, n);
        }
        
        for (int i = max; ; i++) {
            boolean flag = true;
            for (int n : arr) {
                if (i % n != 0) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                return i;
            }
        }
    }
}