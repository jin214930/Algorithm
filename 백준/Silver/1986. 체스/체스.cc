#include <bits/stdc++.h>
using namespace std;

int n, m, visited[1000][1000], q, k, p, ans, y, x;
int dyq[] = { 0, 0, 1, 1, 1, -1, -1, -1 }, dxq[] = { 1, -1, 0, 1, -1, 0, 1, -1 };
int dyk[] = { -1, -2, -2, -1, 1, 2, 2, 1 }, dxk[] = { -2, -1, 1, 2, 2, 1, -1, -2 };
char a[1000][1000];
queue<pair<int, int>> q1, q2;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	cin >> q;
	for (int i = 0; i < q; i++) {
		cin >> y >> x;
		y--;
		x--;
		q1.push({ y, x });
		visited[y][x] = 1;
		a[y][x] = 'q';
	}

	cin >> k;
	for (int i = 0; i < k; i++) {
		cin >> y >> x;
		y--;
		x--;
		q2.push({ y, x });
		visited[y][x] = 1;
		a[y][x] = 'k';
	}

	cin >> p;
	for (int i = 0; i < p; i++) {
		cin >> y >> x;
		y--;
		x--;
		visited[y][x] = 1;
		a[y][x] = 'p';
	}

	while (q1.size()) {
		tie(y, x) = q1.front();
		q1.pop();
		for (int i = 0; i < 8; i++) {
			int ny = y;
			int nx = x;
			while (true) {
				ny += dyq[i];
				nx += dxq[i];
				if (ny < 0 || nx < 0 || ny >= n || nx >= m || a[ny][nx] != '\0')
					break;
				visited[ny][nx] = 1;
			}
		}
	}

	while (q2.size()) {
		int y, x;
		tie(y, x) = q2.front();
		q2.pop();
		for (int i = 0; i < 8; i++) {
			int ny = y + dyk[i];
			int nx = x + dxk[i];
			if (ny >= 0 && nx >= 0 && ny < n && nx < m && !visited[ny][nx]) {
				visited[ny][nx] = 1;
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			if (!visited[i][j])
				ans++;
		}
	}

	cout << ans;

	
	return 0;
}