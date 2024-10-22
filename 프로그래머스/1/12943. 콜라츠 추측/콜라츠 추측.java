class Solution {
    public int solution(long num) {
        int cnt = 0;
        while(true) {
            if(num == 1)
                break;
            if(num % 2 == 0)
                num /= 2;
            else
                num = num * 3 + 1;
            cnt++;
            if(cnt >= 500)
                return -1;
        }
        return cnt;
    }
}