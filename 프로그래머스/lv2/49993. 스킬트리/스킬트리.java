class Solution {
    public int solution(String skill, String[] skill_trees) {
        int[] a = new int[26];
        for (int i = 0; i < skill.length(); i++) 
            a[skill.charAt(i) - 'A'] = i + 1;
        
        int ans = 0;
        for (String s : skill_trees) {
            int tmp = 0;
            boolean flag = false;
            for (char c : s.toCharArray()) {
                if (a[c - 'A'] == 0)
                    continue;
                else if (a[c - 'A'] == tmp + 1) 
                    tmp = a[c - 'A'];
                else {
                    flag = true;
                    break;
                }
            }
            if (flag)
                continue;
            ans++;
            System.out.println(s);
        }
        
        return ans;
    }
}