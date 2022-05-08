#include <iostream>
#include <vector>
using namespace std;

int Partition(auto& unsorted_vector,int low,int high)
{
    int i = low,j = high+1;
    int val = unsorted_vector[low];
    while(true)
    {
        while(unsorted_vector[++i] < val)
        {if(i == high) break;}
        while(unsorted_vector[--j] > val)
        {if(j == low) break;}
        if(i >= j)  break;
        swap(unsorted_vector[i],unsorted_vector[j]);
    }
    swap(unsorted_vector[low],unsorted_vector[j]);
    return j;
}

void Quick_Sort(auto& unsorted_vector,int low,int high)
{
    if(low>=high)   return;
    int part = Partition(unsorted_vector,low,high);
    Quick_Sort(unsorted_vector,low,part-1);
    Quick_Sort(unsorted_vector,part+1,high);
}

int main()
{
    int temp,size;
    vector<int> unsorted_vector;
    cout<<"please input ur unsorted_list ~ '-1' is the stop symbol"<<endl;
    while(cin>>temp)
    {
        if(temp == -1)  break;
        unsorted_vector.push_back(temp);
    }

    size = unsorted_vector.size();
    Quick_Sort(unsorted_vector,0,size-1);

    cout<<"this is the sorted_vector numbers"<<endl;
    for(const auto& num:unsorted_vector)
        cout<<num<<' ';
    return 0;
}
