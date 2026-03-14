#include <bits/stdc++.h>
using namespace std;

int n, ans1, ans2, dy[] = { 1, 0 }, dx[] = { 0, 1 };
char a[100][100];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cin >> a[i][j];
	}

	for (int i = 0; i < n; i++) {
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			if (a[i][j] == '.')
				cnt++;
			else {
				if (cnt >= 2) 
					ans1++;
				cnt = 0;
			}
		}
		if (cnt >= 2)
			ans1++;
	}

	for (int i = 0; i < n; i++) {
		int cnt = 0;
		for (int j = 0; j < n; j++) {
			if (a[j][i] == '.')
				cnt++;
			else {
				if (cnt >= 2) 
					ans2++;
				cnt = 0;

			}
		}
		if (cnt >= 2) 
			ans2++;
	}

	cout << ans1 << ' ' << ans2;

	return 0;
}