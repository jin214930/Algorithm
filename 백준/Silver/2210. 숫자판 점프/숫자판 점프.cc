#include <bits/stdc++.h>
using namespace std;

int a[5][5], dy[] = { 0, 0, 1, -1 }, dx[] = { 1, -1, 0, 0 };
set<string> s;

void go(int y, int x, int n, string str) {
	if (n == 6) {
		s.insert(str);
		return;
	}

	for (int i = 0; i < 4; i++) {
		int ny = y + dy[i];
		int nx = x + dx[i];
		if (ny >= 0 && nx >= 0 && ny < 5 && nx < 5) {
			str += '0' + a[ny][nx];
			go(ny, nx, n + 1, str);
			str.pop_back();
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			string s = "";
			s += a[i][j];
			go(i, j, 1, s);
		}
	}

	cout << s.size();

	return 0;
}