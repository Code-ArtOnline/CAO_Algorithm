#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main() {
	int n, k;
	cin >> n >> k;
	vector<int> v;
    
	for(int i = 0; i < n; i++) {
		int x;
		cin >> x;
		v.push_back(x);
	}
    
	sort(v.begin(), v.end());

	set<string> s;
	do {
		string res;
		for(int i = 0; i < k; i++) {
			res += to_string(v[i]);
		} s.insert(res);
	} while(next_permutation(v.begin(), v.end()));
    
	cout << s.size();
}