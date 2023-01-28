#include <iostream>
#include <map>
#include <vector>
#include <math.h>
#include <set>
using namespace std;

bool visited[1000002];
vector<int> sosu_list;
set<int> sosu_pack;
int n;

int get_twonum(int n)
{
    for (int i = 0; i < sosu_list.size(); i++)
    {
        int first = sosu_list[i];
        int second = n - first;
        if (sosu_pack.find(second) != sosu_pack.end())
        {
            cout<<first << " " << second << '\n';
            return 1;
        }
    }
    return -1;;
}

int main()
{
    cin>>n;
    
    for(int i = 0; i <= n; i++)
    {
        visited[i] = true;
    }

    for (int i = 2; i*i <= n; i++)
    {
        for (int j = i * 2; j <= n; j+=i)
        {
            visited[j] = false;
        }
    }

    for (int i = 2; i <= n; i++)
    {
        if (visited[i] == true)
        {
            sosu_list.push_back(i);
            sosu_pack.insert(i);
        }
    }

    if (n < 8)
    {
        cout<<-1<<'\n';
        return 0;
    }

    if (n % 2 == 1)
    {
        cout<<"2 3 ";
        n -= 5;
    }
    else 
    {
        cout<<"2 2 ";
        n-= 4;
    }
    int x = get_twonum(n);
    if (x == -1)
        cout<< -1;

    return 0;
}
