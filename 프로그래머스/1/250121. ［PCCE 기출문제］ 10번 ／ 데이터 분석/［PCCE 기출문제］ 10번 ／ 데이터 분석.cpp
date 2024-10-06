#include <string>
#include <vector>
#include <algorithm>
using namespace std;

int tmp;

bool cmp(vector<int> a, vector<int> b) {
    return a[tmp] < b[tmp];
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    if(ext == "code")
    tmp  = 0;
    else if (ext == "date")
    tmp = 1;
    else if (ext == "maximum")
    tmp = 2;
    else
    tmp = 3;
    
    for(auto i : data) {
        if(i[tmp] < val_ext)
            answer.push_back(i);
    }
    
    if(sort_by == "code")
    tmp  = 0;
    else if (sort_by == "date")
    tmp = 1;
    else if (sort_by == "maximum")
    tmp = 2;
    else
    tmp = 3;
    
    sort(answer.begin(), answer.end(), cmp);
    
    return answer;
}