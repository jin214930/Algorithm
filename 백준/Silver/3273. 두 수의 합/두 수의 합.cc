#include <bits/stdc++.h>
using namespace std;

int n, x, a[100000], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cin >> x;

	sort(a, a + n);

	int l = 0, r = n - 1;

	while (l < r) {
		if (a[l] + a[r] == x) {
			ans++;
			r--;
		}
		else if (a[l] + a[r] < x)
			l++;
		else
			r--;
	}

	cout << ans;

	return 0;
}