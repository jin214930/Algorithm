#include <bits/stdc++.h>
using namespace std;

int n, m, a[100][70], dy[] = { 0, 0, 1, -1, 1, 1, -1, -1 }, dx[] = { 1, -1, 0, 0, -1, 1, -1, 1 }, visited[100][70], ans, cnt;
vector<pair<int, int>> v;

bool check() {
	for (auto i : v) {
		int y = i.first;
		int x = i.second;
		for (int j = 0; j < 8; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m && a[y][x] < a[ny][nx])
				return false;
		}
	}
	return true;
}

void dfs(int y, int x) {
	visited[y][x] = 1;
	v.push_back({ y, x });

	for (int i = 0; i < 8; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx] && a[ny][nx] == a[y][x])
			dfs(ny, nx);
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
			if (!visited[i][j]) {
				v.clear();
				dfs(i, j);
				cnt++;

				if (check()) 
					ans++;
			}
		}
	}

	cout << ans;

	return 0;
}