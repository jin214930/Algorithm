#include <bits/stdc++.h>
using namespace std;

int n, x, y, z, a[3], visited[61][61][61];
int d[6][3] = { {9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9} };

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];

	queue<tuple<int, int, int>> q;
	q.push({ a[0], a[1], a[2] });
	visited[a[0]][a[1]][a[2]] = 1;

	while (q.size()) {
		tie(x, y, z) = q.front();
		q.pop();

		for (int i = 0; i < 6; i++) {
			int nx = max(x - d[i][0], 0);
			int ny = max(y - d[i][1], 0);
			int nz = max(z - d[i][2], 0);

			if (!visited[nx][ny][nz]) {
				visited[nx][ny][nz] = visited[x][y][z] + 1;
				q.push({ nx, ny, nz });
			}
		}
	}

	cout << visited[0][0][0] - 1;

	return 0;
}