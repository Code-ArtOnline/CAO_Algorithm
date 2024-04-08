#include<iostream>
using namespace std;

int N;
int DP[1000010];
int module = 1e9 + 9;

int main(){
  DP[1] = 1; 
  DP[2] = 2; 
  DP[3] = 4;
  for(int i = 4; i <= 1000000; ++i)
    for(int j = 1; j <= 3; ++j)
      DP[i] = (DP[i] + DP[i-j]) % module;
  
  int T;
  cin >> T;
  while(T--){
    cin >> N;
    cout << DP[N] << endl;
  }
}