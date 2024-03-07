#include <bits/stdc++.h>
#include <vector>

using namespace std;

int main() {
	int n, m;	
	cin >> n >> m;
	string name;

	vector<string> v(n);	
	vector<string> result;

	for (int i = 0; i < n; i++) {
		cin >> v[i];	
	}

	sort(v.begin(), v.end());	

	for (int i = 0; i < m; i++) {
		cin >> name;	

		if (binary_search(v.begin(), v.end(), name)) {
			result.push_back(name);
		}
	}
    
	sort(result.begin(), result.end());	
	cout << result.size() << "\n";

	for (int i = 0; i < result.size(); i++) {
		cout << result[i] << "\n";
	}
}