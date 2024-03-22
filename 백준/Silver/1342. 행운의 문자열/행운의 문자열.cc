#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main() {
    string s;
    cin >> s;
    int cnt = 0;

    sort(s.begin(), s.end());

    do {
        bool flag = false;
        for(int i = 1; i < s.size(); i++) {
            if(s[i - 1] == s[i]) {
                flag = true;
                break;
            }
        }
        
        if(!flag) {
            cnt++;
        }
        
    }while(next_permutation(s.begin(), s.end()));
    cout << cnt;
    return 0;
}
