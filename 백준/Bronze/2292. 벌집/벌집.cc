#include <bits/stdc++.h>
using namespace std;

int n, ans, tmp = 1;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (true) {
		for (int i = tmp; i <= tmp + ans * 6; i++) {
			if (i == n) {
				cout << ans + 1;
				return 0;
			}
		}
		tmp += ans * 6;
		ans++;
	}


	return 0;
}