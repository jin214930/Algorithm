#include <bits/stdc++.h>
using namespace std;

int n, ans, a[26];
string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n--) {
		memset(a, 0, sizeof(a));
		cin >> s;
		ans++;
		a[s[0] - 'a'] = 1;
		for (int i = 1; i < s.size(); i++) {
			if (a[s[i] - 'a']) {
				if (s[i - 1] != s[i]) {
					ans--;
					break;
				}
					
			}
			else
				a[s[i] - 'a'] = 1;
		}
	}

	cout << ans;
	

	return 0;
}