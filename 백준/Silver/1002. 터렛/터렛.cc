#include <bits/stdc++.h>
using namespace std;

int t, a, b, r1, c, d, r2;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		cin >> a >> b >> r1 >> c >> d >> r2;
		int x = (a - c) * (a - c) + (b - d) * (b - d);
		if (a == c && b == d && r1 == r2) {
			cout << -1 << '\n';
			continue;
		}
		if (x > (r1 + r2) * (r1 + r2) || x < (r1 - r2) * (r1 - r2))
			cout << 0 << '\n';
		else if (x == (r1 + r2) * (r1 + r2) || x == (r1 - r2) * (r1 - r2))
			cout << 1 << '\n';
		else
			cout << 2 << '\n';
	}


	return 0;
}