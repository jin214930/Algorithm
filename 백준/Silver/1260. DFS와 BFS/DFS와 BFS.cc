#include <bits/stdc++.h>
using namespace std;

int n, m, v, a, b, visited[1001];
vector<int> adj[1001];

void dfs(int x) {
	cout << x << ' ';

	visited[x] = 1;

	for (int nx : adj[x]) {
		if (!visited[nx])
			dfs(nx);
	}
}

void bfs(int x) {
	queue<int> q;
	q.push(x);
	visited[x] = 1;

	while (q.size()) {
		int x = q.front();
		q.pop();

		cout << x << ' ';

		for (int nx : adj[x]) {
			if (!visited[nx]) {
				q.push(nx);
				visited[nx] = 1;
			}
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> v;
	while (m--) {
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	for (int i = 1; i <= n; i++)
		sort(adj[i].begin(), adj[i].end());

	dfs(v);
	cout << '\n';
	memset(visited, 0, sizeof(visited));
	bfs(v);

	return 0;
}