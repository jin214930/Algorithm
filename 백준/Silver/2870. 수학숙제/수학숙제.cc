#include <bits/stdc++.h>
using namespace std;

int n;
string s;
vector<string> v;

bool cmp(string a, string b) {
	if (a.size() == b.size())
		return a < b;
	return a.size() < b.size();
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	while (n--) {
		cin >> s;
		s += ' ';
		string tmp = "";
		for (char c : s) {
			if (c >= '0' && c <= '9')
				tmp += c;
			else {
				if (tmp.size()) {
					while (tmp.size() && tmp[0] == '0')
						tmp.erase(tmp.begin());
					if (tmp.empty())
						v.push_back("0");
					else
						v.push_back(tmp);
					tmp = "";
				}
				
			}
		}
	}

	sort(v.begin(), v.end(), cmp);

	for (string s : v)
		cout << s << '\n';

	return 0;
}