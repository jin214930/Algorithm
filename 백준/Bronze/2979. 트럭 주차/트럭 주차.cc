#include <bits/stdc++.h>
using namespace std;

int cnt[100], a[4], s, e, ans;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 1; i < 4; i++)
		cin >> a[i];

	for (int i = 0; i < 3; i++) {
		cin >> s >> e;
		for (int j = s; j < e; j++)
			cnt[j]++;
	}

	for (int i = 0; i < 100; i++)
		ans += cnt[i] * a[cnt[i]];

	cout << ans;
	
	return 0;
}