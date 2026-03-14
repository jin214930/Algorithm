#include <bits/stdc++.h>
using namespace std;

long long a, b, ans = 999999999;
queue<pair<long long, long long>> q;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;

	q.push({a, 0});
	while (q.size()) {
		long long x, y;
		tie(x, y) = q.front();
		q.pop();
		if (x == b)
			ans = min(ans, y);
		for (long long i : {2 * x, 10 * x + 1}) {
			if (i <= b) 
				q.push({ i, y + 1 });
		}
	}
	if (ans == 999999999)
		cout << -1;
	else
		cout << ans + 1;

	return 0;
}