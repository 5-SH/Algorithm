#include <iostream>
#include <vector>
#include <utility>
#include <queue>

using namespace std;

struct cmp {
    bool operator() (pair <int, int> p1, pair <int, int> p2) {
        if (p1.second != p2.second) {
            return p1.second < p2.second;
        }
        else {
            return p1.first > p2.first;
        }
    }
};

void dfs (int vertex, int& hacked, vector<int>* adj, vector<bool>& visited) {
    visited[vertex] = true;
    hacked++;
    for (int i = 0; i < adj[vertex].size(); i++) {
        if (!visited[adj[vertex].at(i)]) {
            dfs (adj[vertex].at(i), hacked, adj, visited);
        }
    }
}



int main()
{
    int vSize, eSize, hacked = 0;
    int v1, v2;
    int pQSize, maxHacked;
    cin >> vSize >> eSize;

    vector <int> adj[vSize + 1];
    vector <bool> visited(vSize + 1, false);
    priority_queue <pair <int, int>, vector <pair <int, int> >, cmp > pQ;

    for (int i = 0; i < eSize; i++) {
        scanf("%d %d", &v1, &v2);
        adj[v2].push_back(v1);
    }

    for (int i = 1; i <= vSize; i++) {
        dfs(i, hacked, adj, visited);
        pQ.push(make_pair(i, hacked));

        visited.clear();
        visited.assign(vSize + 1, false);
        hacked = 0;
    }
    pQSize = pQ.size();
    maxHacked = pQ.top().second;
    for (int i = 0; i < pQSize; i++) {
        if (maxHacked == pQ.top().second) {
             printf("%d ", pQ.top().first);
             pQ.pop();
        }
        else {
            break;
        }
    }
    return 0;
}
