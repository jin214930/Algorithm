#include <bits/stdc++.h>
using namespace std;

double a, b;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> a >> b;
	
	cout << fixed;
	cout.precision(9);
	cout << a / b;

	return 0;
}