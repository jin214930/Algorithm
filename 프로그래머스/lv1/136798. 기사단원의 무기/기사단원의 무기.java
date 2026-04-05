class Solution {
    public int solution(int number, int limit, int power) {
        int ans = 0;
        for (int i = 1; i <= number; i++) {
            int cnt = 0;
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0)
                    cnt += 2;
                if (j * j == i)
                    cnt--;
            }
            if (cnt > limit)
                ans += power;
            else
                ans += cnt;
        }
        
        return ans;
    }
}