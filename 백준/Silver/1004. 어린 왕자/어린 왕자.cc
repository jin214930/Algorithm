#include <bits/stdc++.h>
using namespace std;

int t, a, b, c, d, n, cx, cy, r;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		int cnt = 0;
		cin >> a >> b >> c >> d >> n;
		for (int i = 0; i < n; i++) {
			cin >> cx >> cy >> r;
			int d1 = (a - cx) * (a - cx) + (b - cy) * (b - cy);
			int d2 = (c - cx) * (c - cx) + (d - cy) * (d - cy);
			if (d1 <= r * r && d2 <= r * r)
				continue;
			else if (d1 <= r * r)
				cnt++;
			else if (d2 <= r * r)
				cnt++;
		}
		cout << cnt << '\n';
	}


	return 0;
}