#include <bits/stdc++.h>
using namespace std;

int n, s[20], a[2000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> s[i];

	for (int i = 1; i < (1 << n); i++) {
		int sum = 0;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j))
				sum += s[j];
		}
		a[sum] = 1;
	}

	for (int i = 1; i <= 2000000; i++) {
		if (!a[i]) {
			cout << i;
			return 0;
		}
	}


	return 0;
}