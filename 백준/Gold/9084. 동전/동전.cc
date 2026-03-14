#include <bits/stdc++.h>
using namespace std;

int t, n, m, a[20], d[10001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		memset(d, 0, sizeof(d));
		cin >> n;
		for (int i = 0; i < n; i++)
			cin >> a[i];
		cin >> m;

		d[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = a[i]; j <= m; j++)
				d[j] += d[j - a[i]];
		}

		cout << d[m] << '\n';
	}


	return 0;
}