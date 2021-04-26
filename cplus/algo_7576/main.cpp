#include <iostream>
#include <algorithm>
#include <queue>
#include <utility>

using namespace std;

int main()
{
    int n, m, queSize = 0, day = 0;
    queue <pair <int, int> > que;
    pair <int, int> temp;
    cin >> m >> n;

    int **box = new int*[n];
    int **queCheck = new int*[n];
    for (int i = 0; i < n; i++) {
        box[i] = new int[m];
    }
    for (int i = 0; i < n; i++) {
        queCheck[i] = new int[m];
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            scanf("%d", &box[i][j]);
            if (box[i][j] == 1) {
                que.push(make_pair(i, j));
                queCheck[i][j] = 1;
            }
        }
    }

    while (!que.empty()) {
        queSize = que.size();
        for (int i = 0; i < queSize; i++) {
            temp = make_pair(que.front().first, que.front().second);
            if (temp.second - 1 >= 0 && box[temp.first][temp.second - 1] == 0 && queCheck[temp.first][temp.second - 1] != 1) {
                que.push(make_pair(temp.first, temp.second - 1));
                queCheck[temp.first][temp.second - 1] = 1;
            }
            if (temp.second + 1 < m && box[temp.first][temp.second + 1] == 0 && queCheck[temp.first][temp.second + 1] != 1) {
                que.push(make_pair(temp.first, temp.second + 1));
                queCheck[temp.first][temp.second + 1] = 1;
            }
            if (temp.first - 1 >= 0 && box[temp.first - 1][temp.second] == 0 && queCheck[temp.first - 1][temp.second] != 1) {
                que.push(make_pair(temp.first - 1, temp.second));
                queCheck[temp.first - 1][temp.second] = 1;
            }
            if (temp.first + 1 < n && box[temp.first + 1][temp.second] == 0 && queCheck[temp.first + 1][temp.second] != 1) {
                que.push(make_pair(temp.first + 1, temp.second));
                queCheck[temp.first + 1][temp.second] = 1;
            }

            box[temp.first][temp.second] = 1;
            que.pop();
        }
        day++;
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (box[i][j] == 0) {
                cout << -1 << endl;
                return 0;
            }
        }
    }

    cout << day - 1 << endl;

    return 0;
}
