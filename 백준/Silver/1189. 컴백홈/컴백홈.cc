#include <bits/stdc++.h>
using namespace std;

int r, c, k, visited[5][5], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 }, ans;
char a[5][5];

void dfs(int y, int x, int cnt) {
	if (y == 0 && x == c - 1 && cnt == k) {
		ans++;
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < r && nx < c && a[ny][nx] != 'T' && !visited[ny][nx]) {
			visited[ny][nx] = 1;
			dfs(ny, nx, cnt + 1);
			visited[ny][nx] = 0;
		}
	}
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> r >> c >> k;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cin >> a[i][j];
	}

	visited[r-1][0] = 1;
	dfs(r-1, 0, 1);

	cout << ans;

	return 0;
}