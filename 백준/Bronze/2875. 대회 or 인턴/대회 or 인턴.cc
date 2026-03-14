#include <bits/stdc++.h>
using namespace std;

int n, m, k, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> m >> k;
	ans = min(n / 2, m);
	k -= m + n - ans * 3;
	if (k <= 0) {
		cout << ans;
		return 0;
	}
	ans -= k / 3;
	if (k % 3)
		ans--;
	cout << ans;


	return 0;
}