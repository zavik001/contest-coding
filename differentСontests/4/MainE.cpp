#include <iostream>
#include <vector>
using namespace std;

struct Rectangle {
    int x1, y1, x2, y2;
};

bool doIntersect(const Rectangle& r1, const Rectangle& r2) {
    return (r1.x1 < r2.x2 && r1.x2 > r2.x1 && r1.y1 < r2.y2 && r1.y2 > r2.y1);
}

int main() {
    int n;
    cin >> n;
    vector<Rectangle> rectangles(n);
    vector<int> intersection_count(n, 0);

    for (int i = 0; i < n; ++i) {
        cin >> rectangles[i].x1 >> rectangles[i].y1 >> rectangles[i].x2 >> rectangles[i].y2;
    }

    for (int i = 0; i < n; ++i) {
        for (int j = 0; j < n; ++j) {
            if (i != j && doIntersect(rectangles[i], rectangles[j])) {
                intersection_count[i]++;
            }
        }
    }

    for (int count : intersection_count) {
        cout << count << " ";
    }
    cout << endl;

    return 0;
}
