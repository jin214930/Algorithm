class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        
        char[] tmp = {'4', '1', '2'};
        
        while(n > 0) {
            sb.append(tmp[n % 3]);
            n = (n - 1) / 3;
        }
        
        return sb.reverse().toString();
    }
}