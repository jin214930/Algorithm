#include <bits/stdc++.h>
using namespace std;

int t, a, b, visited[10000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		memset(visited, 0, sizeof(visited));
		cin >> a >> b;
		visited[a] = 1;
		queue<pair<int, string>> q;
		q.push({ a, "" });

		while (q.size()) {
			int x;
			string s;
			tie(x, s) = q.front();
			q.pop();

			if (x == b) {
				cout << s << '\n';
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nx;
				char tmp;
				if (i == 0) {
					nx = 2 * x % 10000;
					tmp = 'D';
				}
				else if (i == 1) {
					nx = x - 1;
					if (nx == -1)
						nx = 9999;
					tmp = 'S';
				}
				else if (i == 2) {
					nx = x % 1000 * 10;
					nx += x / 1000;
					tmp = 'L';
				}
				else {
					nx = x / 10;
					nx += x % 10 * 1000;
					tmp = 'R';
				}
				if (!visited[nx]) {
					visited[nx] = 1;
					s += tmp;				
					q.push({ nx, s });
					s.pop_back();
				}
			}
		}
	}

	return 0;
}