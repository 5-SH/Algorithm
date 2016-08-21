#include <iostream>
#include <utility>
#include <math.h>
#include <queue>

using namespace std;

typedef pair <int, int> Open;

int dp[21][21][21];
int checkList[22];
int mSize;
int findAns(Open open, int countNum) {
    if (countNum == mSize) return 0;
    int cur = checkList[countNum];

    int& ret = dp[open.first][open.second][countNum];
    if (ret != 0) return ret;
    ret = min(findAns(make_pair(cur, open.second), countNum + 1) + abs(open.first - cur),
            findAns(make_pair(open.first, cur), countNum + 1) + abs(open.second - cur));

    return ret;
}

int main()
{
    int fNum, fUse, open1, open2;
    Open open;
    scanf("%d", &fNum);
    scanf("%d %d", &open1, &open2);
    scanf("%d", &mSize);
    open = make_pair(open1, open2);

    for (int i = 0; i < mSize; i++) {
        scanf("%d", &fUse);
        checkList[i] = fUse;
    }

    printf("%d\n", findAns(open, 0));

    return 0;
}
