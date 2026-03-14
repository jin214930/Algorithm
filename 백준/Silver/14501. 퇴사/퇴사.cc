#include <bits/stdc++.h>
using namespace std;

int n, t[16], p[16], d[16];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> t[i] >> p[i];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (j + t[j] - 1 <= i)
				d[i] = max(d[i], d[j - 1] + p[j]);
		}
	}

	cout << d[n];

	return 0;
}