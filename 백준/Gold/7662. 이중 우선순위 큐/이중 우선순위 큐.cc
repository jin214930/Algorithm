#include <bits/stdc++.h>
using namespace std;

int t, k, n;
char c;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> t;
	while (t--) {
		multiset<int> ms;
		cin >> k;
		for (int i = 0; i < k; i++) {
			cin >> c >> n;
			if (c == 'I')
				ms.insert(n);
			else {
				if (n == 1 && ms.size())
					ms.erase(--ms.end());
				if (n == -1 && ms.size())
					ms.erase(ms.begin());
			}
		}
		if (ms.size())
			cout << *(--ms.end()) << ' ' << *ms.begin() << '\n';
		else
			cout << "EMPTY\n";
	}
	

	

	

	return 0;
}