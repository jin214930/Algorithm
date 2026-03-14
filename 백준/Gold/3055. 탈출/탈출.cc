#include <bits/stdc++.h>
using namespace std;

int r, c, visited[50][50], water[50][50], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 }, ay, ax;
char a[50][50];
queue<pair<int, int>> q1, q2;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> a[i][j];
			water[i][j] = 999999999;
			if (a[i][j] == '*') {
				q1.push({ i, j });
				water[i][j] = 1;
			}
			else if (a[i][j] == 'S') {
				q2.push({ i, j });
				visited[i][j] = 1;
			}
			else if (a[i][j] == 'D') {
				ay = i;
				ax = j;
			}
		}
	}

	while (q1.size()) {
		int y, x;
		tie(y, x) = q1.front();
		q1.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < r && nx < c && water[ny][nx] == 999999999 && a[ny][nx] == '.') {
				water[ny][nx] = water[y][x] + 1;
				q1.push({ ny, nx });
			}
		}
	}

	while (q2.size()) {
		int y, x;
		tie(y, x) = q2.front();
		q2.pop();
		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny >= 0 && nx >= 0 && ny < r && nx < c && a[ny][nx] != 'X' && !visited[ny][nx] && water[ny][nx] > visited[y][x] + 1) {
				visited[ny][nx] = visited[y][x] + 1;
				q2.push({ ny, nx });
			}
		}
	}

	if (visited[ay][ax])
		cout << visited[ay][ax] - 1;
	else
		cout << "KAKTUS";	
	
	return 0;
}