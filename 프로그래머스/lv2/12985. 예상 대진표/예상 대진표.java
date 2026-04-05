class Solution {
    public int solution(int n, int a, int b) {
        if (a > b) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        
        int ans = 1;
        while (true) {
            if (a % 2 == 1 && b == a + 1)
                return ans;
            a = a / 2 + (a % 2 == 0 ? 0 : 1);
            b = b / 2 + (b % 2 == 0 ? 0 : 1);
            ans++;
        }
    }
}