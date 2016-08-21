#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

typedef tuple <int, int, int> pos;

int main()
{
    int tomatoNum = 0, matured = 0, day = -1;
    int H, N, M, in;
    int queSize = 0, h, m, n;
    pos tempPos;
    int ***box;
    queue <pos> que;

    scanf("%d %d %d", &M, &N, &H);
    box = new int**[H];
    for (int i = 0; i < H; i++) {
        box[i] = new int*[N];
        for (int j = 0; j < N; j++) {
            box[i][j] = new int[M];
        }
    }
    for (int i = 0; i < H; i++) {
        for (int j = 0; j < N; j++) {
            for (int k = 0; k < M; k++) {
                scanf("%d", &in);
                box[i][j][k] = in;
                if (in != -1)
                    tomatoNum++;
                if (in == 1) {
                    que.push(make_tuple(i, j, k));
                }
            }
        }
    }

    while (!que.empty() && matured != tomatoNum) {
        queSize = que.size();
        for (int i = 0; i < queSize; i++) {
            tempPos = que.front();
            que.pop();
            h = get<0>(tempPos), n = get<1>(tempPos), m = get<2>(tempPos);
            if (h + 1 < H && box[h + 1][n][m] == 0) {
                que.push(make_tuple(h + 1, n, m));
                box[h + 1][n][m] = 1;
            }
            if (h - 1 >= 0 && box[h - 1][n][m] == 0) {
                que.push(make_tuple(h - 1, n, m));
                box[h - 1][n][m] = 1;
            }
            if (n - 1 >= 0 && box[h][n - 1][m] == 0) {
                que.push(make_tuple(h, n - 1, m));
                box[h][n - 1][m] = 1;
            }
            if (n + 1 < N && box[h][n + 1][m] == 0) {
                que.push(make_tuple(h, n + 1, m));
                box[h][n + 1][m] = 1;
            }
            if (m - 1 >= 0 && box[h][n][m - 1] == 0) {
                que.push(make_tuple(h, n, m - 1));
                box[h][n][m - 1] = 1;
            }
            if (m + 1 < M && box[h][n][m + 1] == 0) {
                que.push(make_tuple(h, n, m + 1));
                box[h][n][m + 1] = 1;
            }

            matured++;
        }
        day++;
    }

    if (matured == tomatoNum) cout << day << endl;
    else cout << -1 << endl;

    return 0;
}
