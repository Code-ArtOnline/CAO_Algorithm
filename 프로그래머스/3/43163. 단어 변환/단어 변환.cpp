#include <string>
#include <vector>
#include <queue>
using namespace std;

vector<bool> visited(51, false);

// 현재 문자와 다음 문자가 변환 가능한지 체크하는 함수
bool changeable(string before, string after) {
    int diff = 0;
    for (int i = 0; i < before.size(); i++) {
        if (before[i] != after[i]) 
					diff++;
    }
    return diff == 1;
}

// BFS 함수
int BFS(const string& begin, const string& target, vector<string>& words) {
    queue<pair<string, int>> q;
    q.push({begin, 0});

    while (!q.empty()) {
        string node = q.front().first;
        int index = q.front().second;
        q.pop();

        if (node == target) 
            return index; 

        for (int j = 0; j < words.size(); j++) {
            if (!visited[j] && changeable(node, words[j])) {
                q.push({words[j], index + 1});
                visited[j] = true;
            }
        }
    }
    return 0; 
}

int solution(string begin, string target, vector<string> words) {
    return BFS(begin, target, words);
}
