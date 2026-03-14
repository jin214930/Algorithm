#include <bits/stdc++.h>
using namespace std;

int k, a[2000];
vector<int> ans[10];

void go(int n, int start, int sz) {
	ans[n].push_back(a[start + sz / 2]);
	if (sz == 1)
		return;
	go(n + 1, start, sz / 2);
	go(n + 1, start + sz / 2 + 1, sz / 2);
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> k;
	int sz = pow(2, k) - 1;
	for (int i = 0; i < sz; i++)
		cin >> a[i];

	go(0, 0, sz);

	for (int i = 0; i < k; i++) {
		for (int j : ans[i])
			cout << j << ' ';
		cout << '\n';
	}

	return 0;
}