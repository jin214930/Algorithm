#include <bits/stdc++.h>
using namespace std;

int n, m, cnt1, cnt2, a[100][100], visited[100][100], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };

bool check() {
	bool flag = true;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++)
			if (a[i][j])
				flag = false;
	}

	return flag;
}

void dfs(int y, int x) {
	visited[y][x] = 1;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && ny < n && nx >= 0 && nx < m && !visited[ny][nx]) {
			if (a[ny][nx]) {
				cnt1++;
				a[ny][nx] = 0;
				visited[ny][nx] = 1;
			}
			else
				dfs(ny, nx);
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

	while (true) {
		memset(visited, 0, sizeof(visited));

		if (check()) {
			cout << cnt2 << '\n' << cnt1;
			break;
		}

		cnt1 = 0;
		dfs(0, 0);
		cnt2++;
	}

	return 0;
}