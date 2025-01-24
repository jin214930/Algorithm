#include <bits/stdc++.h>
using namespace std;

int n;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
    
    int tmp = 2;
    while(n != 1) {
        if(n % tmp)
            tmp++;
        else {
            cout << tmp << '\n';
            n /= tmp;
        }
    }
    
	return 0;
}