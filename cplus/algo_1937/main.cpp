#include <iostream>
#include <stack>
#include <tuple>
#include <utility>
#include <algorithm>

using namespace std;

int memoization (int i, int j, int n, int** bamboo, int** dp) {
    if (dp[i][j] != 1) return dp[i][j];

    if (i - 1 >= 0 && bamboo[i - 1][j] > bamboo[i][j]) {
        dp[i][j] = max(dp[i][j], memoization(i - 1, j, n, bamboo, dp) + 1);
    }
    if (i + 1 < n && bamboo[i + 1][j] > bamboo[i][j]) {
        dp[i][j] = max(dp[i][j], memoization(i + 1, j, n, bamboo, dp) + 1);
    }
    if (j - 1 >= 0 && bamboo[i][j - 1] > bamboo[i][j]) {
        dp[i][j] = max(dp[i][j], memoization(i, j - 1, n, bamboo, dp) + 1);
    }
    if (j + 1 < n && bamboo[i][j + 1] > bamboo[i][j]) {
        dp[i][j] = max(dp[i][j], memoization(i, j + 1, n, bamboo, dp) + 1);
    }

    return dp[i][j];
}

int main()
{
    //초기화
    int n, in, maxDay = 0;
    cin >> n;
    int** bamboo = new int* [n];
    int** dp = new int* [n];
    for (int i = 0; i < n; i++) {
        bamboo[i] = new int[n];
        dp[i] = new int[n];
    }

    //입력
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            scanf("%d", &in);
            bamboo[i][j] = in;
            dp[i][j] = 1;
        }
    }

    //dp
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            maxDay = max(memoization(i, j, n, bamboo, dp), maxDay);
        }
    }

    //출력
    cout << maxDay << endl;

    return 0;
}
