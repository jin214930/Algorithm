class Solution {
    public int[] solution(String[] wallpaper) {
        int mny = 100, mnx = 100, mxy = 0, mxx = 0;
        
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    mny = Math.min(mny, i);
                    mxy = Math.max(mxy, i);
                    mnx = Math.min(mnx, j);
                    mxx = Math.max(mxx, j);
                }
            }
        }
        
        int[] ans = new int[4];
        ans[0] = mny;
        ans[1] = mnx;
        ans[2] = mxy + 1;
        ans[3] = mxx + 1;
    
        return ans;
    }
}