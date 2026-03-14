#include <bits/stdc++.h>
using namespace std;

int n, m, u, v, ans, visited[1001];
vector<int> adj[1001];

void dfs(int x) {
	visited[x] = 1;

	for (int nx : adj[x]) {
		if (!visited[nx])
			dfs(nx);
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	while (m--) {
		cin >> u >> v;
		adj[u].push_back(v);
		adj[v].push_back(u);
	}

	for (int i = 1; i <= n; i++) {
		if (!visited[i]) {
			dfs(i);
			ans++;
		}
	}

	cout << ans;
	

	return 0;
}