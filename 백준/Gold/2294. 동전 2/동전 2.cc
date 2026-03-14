#include <bits/stdc++.h>
using namespace std;

int n, m, a[100], d[10001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 1; i <= m; i++)
		d[i] = 999999999;

	sort(a, a + n);
	
	d[0] = 0;
	for (int i = 1; i <= m; i++) {
		for (int j = 0; j < n; j++) {
			if (i - a[j] >= 0)
				d[i] = min(d[i], d[i - a[j]] + 1);
		}
	}

	if (d[m] == 999999999)
		cout << -1;
	else
		cout << d[m];

	return 0;
}