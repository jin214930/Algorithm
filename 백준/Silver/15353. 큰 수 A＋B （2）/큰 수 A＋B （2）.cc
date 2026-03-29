#include <bits/stdc++.h>
#include <algorithm>

using namespace std;

string addStr(string s1, string s2) {
    string ans = "";
    int c = 0; 

    int len1 = s1.length();
    int len2 = s2.length();

    for (int i = 0; i < len1; i++) {
        int a = s1[len1 - i - 1] - '0';
        int b = 0;
        
        if (i < len2) {
            b = s2[len2 - i - 1] - '0';
        }

        int tmp = a + b + c;
        ans += to_string(tmp % 10);
        c = tmp / 10;
    }
    
    if (c != 0) {
        ans += to_string(c);
    }

    reverse(ans.begin(), ans.end());

    return ans;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string s1, s2;
    cin >> s1 >> s2;
    
    if (s1.length() < s2.length()) {
        swap(s1, s2);
    }

    cout << addStr(s1, s2) << "\n";

    return 0;
}
