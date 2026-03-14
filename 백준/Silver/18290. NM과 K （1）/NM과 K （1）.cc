#include <bits/stdc++.h>
using namespace std;

int n, m, k, a[10][10], visited[10][10], ans = -999999999;

void go(int cnt, int sum) {
	if (cnt == k) {
		ans = max(ans, sum);
		return;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visited[i][j])
				continue;
			if (i >= 1 && visited[i - 1][j])
				continue;
			if (i < n - 1 && visited[i + 1][j])
				continue;
			if (j >= 1 && visited[i][j - 1])
				continue;
			if (j < m - 1 && visited[i][j + 1])
				continue;
			visited[i][j] = 1;
			go(cnt + 1, sum + a[i][j]);
			visited[i][j] = 0;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visited[i][j] = 1;
			go(1, a[i][j]);
			visited[i][j] = 0;
		}
	}

	cout << ans;

	return 0;
}