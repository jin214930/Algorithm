#include <bits/stdc++.h>
using namespace std;

int n, m, d[301][301];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	d[1][1] = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (i == 1 && j == 1)
				continue;
			d[i][j] = 999999999;
			for (int k = 1; k <= i / 2; k++)
				d[i][j] = min(d[i][j], d[i - k][j] + d[k][j] + 1);
			for (int k = 1; k <= j / 2; k++)
				d[i][j] = min(d[i][j], d[i][j - k] + d[i][k] + 1);
		}
	}

	cout << d[n][m];

	return 0;
}