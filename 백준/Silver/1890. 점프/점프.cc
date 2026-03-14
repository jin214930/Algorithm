#include <bits/stdc++.h>
using namespace std;

long long n, a[100][100], d[100][100];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) 
			cin >> a[i][j];
	}

	d[0][0] = 1;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (!a[i][j])
				continue;
			if (i + a[i][j] < n)
				d[i + a[i][j]][j] += d[i][j];
			if (j + a[i][j] < n)
				d[i][j + a[i][j]] += d[i][j];
		}
	}

	cout << d[n - 1][n - 1];

	return 0;
}