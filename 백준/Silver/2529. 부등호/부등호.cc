#include <bits/stdc++.h>
using namespace std;

int k, visited[10];
vector<string> ans;
char a[9];

bool check(string s) {
	for (int i = 0; i < k; i++) {
		if (a[i] == '<' && s[i] > s[i + 1])
			return false;
		if (a[i] == '>' && s[i] < s[i + 1])
			return false;
	}

	return true;
}

void go(string s) {
	if (s.size() == k + 1 && check(s)) {
		ans.push_back(s);
		return;
	}

	for (int i = 0; i < 10; i++) {
		if (!visited[i]) {
			visited[i] = 1;
			s += '0' + i;
			go(s);
			visited[i] = 0;
			s.pop_back();
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> k;
	for (int i = 0; i < k; i++)
		cin >> a[i];

	go("");

	cout << ans[ans.size() - 1] << '\n' << ans[0];

	return 0;
}