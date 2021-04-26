#include <iostream>
#include <algorithm>
#include <limits.h>

using namespace std;

int dp[16][1 << 16];
int weight[16][16];
int n;

int tsp(int cur ,int visited) {
    if (visited == (1 << n) - 1) return weight[cur][0];
    int& ret = dp[cur][visited];

    if (ret != 0) return ret;
    ret = 20000000;
    for (int next = 0; next < n; next++) {
        if (visited & (1 << next)) continue;
        if (weight[cur][next] == 0) continue;
        ret = min(ret, tsp(next, visited | (1 << next)) + weight[cur][next]);
    }

    return ret;
}

int main()
{
    cin >> n;
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            scanf("%d", &weight[i][j]);

    cout << tsp(0, 1) << endl;
    return 0;
}
