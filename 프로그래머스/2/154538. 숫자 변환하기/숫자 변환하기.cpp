#include <string>
#include <vector>
#include <queue>
using namespace std;

int solution(int x, int y, int n)
{
    vector<int> v(1000001,0);
    queue<int> q;
    q.push(x);
    while (!q.empty())
    {
        int cur = q.front(); 
        q.pop();
        if(cur == y){
            return v[cur];
        } 
            
        int dx[3] = {cur + n, cur * 2, cur * 3};
        for(int i = 0; i < 3;i++)
        {
            int next = dx[i];
            if(next > y || v[next]!= 0) 
                continue;
            v[next] = v[cur] + 1;
            q.push(next);
        }
    }
    return -1;
}