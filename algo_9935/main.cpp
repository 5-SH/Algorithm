#include <iostream>
#include <stdio.h>
#include <stack>

using namespace std;

int main()
{
    string inputStr, bombStr;
    int bombSize, inputSize, stkSize;
    stack<char> stk;
    char outputStr[1000000];
    cin >> inputStr;
    cin >> bombStr;

    inputSize = inputStr.size();
    bombSize = bombStr.size();

    string restStr(bombSize, ' ');

    for (int i = 0; i < inputSize; i++) {
        stk.push(inputStr[i]);
        if (stk.top() == bombStr[bombSize-1] && stk.size() >= bombSize) {
            for (int j = bombSize - 1; j >= 0; j--) {
                restStr[j] = stk.top();
                stk.pop();
            }
            if (restStr.compare(bombStr) != 0) {
                for (int j = 0; j < bombSize; j++) {
                    stk.push(restStr[j]);
                }
            }
        }


    }

    if (stk.size() == 0) cout << "FRULA";
    else {
        stkSize = stk.size();
        for(int i = stkSize - 1; i >= 0; i--) {
            outputStr[i] = stk.top();
            stk.pop();
        }
        for(int i = 0; i < stkSize; i++) {
            cout << outputStr[i];
        }
    }
    return 0;
}
