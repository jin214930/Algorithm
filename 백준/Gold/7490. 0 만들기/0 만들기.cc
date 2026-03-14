#include <bits/stdc++.h>
using namespace std;

int t, n;
bool flag;
vector<string> ans;

bool check(string s) {
	int sum = 0;
	int tmp = 0;
	flag = false;
	for (char c : s) {
		if (c >= '1' && c <= '9')
			tmp += c - '0';
		else if (c == ' ')
			tmp *= 10;
		else if (c == '+') {
			if (flag)
				sum -= tmp;
			else
				sum += tmp;
			flag = false;
			tmp = 0;
		}
		else {
			if (flag)
				sum -= tmp;
			else
				sum += tmp;
			flag = true;
			tmp = 0;
		}
	}
	if (flag)
		sum -= tmp;
	else
		sum += tmp;
	return sum == 0;
}

void go(int k, string s) {
	if (k == n) {
		s += '0' + k;
		if (check(s)) 
			ans.push_back(s);
		return;
	}
	s += '0' + k;
	go(k + 1, s + '+');
	go(k + 1, s + ' ');
	go(k + 1, s + '-');
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		cin >> n;
		ans.clear();
		go(1, "");
		sort(ans.begin(), ans.end());

		for (string s : ans)
			cout << s << '\n';

		cout << '\n';
	}


	return 0;
}