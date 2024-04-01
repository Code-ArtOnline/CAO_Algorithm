#include <iostream>
#include <algorithm>

using namespace std;

int main(){
    
    int N;
    cin >> N; 

    int a[N+1] = {0,};
    for (int i=1; i<=N; i++)
        cin >> a[i]; 

    long long DP[N+1]; 
    DP[0] = 0; 
    DP[1] = a[1];
    DP[2] = a[1] + a[2];

    for (int i=3; i<=N; i++){
        DP[i] = max({DP[i-3]+a[i-1]+a[i], DP[i-2]+a[i], DP[i-1]});
    }

    cout << DP[N] << endl;
    

    return 0;
}