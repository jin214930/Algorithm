#include <bits/stdc++.h>
using namespace std;

int n, m, psum[10001], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		int tmp;
		cin >> tmp;
		psum[i] = tmp + psum[i - 1];
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 0; j < i; j++) {
			if (psum[i] - psum[j] == m)
				ans++;
		}
	}

	cout << ans;

	return 0;
}