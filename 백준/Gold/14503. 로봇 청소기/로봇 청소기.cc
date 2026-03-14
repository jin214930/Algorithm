#include <bits/stdc++.h>
using namespace std;

int n, m, y, x, d, dy[] = { -1, 0, 1, 0 }, dx[] = { 0, 1, 0, -1 }, a[50][50], visited[50][50], ans;
bool flag;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> y >> x >> d;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			cin >> a[i][j];
	}

	while (true) {
		flag = false;
		if (!visited[y][x]) {
			visited[y][x] = 1;
			ans++;
		}
		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int ny = y + dy[d];
			int nx = x + dx[d];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && !a[ny][nx]) {
				y = ny;
				x = nx;
				flag = true;
				break;
			}
		}
		if (flag)
			continue;
		int ny = y - dy[d];
		int nx = x - dx[d];
		if (ny >= 0 && nx >= 0 && ny < n && nx < m && !a[ny][nx]) {
			y = ny;
			x = nx;
		}
		else
			break;
	}

	cout << ans;

	return 0;
}