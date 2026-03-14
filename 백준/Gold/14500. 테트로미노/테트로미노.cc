#include <bits/stdc++.h>
using namespace std;

int n, m, a[500][500], visited[500][500], ans, dy[] = { 0,0,1,-1 }, dx[] = { 1,-1,0,0 };

void dfs(int y, int x, int cnt, int sum) {
	if (cnt == 4) {
		ans = max(ans, sum);
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]) {
			visited[ny][nx] = 1;
			dfs(ny, nx, cnt + 1, sum + a[ny][nx]);
			visited[ny][nx] = 0;
		}
	}
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

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			visited[i][j] = 1;
			dfs(i, j, 1, a[i][j]);
			visited[i][j] = 0;
			
			if (i - 1 >= 0 && j + 2 < m) 
				ans = max(ans, a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i - 1][j + 1]);
			if (i + 1 < n && j + 2 < m)
				ans = max(ans, a[i][j] + a[i][j + 1] + a[i][j + 2] + a[i + 1][j + 1]);
			if (i + 2 < n && j + 1 < m)
				ans = max(ans, a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j + 1]);
			if (i + 2 < n && j - 1 >= 0)
				ans = max(ans, a[i][j] + a[i + 1][j] + a[i + 2][j] + a[i + 1][j - 1]);
		}
	}

	cout << ans;

	return 0;
}