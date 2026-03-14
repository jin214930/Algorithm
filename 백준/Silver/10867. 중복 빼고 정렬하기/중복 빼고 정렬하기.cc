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
	
	v.erase(unique(v.begin(), v.end()), v.end());
	for (int i : v)
		cout << i << ' ';

	return 0;
}