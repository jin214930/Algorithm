#include <bits/stdc++.h>
using namespace std;

int n, a[10][10], d[10], ans = 999999999;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> a[i][j];
			if (a[i][j] == 0)
				a[i][j] = 999999999;
		}
	}

	for (int i = 0; i < n; i++)
		d[i] = i;

	do {
		int tmp = 0;
		for (int i = 0; i < n - 1; i++) 
			tmp += a[d[i]][d[i + 1]];
		tmp += a[d[n - 1]][d[0]];	
		ans = min(ans, tmp);
	} while (next_permutation(d, d + n));

	cout << ans;

	return 0;
}