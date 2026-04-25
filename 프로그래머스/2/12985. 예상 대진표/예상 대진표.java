class Solution {
    public int solution(int n, int a, int b) {
        int ans = 0;
        a--;
        b--;
        while(true) {
            ans++;
            if (a / 2 == b / 2) {
                return ans;
            }
            
            a /= 2;
            b /= 2;
        }
    }
}