#include <bits/stdc++.h>
using namespace std;

int t, n, m, d[31][31];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i <= 31; i++)
		d[i][0] = 1;

	for (int i = 1; i <= 30; i++) {
		for (int j = 1; j <= i; j++)
			d[i][j] = d[i - 1][j] + d[i - 1][j - 1];
	}

	cin >> t;
	while (t--) {
		cin >> n >> m;
		cout << d[m][n] << '\n';
	}
	

	return 0;
}