#include <bits/stdc++.h>
using namespace std;

int n, m, ans, cnt, a[8][8], visited[8][8], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
vector<pair<int, int>> v;

void dfs(int y, int x) {
	visited[y][x] = 1;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < n && nx >= 0 && nx < m && a[ny][nx] == 0 && !visited[ny][nx])
			dfs(ny, nx);
	}
}

void solve() {
	memset(visited, 0, sizeof(visited));
	cnt = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 2 && !visited[i][j])
				dfs(i, j);
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (a[i][j] == 0 && !visited[i][j])
				cnt++;
		}
	}

	ans = max(ans, cnt);

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> a[i][j];
			if (a[i][j] == 0)
				v.push_back({ i, j });
		}
	}

	for (int i = 0; i < v.size() - 2; i++) {
		for (int j = i + 1; j < v.size() - 1; j++) {
			for (int k = j + 1; k < v.size(); k++) {
				a[v[i].first][v[i].second] = a[v[j].first][v[j].second] = a[v[k].first][v[k].second] = 1;
				solve();
				a[v[i].first][v[i].second] = a[v[j].first][v[j].second] = a[v[k].first][v[k].second] = 0;
			}
		}
	}
	
	cout << ans;

	return 0;
}