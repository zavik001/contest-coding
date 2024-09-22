#include <bits/stdc++.h>
#define f first
#define s second
#define int li

using namespace std;
using li = long long;

int32_t main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);

    int t;
    cin >> t;

    while(t--)
    {
        int n;
        cin >> n;

        vector<int> a(n);

        for(int i = 0; i < n; i++)
            cin >> a[i];

        int mx = -2e18, mn = 2e18;

        li s = 0;

        for(int i = 0; i < n; i++)
        {
            s += a[i];
            mn = min(1ll * mn, s / (i + 1));
        }

        s = 0;

        for(int i = n - 1; i >= 0; i--)
        {
            s += a[i];
            mx = max(1ll * mx, (s + n - i - 1) / (n - i));
        }

        cout << mx - mn << "\n";
    }
}
