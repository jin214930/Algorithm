#include <bits/stdc++.h>
using namespace std;

int a[8], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	for (int i = 0; i < 8; i++)
		cin >> a[i];
	for (int i = 0; i < 8; i++) {
		int sum = 0;
		for (int j = 0; j < 4; j++) {
			sum += a[(i + j) % 8];
		}
		ans = max(ans, sum);
	}

	cout << ans;

	return 0;
}