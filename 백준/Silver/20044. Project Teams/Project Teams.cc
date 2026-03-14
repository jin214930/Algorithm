#include <bits/stdc++.h>
using namespace std;

int n, a[10000], ans = 999999999;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < 2 * n; i++)
		cin >> a[i];
	sort(a, a + 2 * n);
	for (int i = 0; i < n; i++)
		ans = min(ans, a[i] + a[2 * n - i - 1]);
	cout << ans;


	
	return 0;
}