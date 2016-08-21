#include <iostream>
#include "stdio.h"
using namespace std;

int main()
{
    int countNum = 0, pMatch = 0, sQuePointer = 0, j = 0, pLength, sQueLength;
    char sQue[1100000];
    scanf("%d%d%s",&pLength,&sQueLength,sQue);
    if (pLength == 1) pLength = 3;
    else pLength = pLength * 2 + 1;

    while (sQuePointer < sQueLength) {
        if ((j % 2 == 0 && 'I' == sQue[sQuePointer]) || (j % 2 == 1 &&'O' == sQue[sQuePointer])) {
            j++;
            pMatch = pMatch + 1;
            if (pMatch != pLength) {
                sQuePointer++;
            }
        }

        else {
            j = 0;
            if (pMatch == 0)
            {
                sQuePointer++;
            }
            pMatch = 0;
        }

        if (pMatch == pLength) {
            j = 0;
            countNum++;
            pMatch = 0;

            while (sQue[sQuePointer + 1] == 'O' && sQue[sQuePointer + 2] == 'I') {
                countNum++;
                sQuePointer = sQuePointer + 2;
            }
        }
    }

    cout << countNum;
    return 0;
}
