#include <bits/stdc++.h>
using namespace std;

int r, c, dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
char a[500][500];
vector<pair<int, int>> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> r >> c;
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++) {
			cin >> a[i][j];
			if (a[i][j] == 'W')
				v.push_back({ i, j });
		}
	}

	for (auto i : v) {
		int y = i.first;
		int x = i.second;
		for (int j = 0; j < 4; j++) {
			int ny = y + dy[j];
			int nx = x + dx[j];
			if (ny >= 0 && nx >= 0 && ny < r && nx < c) {
				if (a[ny][nx] == 'S') {
					cout << 0;
					return 0;
				}
				if (a[ny][nx] == '.')
					a[ny][nx] = 'D';
			}
		}
	}

	cout << 1 << '\n';
	for (int i = 0; i < r; i++) {
		for (int j = 0; j < c; j++)
			cout << a[i][j];
		cout << '\n';
	}

	
	

	return 0;
}