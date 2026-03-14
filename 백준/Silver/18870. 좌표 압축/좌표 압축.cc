#include <bits/stdc++.h>
using namespace std;

int n, a[1000000], b[1000000];
map<int, int> mp;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> a[i];
		b[i] = a[i];
	}

	sort(b, b + n);
	
	int idx = 1;
	for (int i = 0; i < n; i++) {
		if (!mp[b[i]])
			mp[b[i]] = idx++;
	}

	for (int i = 0; i < n; i++)
		cout << mp[a[i]] - 1 << ' ';
	



	return 0;
}