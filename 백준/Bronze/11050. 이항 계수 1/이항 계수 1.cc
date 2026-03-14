#include <bits/stdc++.h>
using namespace std;

int n, k;

int combi(int n, int k) {
	if (n == k || k == 0)
		return 1;
	return combi(n - 1, k) + combi(n - 1, k - 1);
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> n >> k;
	cout << combi(n, k);

	return 0;
}