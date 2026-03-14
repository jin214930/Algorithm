#include <bits/stdc++.h>
using namespace std;

int n, k, visited[200001], ans1, ans2;
queue<pair<int, int>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;

	if (n == k) {
		cout << 0 << '\n' << 1;
		return 0;
	}

	visited[n] = 1;
	q.push({n, 0});

	while (q.size()) {
		int x, d;
		tie(x, d) = q.front();
		q.pop();

		visited[x] = 1;

		if (!ans1 && x == k) {
			ans1 = d;
			ans2++;
		}

		else if (ans1 == d && x == k)
			ans2++;

		for (int nx : {x - 1, x + 1, 2 * x}) {
			if (nx < 0 || nx > 200000 || visited[nx])
				continue;
			q.push({ nx, d + 1 });
		}
	}

	cout << ans1 << '\n' << ans2;

	
	return 0;
}