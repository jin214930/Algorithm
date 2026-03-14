#include <bits/stdc++.h>
using namespace std;

string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> s;

	int i = 0;
	while (i < s.size()) {
		if (s[i] == 'p') {
			if (s.substr(i, 2) == "pi")
				i += 2;
			else
				break;
		}
		else if (s[i] == 'k') {
			if (s.substr(i, 2) == "ka")
				i += 2;
			else
				break;
		}
		else if (s[i] == 'c') {
			if (s.substr(i, 3) == "chu")
				i += 3;
			else
				break;
		}
		else
			break;
	}

	if (i == s.size())
		cout << "YES";
	else
		cout << "NO";

	return 0;
}