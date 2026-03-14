#include <bits/stdc++.h>
using namespace std;

long long n, m, a[1000000], ans;

bool check(int mid) {
	long long cnt = 0;
	for (int i = 0; i < n; i++)
		cnt += a[i] / mid;
	
	return cnt >= m;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> m >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];

	sort(a, a + n);
	
	long long start = 1;
	long long end = a[n - 1];
	while (start <= end) {
		long long mid = (start + end) / 2;
		if (check(mid)) {
			ans = mid;
			start = mid + 1;
		}
		else
			end = mid - 1;
	}

	cout << ans;

	return 0;
}