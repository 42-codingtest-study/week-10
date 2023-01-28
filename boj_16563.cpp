#include <iostream>
#include <vector>

using namespace std;

int minfactor[5000001];
vector<int> result;
vector<int> sosu_list;

void get_soinsoo(int tmp)
{
    while(tmp > 1)
    {
        result.push_back(minfactor[tmp]);
        tmp /= minfactor[tmp];
    }
}



int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    int n;
    //vector<int> arr;
    
    
    minfactor[0] = minfactor[1] = -1;
    for (int i = 2; i <= 5000000; i++)
    {
        minfactor[i] = i;
    }
    for (int i =2 ; i*i <= 5000000; i++)
    {
        if (minfactor[i] == i)
        {
            for (int j = i*i; j <= 5000000; j+=i)
            {
                if (minfactor[j] == j)
                    minfactor[j] = i;
            }
        }
    }
    for (int i = 2; i <= 5000000; i++)
    {
        if (minfactor[i] == i)
            sosu_list.push_back(i);
    }

    cin>>n;
    
    for (int i = 0; i < n; i++)
    {
        int tmp;
        cin>>tmp;
        result.clear();
        get_soinsoo(tmp);
        for (int j = 0; j < result.size(); j++)
        {
            cout<< result[j] << ' ';
        }
        cout<<'\n';
    }
    return 0;
}