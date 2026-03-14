#include <bits/stdc++.h>
using namespace std;

string s, p;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s >> p;

	if (strstr(s.c_str(), p.c_str()) != NULL)
		cout << 1;
	else
		cout << 0;

	return 0;
}