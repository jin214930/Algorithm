#include <bits/stdc++.h>
using namespace std;

int n, a[2000001];

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	
	a[1] = 1;
	for (int i = 2; i <= 2000000; i++) {
		if (!a[i]) {
			for (int j = i * 2; j <= 2000000; j += i)
				a[j] = 1;
		}
	}

	for (int i = n; i <= 2000000; i++) {
		if (!a[i]) {
			string s = to_string(i);
			string tmp = s;
			reverse(tmp.begin(), tmp.end());
			if (tmp == s) {
				cout << i;
				return 0;
			}
		}
	}


	return 0;
}