#include <bits/stdc++.h>
using namespace std;

int n, m, x, y, a[1000][1000], visited[1000][1000], dy[] = { 0,0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
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
			if (a[i][j])
				visited[i][j] = -1;
			if (a[i][j] == 2) {
				q.push({ i, j });
				visited[i][j] = 1;
			}
		}
	}

	while (q.size()) {
		tie(y, x) = q.front();
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] && visited[ny][nx] == -1) {
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ ny, nx });
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (visited[i][j] > 0)
				cout << visited[i][j] - 1 << ' ';
			else
				cout << visited[i][j] << ' ';
		}
		cout << '\n';
	}


	return 0;
}