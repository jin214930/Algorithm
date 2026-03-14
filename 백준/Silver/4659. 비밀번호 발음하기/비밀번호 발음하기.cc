#include <bits/stdc++.h>
using namespace std;

string s;

bool isVowel(char c) {
	return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

bool check(string s) {
	bool flag = false;
	for (char c : s) {
		if (isVowel(c))
			flag = true;
	}

	if (s.size() >= 3) {
		for (int i = 0; i < s.size() - 2; i++) {
			if ((isVowel(s[i]) && isVowel(s[i + 1]) && isVowel(s[i + 2])) || (!isVowel(s[i]) && !isVowel(s[i + 1]) && !isVowel(s[i + 2])))
				flag = false;
		}
	}

	if (s.size() >= 2) {
		for (int i = 0; i < s.size() - 1; i++) {
			if (s[i] == s[i + 1] && s[i] != 'e' && s[i] != 'o')
				flag = false;
		}
	}

	return flag;		
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (cin >> s) {
		if (s == "end")
			break;
		
		cout << "<" << s << "> is ";
		if (!check(s))
			cout << "not ";
		cout << "acceptable.\n";
	}

	return 0;
}