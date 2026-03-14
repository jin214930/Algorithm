#include <bits/stdc++.h>
using namespace std;

int n, m, tmp, idx, cnt;
vector<int> a, b;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		a.push_back(tmp);
	}
	for (int i = 0; i < m; i++) {
		cin >> tmp;
		b.push_back(tmp);
	}

	sort(a.begin(), a.end());
	sort(b.begin(), b.end());

	for (int i = 0; i < n; i++) {
		while (idx < m && a[i] > b[idx])
			idx++;
		if (idx >= m)
			break;
		if (a[i] == b[idx])
			cnt++;
	}

	cout << n + m - cnt * 2;	

	return 0;
}