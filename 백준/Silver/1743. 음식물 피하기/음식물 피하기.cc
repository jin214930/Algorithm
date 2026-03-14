#include <bits/stdc++.h>
using namespace std;

int n, m, k, a[100][100], visited[100][100], ans, dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0 , 0 };

int dfs(int y, int x) {
	int cnt = 1;
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && a[ny][nx]) {
			cnt += dfs(ny, nx);
		}
	}
	return cnt;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m >> k;
	while (k--) {
		int y, x;
		cin >> y >> x;
		a[y - 1][x - 1] = 1;
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] && !visited[i][j]) 
				ans = max(ans, dfs(i, j));
		}
	}

	cout << ans;

	return 0;
}