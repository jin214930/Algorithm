#include <bits/stdc++.h>
using namespace std;

string s;
int q, l, r, psum[200001][26];
char a;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	for (int i = 0; i < s.size(); i++) {
		for (int j = 0; j < 26; j++)
			psum[i + 1][j] = psum[i][j];
		psum[i + 1][s[i] - 'a']++;
	}

	cin >> q;
	while (q--) {
		cin >> a >> l >> r;
		cout << psum[r + 1][a - 'a'] - psum[l][a - 'a'] << '\n';
	}
	

	return 0;
}