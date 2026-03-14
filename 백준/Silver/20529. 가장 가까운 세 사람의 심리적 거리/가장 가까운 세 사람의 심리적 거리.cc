#include <bits/stdc++.h>
using namespace std;

int t, n, ans = 999999999;
string s;
string a[16] = { "ISTJ", "ISFJ", "INFJ", "INTJ", "ISTP", "ISFP", "INFP", "INTP",
"ESTP", "ESFP", "ENTP", "ESTJ", "ESFJ", "ENFJ", "ENTJ", "ENFP"};
map<string, int> mp;

int cal(string a, string b) {
	int ret = 0;
	for (int i = 0; i < 4; i++) {
		if (a[i] != b[i])
			ret++;
	}
	return ret;
}

void go(int start, vector<string> v) {
	if (v.size() == 3) {
		ans = min(ans, cal(v[0], v[1]) + cal(v[1], v[2]) + cal(v[0], v[2]));
		return;
	}

	for (int i = start; i < 16; i++) {
		if (!mp[a[i]])
			continue;
		mp[a[i]]--;
		v.push_back(a[i]);
		go(i, v);
		mp[a[i]]++;
		v.pop_back();
	}

}


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		ans = 999999999;
		mp.clear();
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> s;
			mp[s]++;
		}		

		vector<string> tmp;
		go(0, tmp);
		
		cout << ans << '\n';
	}


	

	return 0;
}