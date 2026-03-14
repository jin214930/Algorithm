#include <bits/stdc++.h>
using namespace std;

string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;
	if (s == "c")
		cout << 26;
	else if (s == "d")
		cout << 10;
	else {
		int ans;
		if (s[0] == 'c')
			ans = 26;
		else
			ans = 10;
		for (int i = 0; i < s.size() - 1; i++) {
			if (s[i] == s[i + 1]) {
				if (s[i] == 'c')
					ans *= 25;
				else
					ans *= 9;
			}
			else {
				if (s[i + 1] == 'c')
					ans *= 26;
				else
					ans *= 10;
			}
		}
		cout << ans;
	}



	return 0;
}