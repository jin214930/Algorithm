#include <bits/stdc++.h>
using namespace std;

long long s, c, a[1000000], sum, ans;

bool check(long long mid) {
	long long cnt = 0;
	for (int i = 0; i < s; i++) 
		cnt += a[i] / mid;
	return cnt >= c;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s >> c;
	for (int i = 0; i < s; i++) {
		cin >> a[i];
		sum += a[i];
	}

	long long start = 1;
	long long end = 1000000000;

	while (start <= end) {
		long long mid = (start + end) / 2;
		if (check(mid)) {
			start = mid + 1;
			ans = mid;
		}
		else
			end = mid - 1;
	}
	
	cout << sum - c * ans;

	return 0;
}