#include <bits/stdc++.h>
using namespace std;

int n, m, j, x, s, e, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> j;

	s = 1, e = m;

	while (j--) {
		cin >> x;

		if (x < s) {
			ans += s - x;
			s = x;
			e = x + m - 1;
		}
		else if (x > e) {
			ans += x - e;
			e = x;
			s = e - m + 1;
		}
	}

	cout << ans;

	

	return 0;
}