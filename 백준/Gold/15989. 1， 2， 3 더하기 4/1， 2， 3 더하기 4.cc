#include <bits/stdc++.h>
using namespace std;

int t, n, d[10001][4];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	d[1][1] = 1;
	d[2][1] = 1;
	d[2][2] = 1;
	d[3][1] = 1;
	d[3][2] = 1;
	d[3][3] = 1;
	for (int i = 4; i <= 10000; i++) {
		d[i][1] = d[i - 1][1];
		d[i][2] = d[i - 2][1] + d[i - 2][2];
		d[i][3] = d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
	}

	cin >> t;
	while (t--) {
		cin >> n;
		cout << d[n][1] + d[n][2] + d[n][3] << '\n';
	}

	return 0;
}