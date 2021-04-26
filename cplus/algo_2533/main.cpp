#include <iostream>
#include <vector>
#include <string.h>
#include <algorithm>
#include <queue>

using namespace std;

int main()
{
    int u, v, n, root = -1, here;
    cin >> n;
    if (n == 2) {
        cout << 1 << endl;
        return 0;
    }
    int dp[n + 1][2];
    vector <int> sns[n + 1];
    int degree[n + 1];
    bool visited[n + 1];
    queue <int> que;
    for (int i = 0; i <= n; i++) {
        dp[i][1] = 1;
        dp[i][0] = 0;
        visited[i] = false;
        degree[i] = 0;
    }
    for (int i = 0; i < n - 1; i++) {
        scanf("%d %d", &u, &v);
        sns[u].push_back(v);
        sns[v].push_back(u);
        degree[u]++;
        degree[v]++;
    }
    for (int i = 0; i <= n; i++) {
        if (degree[i] == 1) {
            que.push(i);
            root = i;
        }
    }
    while (!que.empty()) {
        here = que.front(); que.pop();
        visited[here] = true;
        for (int i = 0; i < (int)sns[here].size(); i++) {
            if (visited[sns[here][i]]) continue;
            dp[sns[here][i]][0] += dp[here][1];
            dp[sns[here][i]][1] += min(dp[here][1], dp[here][0]);
            degree[sns[here][i]]--;
            if (degree[sns[here][i]] == 1) {
                que.push(sns[here][i]);
                root = sns[here][i];
            }
        }
    }

    cout << min(dp[root][0], dp[root][1]) << endl;

    return 0;
}
