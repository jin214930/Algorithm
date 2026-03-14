#include <bits/stdc++.h>
using namespace std;

int n, x, root, cnt, visited[50];
vector<int> adj[50];

void dfs(int n) {
	int tmp = 0;
	visited[n] = 1;

	for (int v : adj[n]) {
		if (!visited[v] && v != x) {
			dfs(v);
			tmp++;
		}
	}

	if (tmp == 0)
		cnt++;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> x;
		if (x == -1)
			root = i;
		else
			adj[x].push_back(i);
	}

	cin >> x;

	if (x == root) {
		cout << 0;
		return 0;
	}

	dfs(root);

	cout << cnt;

	return 0;
}