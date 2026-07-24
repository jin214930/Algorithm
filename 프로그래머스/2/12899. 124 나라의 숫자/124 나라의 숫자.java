class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int[] a = {1, 2, 4};
        
        n--;
        while(true) {
            sb.append(a[n % 3]);
            n = n / 3 - 1;
            if (n < 0) break;
        }
        
        return sb.reverse().toString();
    }
}