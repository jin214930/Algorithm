#include <bits/stdc++.h>
using namespace std;

int n;
vector<int> ans;
string s;

int cal(int a, int b, char c) {
	if (c == '+')
		return a + b;
	else if (c == '-')
		return a - b;
	else
		return a * b;
}

void go(int k, int ret) {
	if (k == n - 1) {
		ans.push_back(ret);
		return;
	}

	if (k + 2 < n)
		go(k + 2, cal(ret, s[k + 2] - '0', s[k + 1]));
	if (k + 4 < n) 
		go(k + 4, cal(ret, cal(s[k + 2] - '0', s[k + 4] - '0', s[k + 3]), s[k + 1]));
}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> s;
	go(0, s[0] -'0');

	cout << *max_element(ans.begin(), ans.end());
	
	return 0;
}