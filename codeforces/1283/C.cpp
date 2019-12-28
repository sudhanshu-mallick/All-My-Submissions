#include <bits/stdc++.h>
#define int int64_t
#define F first
#define S second
#define forn(i,n) for(int32_t i=0;i<(n);++i)
 
using namespace std;
const int N = 2e5+5;
const int INF = 1e18+7;
const int MOD = 1e9+7;
 
int a[N];
int b[N];
 
int32_t main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(0); cout.tie(0);
//    freopen("input.txt","r",stdin);
//    freopen("output.txt","w",stdout);
    int n; cin>>n;
    forn(i,n){
        cin>>a[i];
        b[a[i]]=1;
    }
    set<int> s;
    for(int i=1;i<=n;i++){
        if(b[i]==0) s.insert(i);
    }
    for(int i=0;i<n;i++){
        if(a[i]==0){
            if(s.count(i+1)==1){
                int t1=*s.begin();
                int t2=*--s.end();
                if(t1!=i+1){
                    a[i]=t1;
                    s.erase(t1);
                }else if(t2!=i+1){
                    a[i]=t2;
                    s.erase(t2);
                }
            }
        }
    }
    for(int i=0;i<n;i++){
        if(a[i]==0){
            int t1=*s.begin();
            int t2=*--s.end();
            if(t1!=i+1){
                a[i]=t1;
                s.erase(t1);
            }else{
                a[i]=t2;
                s.erase(t2);
            }
        }
    }
    for(int i=0;i<n;i++) cout<<a[i]<<" ";
}