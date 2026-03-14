#include <bits/stdc++.h>
using namespace std;

int t, n, a[1000000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 0; i < n; i++)
			cin >> a[i];
		sort(a, a + n);
		cout << a[0] << ' ' << a[n - 1] << '\n';
	}

	return 0;
}