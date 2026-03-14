#include <bits/stdc++.h>
using namespace std;

int n, s[20][20], ans = 999999999;


int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> s[i][j];
		}
	}


	for (int i = 0; i < (1 << n); i++) {
		vector<int> v1, v2;
		for (int j = 0; j < n; j++) {
			if (i & (1 << j))
				v1.push_back(j);
			else
				v2.push_back(j);
		}
		if (v1.empty() || v2.empty())
			continue;

		int sum1 = 0, sum2 = 0;
		for (int j = 0; j < v1.size() - 1; j++) {
			for (int k = j + 1; k < v1.size(); k++)
				sum1 += s[v1[j]][v1[k]] + s[v1[k]][v1[j]];
		}

		for (int j = 0; j < v2.size() - 1; j++) {
			for (int k = j + 1; k < v2.size(); k++)
				sum2 += s[v2[j]][v2[k]] + s[v2[k]][v2[j]];
		}

		ans = min(ans, abs(sum1 - sum2));
		
	}

	cout << ans;
	
	return 0;
}