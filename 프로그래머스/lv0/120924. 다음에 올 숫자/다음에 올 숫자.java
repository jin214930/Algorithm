class Solution {
    public int solution(int[] common) {
        int a = common[0];
        int b = common[1];
        int c = common[2];
        if (b - a == c - b) 
            return common[common.length - 1] + b - a;
        else
            return common[common.length - 1] * (b / a);
    }
}