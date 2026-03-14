#include <bits/stdc++.h>
using namespace std;

int n, visited[100001], parent[100001];
vector<int> adj[100001];
queue<int> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n - 1; i++) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}

	q.push(1);
	visited[1] = 1;
	parent[1] = -1;
	while (q.size()) {
		int x = q.front();
		q.pop();
		for (int nx : adj[x]) {
			if (!visited[nx]) {
				q.push(nx);
				visited[nx] = 1;
				parent[nx] = x;
			}
		}
	}

	for (int i = 2; i <= n; i++)
		cout << parent[i] << '\n';

	return 0;
}