#include <bits/stdc++.h>
using namespace std;

int n, m, ans = 999999999;
char a[50][50];

int go(int y, int x) {
	int cnt1 = 0, cnt2 = 0;

	for (int i = y; i < y + 8; i++) {
		for (int j = x; j < x + 8; j++) {
			if ((i + j) % 2) {
				if (a[i][j] == 'B')
					cnt1++;
				else
					cnt2++;
			}
			else {
				if (a[i][j] == 'W')
					cnt1++;
				else
					cnt2++;
			}
		}
	}

	return min(cnt1, cnt2);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i <= n - 8; i++) {
		for (int j = 0; j <= m - 8; j++)
			ans = min(ans, go(i, j));
	}

	cout << ans;
	
	return 0;
}