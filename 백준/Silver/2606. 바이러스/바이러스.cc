#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, visited[101];
vector<int> adj[101];

int dfs(int x) {
	int ret = 1;
	visited[x] = 1;
	for (int nx : adj[x]) {
		if (!visited[nx])
			ret += dfs(nx);
	}
	return ret;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	cout << dfs(1) - 1;


	return 0;
}