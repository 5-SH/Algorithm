#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    int inputArr[1000][3];
    int R[1000];
    int G[1000];
    int B[1000];
    int inputArrSize = 0, ans = 0;

    cin >> inputArrSize;

    scanf("%d %d %d", &inputArr[0][0], &inputArr[0][1], &inputArr[0][2]);
    R[0] = inputArr[0][0];
    G[0] = inputArr[0][1];
    B[0] = inputArr[0][2];

    for (int i = 1; i < inputArrSize; i++) {
        scanf("%d %d %d", &inputArr[i][0], &inputArr[i][1], &inputArr[i][2]);
        R[i] = min(G[i - 1], B[i - 1]) + inputArr[i][0];
        G[i] = min(R[i - 1], B[i - 1]) + inputArr[i][1];
        B[i] = min(R[i - 1], G[i - 1]) + inputArr[i][2];
    }

    ans = min(R[inputArrSize - 1], min(G[inputArrSize - 1], B[inputArrSize - 1]));
    printf("%d", ans);

    return 0;
}
