#include <bits/stdc++.h>
using namespace std;

int n, a[10][10], visited[10][10], ans = 999999999, dy[] = { 0,0,1,-1 }, dx[] = { 1,-1,0,0 };
vector<pair<int, int>> v;

void go(int b, int c, int d) {
	int sum = 0;
	memset(visited, 0, sizeof(visited));
	for (int i : {b, c, d}) {
		int y = v[i].first;
		int x = v[i].second;
		visited[y][x] = 1;
		sum += a[y][x];
		for (int j = 0; j < 4; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			if (ny < 0 || nx < 0 || ny >= n || nx >= n || visited[ny][nx])
				return;
			sum += a[ny][nx];
			visited[ny][nx] = 1;
		}
	}

	ans = min(sum, ans);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			v.push_back({ i, j });
		}
	}

	for (int i = 0; i < v.size()-2; i++) {
		for (int j = i + 1; j < v.size() - 1; j++) {
			for (int k = j + 1; k < v.size(); k++) {
				go(i, j, k);
			}
		}
	}

	cout << ans;

	return 0;
}