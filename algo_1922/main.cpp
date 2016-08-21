#include <iostream>
#include <queue>
#include <vector>
#include <tuple>
#include <functional>

using namespace std;

typedef tuple <int, int, int> edge;

vector <int> parent(1001, -1);
vector <int> number(1001, 1);

void setUnion (int v1, int v2) {
    if (number[v1] < number[v2]) {
        parent[v1] = v2;
        number[v2] += number[v1];
    }
    else {
        parent[v2] = v1;
        number[v1] += number[v2];
    }
}

int setFind (int v) {
    int i, p, r;
    for (i = v; (p = parent[i]) >= 0; i = p)
    ;
    r = i;
    for (i = v; (p = parent[i]) >= 0; i = p) {
        parent[i] = r;
    }

    return r;
}

struct cmp {
    bool operator() (edge e1, edge e2) {
        return (get<2>(e1) > get<2>(e2));
    }
};

int main()
{
    int vSize, eSize, v1, v2, w;
    int r1, r2, eCount = 0, cost = 0;
    priority_queue <edge, vector <edge>, cmp > pQ;

    cin >> vSize >> eSize;
    for (int i = 0; i < eSize; i++) {
        scanf("%d %d %d", &v1, &v2, &w);
        pQ.push(make_tuple(v1, v2, w));
    }

    while (eCount < vSize - 1) {
        edge temp = pQ.top();
        pQ.pop();
        r1 = setFind(get<0>(temp));
        r2 = setFind(get<1>(temp));

        if (r1 != r2) {
            eCount++;
            cost += get<2>(temp);
            setUnion(r1, r2);
        }
    }

    cout << cost << endl;
    return 0;
}
