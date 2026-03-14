#include <bits/stdc++.h>
using namespace std;

int n, m, k, a, b, c, d[50001];
vector<pair<int, int>> adj[50001];

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
		adj[b].push_back({ a, c });
	}

	fill(d, d + 50001, 999999999);

	go(1);
	cout << d[n];


	return 0;
}