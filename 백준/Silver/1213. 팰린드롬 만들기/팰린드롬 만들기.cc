#include <bits/stdc++.h>
using namespace std;

string s, ans;
int cnt[26];


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;

	for (char c : s)
		cnt[c - 'A']++;

	for (int i = 0; i < 26; i++) {
		if (cnt[i] % 2) {
			if (ans.empty()) {
				ans += i + 'A';
				cnt[i]--;
			}
			else {
				cout << "I'm Sorry Hansoo";
				return 0;
			}
		}
	}
	
	for (int i = 25; i >= 0; i--) {
		for (int j = 0; j < cnt[i] / 2; j++) {
			char  tmp = i + 'A';
			ans += tmp;
			ans = tmp + ans;
		}
	}

	cout << ans;
	
	return 0;
}