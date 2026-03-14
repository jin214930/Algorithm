#include <bits/stdc++.h>
using namespace std;

int n, m, d, s, a[50][50], c[50][50], nc[50][50], ans;
int dy[] = { 0, -1, -1, -1, 0, 1, 1, 1 }, dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> a[i][j];
	}

	c[n - 1][0] = 1;
	c[n - 1][1] = 1;
	c[n - 2][0] = 1;
	c[n - 2][1] = 1;

	while (m--) {
		cin >> d >> s;
		s %= n;
		d--;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (c[i][j] == 1) {
					int y = i + dy[d] * s;
					int x = j + dx[d] * s;
					if (y < 0)
						y += n;
					if (y >= n)
						y -= n;
					if (x < 0)
						x += n;
					if (x >= n)
						x -= n;
					nc[y][x] = 1;
					a[y][x]++;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nc[i][j] == 1) {
					for (int k = 1; k < 8; k += 2) {
						int y = i + dy[k];
						int x = j + dx[k];
						if (y >= 0 && y < n && x >= 0 && x < n && a[y][x])
							a[i][j]++;
					}
				}
			}
		}

		memset(c, 0, sizeof(c));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (nc[i][j] != 1 && a[i][j] >= 2) {
					c[i][j] = 1;
					a[i][j] -= 2;
				}
			}
		}
		memset(nc, 0, sizeof(nc));
	}
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			ans += a[i][j];
	}

	

	cout << ans;
	
	return 0;
}