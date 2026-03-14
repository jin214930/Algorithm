#include <bits/stdc++.h>
using namespace std;

int r, c, visited[250][250], dy[] = { 0, 0, 1, -1 }, dx[] = { -1, 1, 0, 0 }, cntv, cnto, ansv, anso;
char a[250][250];

void dfs(int y, int x) {
	visited[y][x] = 1;
	if (a[y][x] == 'v')
		cntv++;
	if (a[y][x] == 'o')
		cnto++;

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < r && nx < c && !visited[ny][nx] && a[ny][nx] != '#')
			dfs(ny, nx);
	}

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cnto = 0;
			cntv = 0;
			if (!visited[i][j] && a[i][j] != '#') {
				dfs(i, j);
				if (cnto > cntv)
					anso += cnto;
				else
					ansv += cntv;
			}
		}
	}

	cout << anso << ' ' << ansv;
	

	return 0;
}