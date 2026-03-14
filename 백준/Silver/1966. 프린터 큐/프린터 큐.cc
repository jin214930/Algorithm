#include <bits/stdc++.h>
using namespace std;

int t, n, m;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		vector<int> v;
		queue<pair<int, int>> q;
		cin >> n >> m;
		for (int i = 0; i < n; i++) {
			int tmp;
			cin >> tmp;
			v.push_back(tmp);
			q.push({ i, tmp });
		}

		sort(v.rbegin(), v.rend());

		int i = 0;
		while (q.size()) {
			int a, b;
			tie(a, b) = q.front();
			if (b == v[i]) {
				i++;
				q.pop();
				if (a == m) {
					cout << i << '\n';
					break;
				}
			}
			else {
				q.push(q.front());
				q.pop();
			}
		}
	}
	

	return 0;
}