#include <bits/stdc++.h>
using namespace std;

int n, m, b[10], c = 100, s, ans;

int ok(int n) {
	int cnt = 0;
	if (n == 0 && !b[n])
		return 1;
	while (n) {
		if (b[n % 10])
			return 0;
		n /= 10;
		cnt++;
	}
	return cnt;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < m; i++) {
		int tmp;
		cin >> tmp;
		b[tmp] = 1;
	}

	ans = abs(n - c);

	s = ok(n);
	if (s)
		ans = min(ans, s);

	for (int i = 1; i <= 500000; i++) {
		s = ok(i + n);
		if (s) 
			ans = min(ans, s + i);
		if (n - i >= 0) {
			s = ok(n - i);
			if (s)
				ans = min(ans, s + i);
		}
	}

	cout << ans;

	return 0;
}