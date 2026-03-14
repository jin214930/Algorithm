#include <bits/stdc++.h>
using namespace std;

int r, c, visited[26], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 }, ans;
char a[20][20];

void dfs(int y, int x, int cnt) {
	ans = max(ans, cnt);
	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < r && nx >= 0 && nx < c && !visited[a[ny][nx] - 'A']) {
			visited[a[ny][nx] - 'A'] = 1;
			dfs(ny, nx, cnt + 1);
			visited[a[ny][nx] - 'A'] = 0;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cin >> a[i][j];
	}

	visited[a[0][0] - 'A'] = 1;
	dfs(0, 0, 1);

	cout << ans;

	return 0;
}