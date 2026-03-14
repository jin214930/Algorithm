#include <bits/stdc++.h>
using namespace std;

int n, m, y, x, ans, a[1000][1000], visited[1000][1000], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m >> n;

	queue<pair<int, int>> q;
	bool flag = true;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j] == 1) {
				q.push({ i, j });
				visited[i][j] = 1;
			}
			if (a[i][j] == 0)
				flag = false;
		}
	}

	if (flag) {
		cout << 0;
		return 0;
	}

	while (q.size()) {
		tie(y, x) = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] == 0 && !visited[ny][nx]) {
				a[ny][nx] = 1;
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ ny, nx });
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0) {
				cout << -1;
				return 0;
			}
			ans = max(visited[i][j], ans);
		}
	}

	cout << ans - 1;

	return 0;
}