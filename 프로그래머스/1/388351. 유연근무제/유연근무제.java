class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int ans = 0;
        for (int i = 0; i < schedules.length; i++) {
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                int modDay = (startday + j) % 7;
                if (modDay == 0 || modDay == 6) continue;
                int tmp = schedules[i] + 10;
                if (tmp % 100 >= 60) {
                    int m = tmp % 100 % 60;
                    int h = tmp / 100 + 1;
                    tmp = h * 100 + m;
                }
                
                if (tmp < timelogs[i][j]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag)
                ans++;
        }
        
        return ans;
    }
}