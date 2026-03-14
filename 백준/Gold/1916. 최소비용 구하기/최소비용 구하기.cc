#include <bits/stdc++.h>
using namespace std;

int n, m, a, b, c, visited[1001], d[1001];
vector<pair<int, int>> adj[1001];

void go(int start) {
	priority_queue<pair<int, int>> pq;
	pq.push({ 0, start });
	d[start] = 0;

	while (!pq.empty()) {
		int dist = -pq.top().first;
		int x = pq.top().second;
		pq.pop();

		if (d[x] < dist)
			continue;

		for (auto nx : adj[x]) {
			int cost = dist + nx.second;
			if (cost < d[nx.first]) {
				d[nx.first] = cost;
				pq.push({ -cost, nx.first });
			}
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
		cin >> a >> b >> c;
		adj[a].push_back({ b, c });
	}

	fill(d, d + 1001, 999999999);

	cin >> a >> b;

	go(a);
	cout << d[b];


	return 0;
}