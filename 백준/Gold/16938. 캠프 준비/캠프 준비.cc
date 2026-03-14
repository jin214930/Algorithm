#include <bits/stdc++.h>
using namespace std;

int n, l, r, x, a[15], ans;

bool check(int k) {
	int mx = 0;
	int mn = 999999999;
	int sum = 0;
	int cnt = 0;

	for (int i = 0; i < n; i++) {
		if ((1 << i) & k) {
			sum += a[i];
			mx = max(mx, a[i]);
			mn = min(mn, a[i]);
			cnt++;
		}
	}

	return sum >= l && sum <= r && mx - mn >= x && cnt >= 2;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> l >> r >> x;
	for (int i = 0; i < n; i++)
		cin >> a[i];

	for (int i = 1; i < (1 << n); i++) {
		if (check(i)) {
			ans++;
		}
	}

	cout << ans;

	return 0;
}