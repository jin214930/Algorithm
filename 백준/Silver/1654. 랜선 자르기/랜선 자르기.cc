#include <bits/stdc++.h>
using namespace std;

long long k, n, a[10000], ans;

bool check(int m) {
	long long sum = 0;
	for (int i = 0; i < k; i++) 
		sum += a[i] / m;
	return sum >= n;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> k >> n;
	for (int i = 0; i < k; i++) 
		cin >> a[i];

	sort(a, a + k);
	long long end = a[k - 1];
	long long start = 1;
	while (start <= end) {
		long long mid = (end + start) / 2;
		if (check(mid)) {
			start = mid + 1;
			ans = max(ans, mid);
		}
		else
			end = mid - 1;
	}

	cout << ans;

	return 0;
}