#include <bits/stdc++.h>
using namespace std;

int n, k;
int d[1001][1001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> k;
	d[1][0] = 1;
	d[1][1] = 1;
	for (int i = 2; i <= n; i++) {
		for (int j = 0; j <= k; j++) {
			if (j == 0)
				d[i][j] = 1;
			else
				d[i][j] = (d[i - 1][j] + d[i - 1][j - 1]) % 10007;
		}
	}

	cout << d[n][k];

	return 0;
}