#include <bits/stdc++.h>
using namespace std;

int n, a, b, c, d, dy[] = { -2, -2, 0, 0, 2, 2 }, dx[] = { -1, 1, -2, 2, -1, 1 }, visited[200][200];
queue<pair<int, int>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> a >> b >> c >> d;

	q.push({ a, b });
	visited[a][b] = 1;
	while (q.size()) {
		int y, x;
		tie(y, x) = q.front();
		q.pop();
		if (y == c && x == d) {
			cout << visited[c][d] - 1;
			return 0;
		}
		for (int i = 0; i < 6; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < n && nx < n && !visited[ny][nx]) {
				visited[ny][nx] = visited[y][x] + 1;
				q.push({ ny, nx });
			}
		}
	}

	cout << -1;

	return 0;
}