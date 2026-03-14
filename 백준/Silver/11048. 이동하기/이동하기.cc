#include <bits/stdc++.h>
using namespace std;

int n, m, a[1001][1001], d[1001][1001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++)
			cin >> a[i][j];
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			d[i][j] = max({ d[i - 1][j], d[i - 1][j - 1], d[i][j - 1] }) + a[i][j];
		}
	}

	cout << d[n][m];

	return 0;
}