#include <bits/stdc++.h>
using namespace std;

#define watch(x) cout << (#x) << " is " << (x) << endl
#define runtime() ((double)clock() / CLOCKS_PER_SEC)
#define SZ(x) ((int)(x).size())
#define FOR(i,s,e) for(int i=s; i<e; i++)
#define WL(t) while(t --)
#define LL long long int

typedef pair<int, int> PII;
typedef vector<int> VI;
typedef vector<string> VS;
typedef vector<PII> VII;
typedef vector<VI> VVI;
typedef map<int,int> MPII;
typedef set<int> SETI;
typedef multiset<int> MSETI;

const int MAXN = 1000005;
const int SQRTN = 1003;
const int LOGN = 22;
const double PI=acos(-1);
const int INF = 1000000000;
const int MOD = 1000000007;
const int FMOD = 998244353;
const double eps = 1e-9;

class fastio {
public:
    fastio() {
        ios_base::sync_with_stdio(false);
        cout.tie(nullptr);
        cin.tie(nullptr);
    }
} __fastio;
void solve() {

}
int main() {
    __fastio;
    int t; cin >> t;
    WL(t) {
        solve();
    }
    return 0;
}
