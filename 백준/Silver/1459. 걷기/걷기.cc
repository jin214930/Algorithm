#include <bits/stdc++.h>
using namespace std;

long long x, y, w, s, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> x >> y >> w >> s;
	if (x < y)
		swap(x, y);

	if (s < w) {
		ans = (x - 1) * s;
		if ((x - y) % 2)
			ans += w;
		else
			ans += s;
	}
	else if (s < 2 * w)
		ans = y * s + (x - y) * w;
	else
		ans = (x + y) * w;

	cout << ans;

	return 0;
}