#include <bits/stdc++.h>
using namespace std;

int x, cnt;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> x;

	for (int i = 0; i < 7; i++) {
		if (x & (1 << i))
			cnt++;
	}

	cout << cnt;

	return 0;
}