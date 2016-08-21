#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <functional>

using namespace std;
struct cmp {
    bool operator()(pair<int, int> pa, pair<int, int> pb) {
        return pa.second > pb.second;
    }
};

int main()
{
    int nodeNum, edgeNum, startNode, u, v, w;
    int here, there, cost, weight;
    int INF = 3000001;

    cin >> nodeNum >> edgeNum >> startNode;

    vector <pair<int, int> > adj[nodeNum + 1];
    vector <int> dist(nodeNum + 1, INF);
    priority_queue <pair<int, int>, vector <pair<int, int> >, cmp > pQue;
    vector <bool> found(nodeNum + 1, false);
    for (int i = 0; i < edgeNum; i++) {
        scanf("%d %d %d", &u, &v, &w);
        adj[u].push_back(make_pair(v, w));
    }

    dist[startNode] = 0;
    pQue.push(make_pair(startNode, 0));
    while (!pQue.empty()) {
        here = pQue.top().first;
        cost = pQue.top().second;
        pQue.pop();
        if (found[here] == false) {
            found[here] = true;
        //ÆËÇÑ°Å¿¡ ´ëÇÏ ¿¬°áµÈ °ÍµéÀ» ºÁ¾ßµÊ
            for (int i = 0; i < adj[here].size(); i++) {
                there = adj[here].at(i).first;
                weight = adj[here].at(i).second;
                if (dist[there] > cost + weight && found[there] == false) {
                    pQue.push(make_pair(there, cost + weight));
                    dist[there] = cost + weight;
                }
            }
        }
    }

    for (int i = 1; i < dist.size(); i++) {
        if (dist.at(i) >= 3000001) {
            printf("%s\n", "INF");
        }
        else {
            printf("%d\n", dist.at(i));
        }
    }

    return 0;
}
