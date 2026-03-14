#include <bits/stdc++.h>
using namespace std;

int n, ans = 999999999;
char a[20][20];

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

	for (int i = 0; i < (1 << n); i++) {
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				for (int k = 0; k < n; k++) {
					if (a[j][k] == 'T')
						a[j][k] = 'H';
					else
						a[j][k] = 'T';
				}
			}
		}

		int tmp2 = 0;
		for (int j = 0; j < n; j++) {
			int tmp = 0;
			for (int k = 0; k < n; k++) {
				if (a[k][j] == 'T')
					tmp++;
			}
			tmp = min(tmp, n - tmp);
			tmp2 += tmp;
		}
		ans = min(tmp2, ans);

		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				for (int k = 0; k < n; k++) {
					if (a[j][k] == 'T')
						a[j][k] = 'H';
					else
						a[j][k] = 'T';
				}
			}
		}
	}

	cout << ans;

	return 0;
}