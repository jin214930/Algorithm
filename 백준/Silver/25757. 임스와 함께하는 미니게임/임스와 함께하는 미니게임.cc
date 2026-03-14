#include <bits/stdc++.h>
using namespace std;

int n, tmp;
char c;
set<string> s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> c;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		s.insert(str);
	}

	if (c == 'Y')
		tmp = 1;
	else if (c == 'F')
		tmp = 2;
	else
		tmp = 3;
	cout << s.size() / tmp;

	return 0;
}