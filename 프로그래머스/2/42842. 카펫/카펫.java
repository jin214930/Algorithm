class Solution {
    public int[] solution(int brown, int yellow) {        
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0 && (i + yellow / i) * 2 + 4 == brown) 
                    return new int[]{yellow / i + 2, i + 2};
        }
        
        return null;
    }
}