#include <bits/stdc++.h>
using namespace std;

int n, m, ans, visited[50][50], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
char a[50][50];

void bfs(int y, int x) {
	queue<pair<int, int>> q;
	visited[y][x] = 1;
	q.push({ y, x });

	while (q.size()) {
		tie(y, x) = q.front();
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] == 'L' && !visited[ny][nx]) {
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ ny, nx });
			}
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
			if (a[i][j] == 'L') {
				memset(visited, 0, sizeof(visited));
				bfs(i, j);
				for (int k = 0; k < n; k++) {
					for (int l = 0; l < m; l++)
						ans = max(ans, visited[k][l]);
				}
			}
		}
	}

	cout << ans - 1;

	return 0;
}