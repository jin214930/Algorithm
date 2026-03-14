#include <bits/stdc++.h>
using namespace std;

int n, s, r, a[12], ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> s >> r;
	for (int i = 1; i <= n; i++)
		a[i] = 1;
	for (int i = 0; i < s; i++) {
		int tmp;
		cin >> tmp;
		a[tmp]--;
	}
	for (int i = 0; i < r; i++) {
		int tmp;
		cin >> tmp;
		a[tmp]++;
	}

	for (int i = 1; i <= n; i++) {
		if (!a[i]) {
			if (a[i - 1] == 2) {
				a[i - 1]--;
				a[i]++;
			}
			else if (a[i + 1] == 2) {
				a[i + 1]--;
				a[i]++;
			}
		}
	}

	for (int i = 1; i <= n; i++) {
		if (!a[i])
			ans++;
	}

	cout << ans;

	
	
	return 0;
}