class Solution {
    static int cnt;
    public void go(int[] a, int x, int idx, int ret) {
        if(idx == a.length) {
            if(x == ret)
                cnt++;
            return;
        }
        go(a, x, idx + 1, ret + a[idx]);
        go(a, x, idx + 1, ret - a[idx]);
        
    }
    public int solution(int[] numbers, int target) {
        go(numbers, target, 0, 0);
        return cnt;
    }
}