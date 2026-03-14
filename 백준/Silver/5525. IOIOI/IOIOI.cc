#include <bits/stdc++.h>
using namespace std;

int n, m, ans, cnt;
string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> s;

	for (int i = 0; i < m - 2; i++) {
		if (s[i] == 'I' && s[i + 1] == 'O' && s[i + 2] == 'I') {
			cnt++;
			i++;
		}
		else {
			if (cnt - n >= 0)
				ans += cnt - n + 1;
			cnt = 0;
		}
	}
	if (cnt - n >= 0)
		ans += cnt - n + 1;

	cout << ans;



	return 0;
}