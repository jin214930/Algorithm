class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] ans = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                if (arr1[i] % 2 == 0 && arr2[i] % 2 == 0)
                    sb.insert(0, " ");
                else
                    sb.insert(0, "#");
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            ans[i] = sb.toString();
        }
        return ans;
    }
}