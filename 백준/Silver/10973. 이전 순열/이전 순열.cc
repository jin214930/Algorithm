#include <bits/stdc++.h>
using namespace std;

int n, a[10000], b[10000];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}

	bool flag = true;
	for (int i = 0; i < n - 1; i++) {
		if (a[i] > a[i + 1])
			flag = false;
	}

	if (flag) {
		cout << -1;
		return 0;
	}

	prev_permutation(a, a + n);

	for (int i = 0; i < n; i++)
		cout << a[i] << ' ';

	return 0;
}