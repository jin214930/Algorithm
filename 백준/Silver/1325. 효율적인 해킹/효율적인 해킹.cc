#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, ans, mx, visited[10001], cnt[10001];
vector<int> adj[10001], v;


int dfs(int x) {
	int tmp = 1;
	visited[x] = 1;

	for (int nx : adj[x]) {
		if (!visited[nx])
			tmp += dfs(nx);
	}

	return tmp;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	while (m--) {
		cin >> a >> b;
		adj[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		memset(visited, 0, sizeof(visited));
		cnt[i] = dfs(i);
		mx = max(mx, cnt[i]);
	}

	for (int i = 1; i <= n; i++) {
		if (mx == cnt[i])
			v.push_back(i);
	}
	
	sort(v.begin(), v.end());

	for (int i : v)
		cout << i << ' ';

	return 0;
}