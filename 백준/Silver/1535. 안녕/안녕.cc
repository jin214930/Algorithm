#include <bits/stdc++.h>
using namespace std;

int n, a[20], b[20], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	for (int i = 0; i < n; i++)
		cin >> b[i];

	for (int i = 0; i < (1 << n); i++) {
		int sum1 = 0, sum2 = 0;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j)) {
				sum1 += a[j];
				sum2 += b[j];
			}
		}
		if (sum1 < 100)
			ans = max(ans, sum2);
	}

	cout << ans;

	return 0;
}