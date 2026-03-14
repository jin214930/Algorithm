#include <bits/stdc++.h>
using namespace std;

int w , h, a[50][50], visited[50][50], dy[] = { 0, 0, 1, -1 , 1, 1, -1, -1 }, dx[] = { 1, -1, 0, 0, 1, -1, 1, -1 };

void dfs(int y, int x) {
	visited[y][x] = 1;

	for (int i = 0; i < 8; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < h && nx >= 0 && nx < w && a[ny][nx] && !visited[ny][nx])
			dfs(ny, nx);
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (true) {
		cin >> w >> h;

		if (w == 0 && h == 0)
			break;

		memset(visited, 0, sizeof(visited));
		int ans = 0;

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++)
				cin >> a[i][j];
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (a[i][j] && !visited[i][j]) {
					dfs(i, j);
					ans++;
				}
			}
		}

		cout << ans << '\n';
	}
	

	return 0;
}