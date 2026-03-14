#include <bits/stdc++.h>
using namespace std;

int n, a[8];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++)
		a[i] = i + 1;

	do {
		for (int i = 0; i < n; i++)
			cout << a[i] << ' ';
		cout << '\n';
	} while (next_permutation(a, a + n));	

	return 0;
}