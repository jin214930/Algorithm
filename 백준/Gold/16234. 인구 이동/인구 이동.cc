#include <bits/stdc++.h>
using namespace std;

int n, l, r, ans, sum, a[50][50], visited[50][50], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
vector<pair<int, int>> v;

void dfs(int y, int x) {
	visited[y][x] = 1;
	v.push_back({ y, x });
	sum += a[y][x];

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < n && nx >= 0 && nx < n && !visited[ny][nx] && abs(a[ny][nx] - a[y][x]) >= l && abs(a[ny][nx] - a[y][x]) <= r) 
			dfs(ny, nx);
	}
}
 
int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> l >> r;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> a[i][j];
	}

	while (true) {
		bool flag = false;
		memset(visited, 0, sizeof(visited));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					v.clear();
					sum = 0;
					dfs(i, j);
					for (auto k : v) {
						a[k.first][k.second] = sum / v.size();
					}
					if (v.size() >= 2)
						flag = true;
				}
			}
		}

		if (!flag) {
			cout << ans;
			break;
		}

		ans++;
	}



	return 0;
}