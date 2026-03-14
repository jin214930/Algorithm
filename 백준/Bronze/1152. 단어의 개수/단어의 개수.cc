#include <bits/stdc++.h>
using namespace std;

int cnt;
string s;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	getline(cin, s);
	s += ' ';
	bool isWord = false;
	for (char c : s) {
		if (c != ' ')
			isWord = true;
		else {
			if (isWord) {
				cnt++;
				isWord = false;
			}
		}
	}

	cout << cnt;

	return 0;
}