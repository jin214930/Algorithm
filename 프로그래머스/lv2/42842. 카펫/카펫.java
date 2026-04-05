class Solution {
    public int[] solution(int brown, int yellow) {
        for(int i = 1; i * i <= yellow; i++) {
            if (yellow % i != 0) continue;
            int w = yellow / i;
            int h = i;
            
            if (2* (h + w + 2) == brown)
                return new int[]{w + 2, h + 2};
        }
        
        return null;
    }
}