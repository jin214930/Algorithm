#include <bits/stdc++.h>
using namespace std;

int n, a[1001], d[1001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
		d[i] = 999999999;
	}

	d[1] = 0;
	for (int i = 2; i <= n; i++) {
		for (int j = 1; j < i; j++) {
			if (j + a[j] >= i) 
				d[i] = min(d[i], d[j] + 1);
		}
	}

	if (d[n] == 999999999)
		cout << -1;
	else
		cout << d[n];

	return 0;
}