#include <bits/stdc++.h>
using namespace std;

int n, m, x, y, ans, visited[600][600], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
char a[600][600];

void dfs(int y, int x) {
	visited[y][x] = 1;
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx] && a[ny][nx] != 'X') {
			if (a[ny][nx] == 'P')
				ans++;
			dfs(ny, nx);
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
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j] == 'I') {
				y = i, x = j;
			}
		}
	}

	dfs(y, x);

	if (ans)
		cout << ans;
	else
		cout << "TT";

	return 0;
}