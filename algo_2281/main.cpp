#include <iostream>
#include <algorithm>

using namespace std;

int dp[1001][1001];
int nameIn[1001];
int n, m;

int squar(int i) {
    return i * i;
}

int note(int i, int j) {
    if (i == n + 1) return 0;
    if (j >= m) {
        if (j == m)
            return note(i + 1, nameIn[i] + 1) + 1;
        else
            return note(i + 1, nameIn[i] + 1);
    }
    if (dp[i][j] != -1) return dp[i][j];

    dp[i][j] = squar(m - j + 1) + note(i + 1, nameIn[i] + 1);
    if (j + nameIn[i] <= m) {
        dp[i][j] = min(dp[i][j], note(i + 1, j + nameIn[i] + 1));
    }

    return dp[i][j];
}

int main()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++) {
        scanf("%d", &nameIn[i]);
    }

    for (int i = 0; i <= 1000; i++)
        for (int j = 0; j <= 1000; j++)
            dp[i][j] = -1;

    cout << note(2, nameIn[1] + 1) << endl;

    return 0;
}
