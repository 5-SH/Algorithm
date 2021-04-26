#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

long long int dpArr[500][500];
int inputArr[500];

long long int cal (int startPos, int endPos) {
    if (startPos == endPos) {
        return 0;
    }

    if (dpArr[startPos][endPos] != 72340172838076673) {
        //cout << startPos << ", " << endPos << "  " << dpArr[startPos][endPos] << endl;
        return dpArr[startPos][endPos];
    }

    for (int i = 0; i < endPos - startPos; i++) {
        if (startPos != 0)
            dpArr[startPos][endPos] = min(dpArr[startPos][endPos], cal(startPos, startPos + i) + cal(startPos + i + 1, endPos) + inputArr[endPos] - inputArr[startPos - 1]);
        else
            dpArr[startPos][endPos] = min(dpArr[startPos][endPos], cal(startPos, startPos + i) + cal(startPos + i + 1, endPos) + inputArr[endPos]);
    }

    //cout << startPos << ", " << endPos << "  " << dpArr[startPos][endPos] << endl;
    return dpArr[startPos][endPos];
}

int main()
{
    int inputSize = 0, testSize = 0, calVal = 0;

    scanf("%d", &testSize);
    long long int *ans = new long long int[testSize];

    for (int i = 0; i < testSize; i++) {
        scanf("%d", &inputSize);

        for (int j = 0; j < inputSize; j++) {
            scanf("%d", &inputArr[j]);
        }

        for (int j = 0; j < inputSize - 1; j++) {
            inputArr[j + 1] += inputArr[j];
        }

        memset(dpArr, 1, sizeof(dpArr));
        ans[i] = cal(0, inputSize - 1);
        //printf("%d\n", cal(0, inputSize - 1));

    }

    for (int i = 0; i < testSize; i++) {
        printf("%lld\n", ans[i]);
    }
    return 0;
}

