#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int dpArr[2][100000];
int inputArr[2][100000];

int main()
{
    int T = 0, n = 0, resultVal;

    cin >> T;

    for (int t = 0; t < T; t++) {
        cin >> n;

        resultVal = 0;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                dpArr[i][j] = 0;
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                scanf("%d", &inputArr[i][j]);
                //cin >> inputArr[i][j];
            }
        }

        dpArr[0][0] = inputArr[0][0];
        dpArr[1][0] = inputArr[1][0];

        for (int i = 1; i < n; i++) {
            if (i == 1) {
                dpArr[0][i] = max(dpArr[1][0] + inputArr[0][1], dpArr[0][0]);
                dpArr[1][i] = max(dpArr[0][0] + inputArr[1][1], dpArr[1][0]);
            }
            else {
                dpArr[0][i] = max(max(dpArr[1][i - 1] + inputArr[0][i], dpArr[0][i - 1]), dpArr[1][i - 2] + inputArr[0][i]);
                dpArr[1][i] = max(max(dpArr[0][i - 1] + inputArr[1][i], dpArr[1][i - 1]), dpArr[0][i - 2] + inputArr[1][i]);
            }
        }

        resultVal = max(dpArr[0][n - 1], dpArr[1][n - 1]);
        cout << resultVal << endl;
    }
    return 0;
}
