#include <bits/stdc++.h>
using namespace std;

int n, a[] = { 500, 100, 50, 10, 5, 1 }, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	n = 1000 - n;
	int i = 0;
	while (n) {
		ans += n / a[i];
		n %= a[i];
		i++;
	}

	cout << ans;

	
	return 0;
}