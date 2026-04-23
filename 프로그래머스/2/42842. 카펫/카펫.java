class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i != 0) continue;
            int j = yellow / i;
            if (4 + 2 * (i + j) == brown) {
                return new int[] {j + 2, i + 2};
            }
        }
        
        return null;
    }
}