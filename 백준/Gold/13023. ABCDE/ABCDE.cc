#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, visited[2000];
bool flag;
vector<int> adj[2000];

void dfs(int x, int cnt) {
	if (cnt == 5) {
		flag = true;
		return;
	}

	for (int nx : adj[x]) {
		if (!visited[nx]) {
			visited[nx] = 1;
			dfs(nx, cnt + 1);
			visited[nx] = 0;
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m;
	while (m--) {
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	for (int i = 0; i < n; i++) {
		if (flag)
			break;
		visited[i] = 1;
		dfs(i, 1);
		visited[i] = 0;
	}

	if (flag)
		cout << 1;
	else
		cout << 0;

	return 0;
}