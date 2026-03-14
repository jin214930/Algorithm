#include <bits/stdc++.h>
using namespace std;

int a, b, c, x, y, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b >> c >> x >> y;
	ans = a * x + b * y;
	for (int i = 1; i <= max(x, y); i++) 
		ans = min(ans, a * max(0, x - i) + b * max(0, y - i) + 2 * c * i);

	cout << ans;

	return 0;
}