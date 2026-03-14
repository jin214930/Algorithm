#include <bits/stdc++.h>
using namespace std;

int n, a[301], d[301][2];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> a[i];

	d[1][0] = a[1];
	d[2][0] = a[2];
	d[2][1] = a[1] + a[2];
	for (int i = 3; i <= n; i++) {
		d[i][0] = a[i] + max(d[i - 2][0], d[i - 2][1]);
		d[i][1] = a[i] + d[i - 1][0];
	}

	cout << max(d[n][0], d[n][1]);


	return 0;
}