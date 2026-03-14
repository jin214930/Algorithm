#include <bits/stdc++.h>
using namespace std;

int n, a[8], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> a[i];

	sort(a, a + n);
	do {
		int tmp = 0;
		for (int i = 0; i < n - 1; i++)
			tmp += abs(a[i] - a[i + 1]);
		ans = max(ans, tmp);
	} while (next_permutation(a, a + n));	

	cout << ans;

	return 0;
}