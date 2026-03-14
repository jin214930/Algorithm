#include <bits/stdc++.h>
using namespace std;

string s;
int cnt[26];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	for (char c : s) {
		if (c >= 'a' && c <= 'z')
			cnt[c - 'a']++;
		else
			cnt[c - 'A']++;
	}

	int mx = 0, tmp = 0;
	for (int i = 0; i < 26; i++) {
		if (mx < cnt[i]) {
			mx = cnt[i];
			tmp = 1;
		}
		else if (mx == cnt[i])
			tmp++;
	}

	if (tmp >= 2)
		cout << '?';
	else {
		for (int i = 0; i < 26; i++) {
			if (mx == cnt[i])
				cout << char(i + 'A');
		}
	}

	return 0;
}