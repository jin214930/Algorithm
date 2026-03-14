#include <bits/stdc++.h>
using namespace std;

int n, a[100][100], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	while (n--) {
		int y, x;
		cin >> x >> y;
		for (int i = y; i < y + 10; i++) {
			for (int j = x; j < x + 10; j++)
				a[i][j] = 1;
		}
	}

	for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {
			if (a[i][j])
				ans++;
		}
	}

	cout << ans;


	return 0;
}