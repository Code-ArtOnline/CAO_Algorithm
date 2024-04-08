#include <string>
#include <vector>
#include <algorithm>

using namespace std;
bool compare(int &a, int &b) {
    return a > b;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    vector<int> size(10000001);
    
    for(int x : tangerine){
        size[x]++;
    }
    
    sort(size.begin(), size.end(),compare);
    
    for (int i=0; i<size.size(); i++) {
        if (size[i] < k) {
            answer++; 
            k -= size[i]; 
        } else if (size[i] >= k) {
            answer++;
            break;
        }
    }
    
    return answer;
}