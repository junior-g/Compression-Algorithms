#include<bits/stdc++.h>
    using namespace std;

    ///***********SICK BOY******************///
    #define uli unsigned long long int
    ///***input******// for +ve int
    inline uli in() {
        uli p=0; register char ch=0;
        while(ch<'0' or ch>'9') {ch=getchar();}
        while(ch>='0' and ch<='9') {p=(p<<1)+(p<<3)+ch-'0'; ch=getchar();}
        return p;
    }
    ///***output*****// for +ve int
    #define pc(x) putchar(x)
    inline void dukya(uli n){
            uli N = n, rev, count_ = 0;
            rev = N;
            if (N == 0) { pc('0'); pc('\n'); return ;}
            while ((rev % 10) == 0) { count_++; rev /= 10;}
            rev = 0;
            while (N != 0) { rev = (rev<<3) + (rev<<1) + N % 10; N /= 10;}
            while (rev != 0) { pc(rev % 10 + '0'); rev /= 10;}
            while (count_--) pc('0');
           pc('\n');
        }
    ///
    #define li  long long int
    #define ld  long double
    #define chal(n) for(li i=0;i<n; ++i)
    #define ot(n) cout<<n<<"\n"
    #define vi vector<li>
    #define ii pair<li, li>
    #define ict int test_case=in(); while(test_case--)
    #define INF 1000000000009
    #define mod 1000000007
    #define fastScan ios_base::sync_with_stdio(0); cin.tie(NULL); cout.tie(NULL)
    ///***************SICK BOY*************************//


int main(){

 string s;
 ot("Enter the string to encode");
 cin>>s;

 string encoded_string;

 li co=1;
 char ch=s[0];

  for(int i=1; i<s.size(); ++i)
  {
    if(ch!=s[i])
        {
        encoded_string.push_back(co+'0');
        encoded_string.push_back(ch);
        ch=s[i];
        co=1;
        }
        else
        {
        ++co;
        }
  }
  encoded_string.push_back(co+'0');
  encoded_string.push_back(ch);

  ot("Encoded String->"<<encoded_string);

  string decoded_string;
  for(li i=0; i<encoded_string.size(); i+=2)
  {
   for(li j=0; j<(encoded_string[i]-'0');++j)
   {
   decoded_string.push_back(encoded_string[i+1]);
   }
  }
  ot("decoded String->"<<decoded_string);


	return 0;
}
