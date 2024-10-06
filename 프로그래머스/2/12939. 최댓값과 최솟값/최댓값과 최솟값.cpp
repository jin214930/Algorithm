#include <bits/stdc++.h>

using namespace std;

string solution(string s) {
    string ans = "";
    vector<int> v;
    string tmp = "";
    bool flag = false;
    for(char c : s) {
        if(c == '-')
            flag = true;
        else if(c >= '0' && c <= '9') {
            tmp += c;
        }
        else {
            if(flag)
                v.push_back(atoi(tmp.c_str()) * -1);
            else
                v.push_back(atoi(tmp.c_str()));
            flag = false;
            tmp = "";
        }
    }
    if(flag)
                v.push_back(atoi(tmp.c_str()) * -1);
            else
                v.push_back(atoi(tmp.c_str()));
    
    
    sort(v.begin(), v.end());
    ans += to_string(v[0]);
    ans += ' ';
    ans += to_string(v.back());
    
    return ans;
}