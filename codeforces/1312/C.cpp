#pragma GCC optimize("O3")
#include<bits/stdc++.h>
#include<algorithm>
#include<unordered_map>
using namespace std;
#define ll          long long int
#define pb          push_back
#define pob         pop_back
#define ins         insert
#define fi          first
#define se          second
#define inf         LLONG_MAX
#define rep(a,b,c)  for(ll i=a;i<b;i=i+c)
#define repd(a,b,c) for(ll i=a;i>b;i=i-c)
#define Arena       ios_base::sync_with_stdio(0);cin.tie(0);cout.tie(0);
#define pii         pair<ll,ll>
#define mod         1000000007 
#define N           1000000
ll solve(){
    ll n,k;
    cin>>n>>k;
    ll arr[n];
    for(ll i=0;i<n;i++){
        cin>>arr[i];
    }
    ll cnt[100];
    memset(cnt,0,sizeof(cnt));
    for(ll i=0;i<n;i++){
        ll a=arr[i];
        ll b;
        ll c=0;
        while(a){
            b=a%k;
            if(b!=1 && b!=0){
                cout<<"NO"<<endl;
                return 0;
            }
            else{
                if(b==1 && cnt[c]==1){
                    cout<<"NO"<<endl;
                    return 0;
                }
                if(b==1){cnt[c]=1;}
            }
            c++;
            a=a/k;
        }
    }
    cout<<"YES"<<endl;
}
int main(){
    Arena
    ll t;
    cin>>t;
    while(t){
        solve();
        t--;
    }
    return 0;
}