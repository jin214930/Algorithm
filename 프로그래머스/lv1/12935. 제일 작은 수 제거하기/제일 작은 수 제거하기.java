class Solution {
    public int[] solution(int[] arr) {
        int mn = Integer.MAX_VALUE;
        for(int i : arr)
            mn = Math.min(i, mn);
        if(arr.length == 1) {
            int[] ans = {-1};
            return ans;
        }
        int[] ans = new int[arr.length-1];
        int idx =0;
        for(int i : arr) {
            if(i != mn)
                ans[idx++] = i;
        }
        return ans;
    }
}