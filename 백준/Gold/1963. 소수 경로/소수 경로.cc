#include <bits/stdc++.h>
using namespace std;

int t, visited[10000], p[10000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	p[1] = 1;
	for (int i = 2; i < 10000; i++) {
		if (!p[i]) {
			for (int j = i * 2; j < 10000; j += i)
				p[j] = 1;
		}
	}


	cin >> t;
	while (t--) {
		int a, b;
		memset(visited, 0, sizeof(visited));
		cin >> a >> b;
		visited[a] = 1;
		queue<int> q;
		q.push(a);

		while (q.size()) {
			int x = q.front();
			q.pop();

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 10; j++) {
					string tmp = to_string(x);
					if (i == 0 && j == 0)
						continue;
					tmp[i] = j + '0';
					int nx = stoi(tmp);
					if (!visited[nx] && !p[nx]) {
						visited[nx] = visited[x] + 1;
						q.push(nx);
					}
				}
			}
		}

		if (visited[b] == 0)
			cout << "Impossible\n";
		else
			cout << visited[b] - 1 << '\n';
	}
	
	return 0;
}