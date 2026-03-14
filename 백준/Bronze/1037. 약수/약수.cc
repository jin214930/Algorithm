#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> v;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		v.push_back(tmp);
	}

	sort(v.begin(), v.end());

	if (v.size() >= 2)
		cout << v[0] * v[n - 1];
	else
		cout << v[0] * v[0];
	

	return 0;
}