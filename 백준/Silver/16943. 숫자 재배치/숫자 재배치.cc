#include <bits/stdc++.h>
using namespace std;

string a, b;
int ans = -1;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;
	sort(a.begin(), a.end());

	do {
		if (a[0] != '0' && stoi(a) < stoi(b)) 
			ans = max(ans, stoi(a));	
	} while (next_permutation(a.begin(), a.end()));

	cout << ans;

	return 0;
}