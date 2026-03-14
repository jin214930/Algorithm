#include <bits/stdc++.h>
using namespace std;

long long ans, n;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 1; i <= n; i++) 
		ans += i * (n / i);
	
	cout << ans;
	

	return 0;
}