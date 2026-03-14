#include <bits/stdc++.h>
using namespace std;

int n, d[100001][2], a[100001], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];

	ans = a[1];
	d[1][0] = d[1][1] = a[1];
	for (int i = 2; i <= n; i++) {
		d[i][0] = max(d[i - 1][0] + a[i], a[i]);
		d[i][1] = max(d[i - 1][0], d[i - 1][1] + a[i]);
		ans = max({ ans, d[i][0], d[i][1] });
	}

	cout << ans;

	return 0;
}