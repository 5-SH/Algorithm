#include <iostream>
#include <string>

using namespace std;

int main()
{
    int smallestIndex = 0, differ = 24, inputSize, k = 0;
    string inputStr, str1, str2;
    cin >> inputStr;
    //string inputStr = "baekjoon";
    inputSize = inputStr.size();
    int *maskingArr = new int[inputStr.size()];

    for (int i = 0; i <inputSize; i++) {
        for (int j = 0; j < inputSize; j++) {
            if (maskingArr[j] != 1) {
               if (inputStr.substr(j).compare(inputStr.substr(smallestIndex)) <= 0) {
                    smallestIndex = j;
               }
            }
        }
        maskingArr[smallestIndex] = 1;
        cout << inputStr.substr(smallestIndex);
        if (i < inputSize - 1) {
            cout << endl;
        }
        smallestIndex = 0;
        while(1) {
            if (maskingArr[smallestIndex] == 0) {
                break;
            }
            smallestIndex++;
        }
    }
    return 0;
}
