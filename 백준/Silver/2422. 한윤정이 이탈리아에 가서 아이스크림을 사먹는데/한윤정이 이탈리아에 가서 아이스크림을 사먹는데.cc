#include <bits/stdc++.h>
using namespace std;

int n, m, ans, a[201][201];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int x, y;
		cin >> x >> y;
		a[x][y] = 1;
		a[y][x] = 1;
	}

	for (int i = 1; i <= n - 2; i++) {
		for (int j = i + 1; j <= n - 1; j++) {
			for (int k = j + 1; k <= n; k++) {
				if (!(a[i][j] || a[i][k] || a[j][k]))
					ans++;
			}
		}
	}

	cout << ans;

	return 0;
}