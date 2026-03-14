#include <bits/stdc++.h>
using namespace std;

int n, m, x, a[10], b[10], visited[10], sum, ans = 999999999;
vector<int> adj[10];

void dfs(int x) {
	visited[x] = 1;

	for (int nx : adj[x]) {
		if (!visited[nx] && b[nx] == b[x])
			dfs(nx);
	}
}

bool check(int x) {
	memset(b, 0, sizeof(b));
	memset(visited, 0, sizeof(visited));

	for (int i = 0; i < n; i++) {
		if (x & (1 << i))
			b[i] = 1;
	}

	for (int i = 0; i < n; i++) {
		if (b[i]) {
			dfs(i);
			break;
		}
	}

	bool flag = true;

	for (int i = 0; i < n; i++) {
		if (b[i] && !visited[i]) {
			flag = false;
			break;
		}
	}

	memset(visited, 0, sizeof(visited));

	for (int i = 0; i < n; i++) {
		if (!b[i]) {
			dfs(i);
			break;
		}
	}

	for (int i = 0; i < n; i++) {
		if (!b[i] && !visited[i]) {
			flag = false;
			break;
		}
	}

	return flag;

}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		sum += a[i];
	}

	for (int i = 0; i < n; i++) {
		cin >> m;
		while (m--) {
			cin >> x;
			adj[i].push_back(x - 1);
		}
	}

	for (int i = 0; i < (1 << n); i++) {
		if (check(i)) {
			int tmp = 0;
			for (int j = 0; j < n; j++) {
				if (i & (1 << j))
					tmp += a[j];
			}
			ans = min(ans, abs(sum - 2 * tmp));
		}
	}

	if (ans == 999999999)
		cout << -1;
	else
		cout << ans;

	return 0;
}