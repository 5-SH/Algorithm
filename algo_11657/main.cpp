#include <iostream>
#include <vector>
#include <utility>

using namespace std;

int main()
{
    int INF = 60000000;
    int vNum, eNum, a, b, c, there, weight;
    bool relaxed = true;

    cin >> vNum >> eNum;

    vector <pair<int, int> > adj[vNum + 1];
    vector <int> upper (vNum + 1, INF);

    for (int i = 0; i < eNum; i++) {
        scanf("%d %d %d", &a, &b, &c);
        adj[a].push_back(make_pair(b, c));
    }

    upper[1] = 0;
    for (int i = 0; i < vNum; i++) {
        relaxed = false;
        for (int here = 1; here < vNum + 1; here++) {
            for (int j = 0; j < adj[here].size(); j++) {
                there = adj[here].at(j).first;
                weight = adj[here].at(j).second;
                if (upper[there] > upper[here] + weight) {
                    upper[there] = upper[here] + weight;
                    relaxed = true;
                }
            }
        }
        if (!relaxed) break;
    }

    if (relaxed) cout << -1 << endl;
    else {
        for (int i = 2; i < vNum + 1; i++) {
            if (upper[i] < INF - 50000)
               cout << upper[i] << endl;
            else
                cout << -1 << endl;
        }

    }

    return 0;
}
