class Solution {
    public int solution(int[] number) {
        int n = number.length;
        int ans= 0;
        for(int i = 2; i <n;i++) {
            for(int j = 1; j <i;j++) {
                for(int k = 0; k < j;k++) {
                    if(number[i] + number[j] + number[k] == 0)
                        ans++;
                }
            }
        }
        return ans;
    }
}