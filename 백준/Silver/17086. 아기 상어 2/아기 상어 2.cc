#include <bits/stdc++.h>
using namespace std;

int n, m, a[50][50], visited[50][50], ans;
int dy[] = { 0, 0, -1, 1, 1, 1, -1, -1 }, dx[] = { 1, -1, 0, 0, 1, -1, 1, -1 };
queue<pair<int, int>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j]) {
				q.push({ i, j });
				visited[i][j] = 1;
			}
		}
	}

	while (q.size()) {
		int y, x;
		tie(y, x) = q.front();
		q.pop();
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]) {
				q.push({ ny, nx });
				visited[ny][nx] = visited[y][x] + 1;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			ans = max(ans, visited[i][j]);
	}

	cout << ans - 1;

	return 0;
}