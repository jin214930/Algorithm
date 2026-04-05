class Solution {
    public String solution(int a, int b) {
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] monthName = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        
        int tmp = b;
        for(int i = 0; i < a - 1; i++)
            tmp += month[i];
        
        return monthName[tmp % 7];
        
    }
}