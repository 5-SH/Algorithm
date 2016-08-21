#include <iostream>

using namespace std;

const int INF = 100000001;
const int trueVal = 1;
const int falseVal = 0;
#define MIN(x, y) ((x < y) ? x : y)

int main()
{
    int cityCount, busCount, cityStart, cityArrive, x, y, weightVal;
    int cityFull = 0;
    int minWeight = INF;
    int minStart, minArrive;

    cin >> cityCount >> busCount;

    int **weightArr = new int*[cityCount + 1];
    for (int i = 0; i <= cityCount; i++) {
        weightArr[i] = new int[cityCount + 1];
    }
    int *sArr = new int[cityCount + 1];
    int *distanceArr = new int[cityCount + 1];

    for (int i = 0; i <= cityCount; i++) {
            for (int j = 0; j <= cityCount; j++) {
                if (i == j)
                    weightArr[i][j] = 0;
                else
                    weightArr[i][j] = INF;
            }
    }

    for (int i = 0; i < busCount; i++) {
        cin >> x >> y >> weightVal;
        if (weightVal < weightArr[x][y])
            weightArr[x][y] = weightVal;
    }

    cin >> cityStart >> cityArrive;
    for (int i = 0; i <= cityCount; i++) {
        sArr[i] = falseVal;
        distanceArr[i] = INF;
    }
    sArr[cityStart] = trueVal;
    for (int i = 1; i <= cityCount; i++) {
        distanceArr[i] = weightArr[cityStart][i];
    }
    sArr[cityStart] = trueVal;

    for (int i = 0; i < cityCount - 1; i++) {
        minWeight = INF;
        for (int i = 1; i <= cityCount; i++) {
            if (sArr[i] == falseVal && distanceArr[i] < minWeight)
                minArrive = i, minWeight = distanceArr[i];
        }
        sArr[minArrive] = trueVal;

        for (int i = 1; i <= cityCount; i++) {
            if (sArr[i] == falseVal) {
                distanceArr[i] = MIN(distanceArr[i], distanceArr[minArrive] + weightArr[minArrive][i]);
            }
        }
    }

    cout << distanceArr[cityArrive];
    return 0;
}
