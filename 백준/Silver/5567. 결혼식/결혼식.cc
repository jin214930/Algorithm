#include <bits/stdc++.h>
using namespace std;

int n, m, visited[501], ans;
vector<int> adj[501];



int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	while (m--) {
		int a, b;
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
		
	queue<int> q;
	q.push(1);
	visited[1] = 1;
	while (q.size()) {
		int x = q.front();
		q.pop();
		for (int nx : adj[x]) {
			if (!visited[nx]) {
				visited[nx] = visited[x] + 1;
				if (visited[nx] <= 3)
					ans++;
				q.push(nx);
			}
		}
	}

	cout << ans;

	return 0;
}