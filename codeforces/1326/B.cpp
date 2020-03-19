#include<iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(false); 
    cin.tie(NULL); 
    int n;
    cin>>n;
    long a[n];
    long b[n];
    long max=0;
    
    for(int i=0;i<n;i++){
        cin>>a[i];
        
        b[i]=a[i]+max;
        
        if(max<b[i])
        max=b[i];
        
        cout<<b[i]<<" ";
    }
}