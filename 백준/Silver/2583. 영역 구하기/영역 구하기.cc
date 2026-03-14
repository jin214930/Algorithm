#include <bits/stdc++.h>
using namespace std;

int n, m, k, x, y, z, w, a[100][100], visited[100][100], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
vector<int> v;

int dfs(int y, int x) {
	int tmp = 1;
	visited[y][x] = 1;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];

		if (ny >= 0 && ny < n && nx >= 0 && nx < m && !a[ny][nx] && !visited[ny][nx])
			tmp += dfs(ny, nx);
	}

	return tmp;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;

	while (k--) {
		cin >> x >> y >> z >> w;
		for (int i = y; i < w; i++) {
			for (int j = x; j < z; j++)
				a[i][j] = 1;
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!a[i][j] && !visited[i][j])
				v.push_back(dfs(i, j));
		}
	}
	
	sort(v.begin(), v.end());

	cout << v.size() << '\n';
	for (int i : v)
		cout << i << ' ';

	return 0;
}