class Solution {
    public int[] solution(int brown, int yellow) {
        int[] ans = new int[2];
        
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                int tmp = (i + yellow / i) * 2 + 4;
                if (tmp == brown) {
                    ans[0] = yellow / i + 2;
                    ans[1] = i + 2;
                    return ans;
                }
            }
        }
        
        return ans;
    }
}