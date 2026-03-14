#include <bits/stdc++.h>
using namespace std;

int n, m, x, y, visited[101], a[101];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n + m; i++) {
		cin >> x >> y;
		a[x] = y;
	}

	queue<int> q;
	visited[1] = 1;
	q.push(1);

	while (q.size()) {
		x = q.front();
		q.pop();
		for (int i = 1; i <= 6; i++) {
			int nx = x + i;
			if (nx > 100)
				continue;
			if (a[nx])
				nx = a[nx];
			if (!visited[nx]) {
				visited[nx] = visited[x] + 1;
				q.push({ nx });
			}
		}
	}


	cout << visited[100] - 1;

	

	return 0;
}