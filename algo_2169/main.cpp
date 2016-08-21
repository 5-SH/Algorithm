#include <iostream>
#include <utility>
#include <algorithm>

using namespace std;

int n, m;
int minVal = -100*1000*1000;
int mars[1003][1003];
int dp[1003][1003][3];

bool bound(int i, int j) {
    if (i > n || i < 1 || j > m || j < 1)
        return false;
    else
        return true;
}
int explore(int i, int j, int d) {
    //¹æ¹®
    if (dp[i][j][d] != -1) return dp[i][j][d];

    //dp[i][j][d] = minVal;
    if (d == 0 && bound(i, j - 1)) {
        dp[i][j][d] = explore(i, j - 1, d) + mars[i][j];
    }
    if (d == 1 && bound(i - 1, j)) {
        dp[i][j][d] = explore(i - 1, j, d) + mars[i][j];
    }
    if (d == 2 && bound(i, j + 1)) {
        dp[i][j][d] = explore(i, j + 1, d) + mars[i][j];
    }

    return dp[i][j][d];
}

int main()
{
    cin >> n >> m;

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            scanf("%d", &mars[i][j]);
            dp[i][j][0] = dp[i][j][1] = dp[i][j][2] = -1;
        }
    }

    cout << max(explore(1, 1, 0), explore(1, 1, 1)) << endl;

    for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                cout << dp[i][j][0] << " ";
            }cout << endl;
        } cout << endl;
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            cout << dp[i][j][1] << " ";
        }cout << endl;
    }
    return 0;
}
